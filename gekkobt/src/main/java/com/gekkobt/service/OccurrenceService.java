package com.gekkobt.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gekkobt.bean.AnnexBean;
import com.gekkobt.bean.HistoricStatusBean;
import com.gekkobt.bean.OccurrenceBean;
import com.gekkobt.bean.OccurrenceFilterBean;
import com.gekkobt.bean.StatusBean;
import com.gekkobt.bean.UserBean;
import com.gekkobt.dao.AnnexDAO;
import com.gekkobt.dao.HistoricStatusDAO;
import com.gekkobt.dao.OccurrenceDAO;
import com.gekkobt.dao.PriorityDAO;
import com.gekkobt.dao.ProjectDAO;
import com.gekkobt.dao.StatusDAO;
import com.gekkobt.dao.TypeOccurrenceDAO;
import com.gekkobt.dao.db.entity.parser.AnnexEntityParse;
import com.gekkobt.dao.db.entity.parser.HistoricStatusEntityParse;
import com.gekkobt.dao.db.entity.parser.OccurrenceEntityParse;
import com.gekkobt.entity.AnnexEntity;
import com.gekkobt.entity.HistoricStatusEntity;
import com.gekkobt.entity.OccurrenceEntity;
import com.gekkobt.entity.UserEntity;
import com.gekkobt.enums.GekkoProperties;
import com.gekkobt.enums.Status;
import com.gekkobt.environment.EnvironmentVariables;
import com.gekkobt.util.ExcelParse;

@Service
@Transactional
public class OccurrenceService {

	@Autowired
	private OccurrenceDAO occurrenceDAO;

	@Autowired
	private TypeOccurrenceDAO typeOccurrenceDAO;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private PriorityDAO priorityDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private LoginService loginService;

	@Autowired
	private HistoricStatusDAO historicStatusDAO;

	@Autowired
	private AnnexDAO annexDAO;

	public List<OccurrenceBean> getAllOccurrences() {
		List<OccurrenceBean> list;

		list = new OccurrenceEntityParse()
				.entityToBean(occurrenceDAO.findAll());

		return list;
	}

	public OccurrenceBean includeOccurrence(UserBean userBean,
			OccurrenceBean occurrenceBean) {
		HistoricStatusBean historicStatusBean = new HistoricStatusBean();
		StatusBean statusBean = new StatusBean();
		String date = "include";

		statusBean.setStatusType(Status.PENDENTE.getStatusType());
		statusBean.setId(Status.PENDENTE.getId());

		GregorianCalendar calendar = new GregorianCalendar();
		OccurrenceEntityParse entityParse = new OccurrenceEntityParse();
		UserEntity userEntity = loginService.searchUserById(userBean);
		occurrenceBean.setInclusionDate(calendar.getTime());
		occurrenceBean.setOccurrenceDeleted(1);
		occurrenceBean.setStatusBean(statusBean);
		OccurrenceEntity occurrenceEntity = entityParse
				.beanToEntity(occurrenceBean);
		occurrenceEntity.setOccurrenceUserInclusionEntity(userEntity);
		
		occurrenceEntity = occurrenceDAO.save(occurrenceEntity);
		occurrenceBean = entityParse.entityToBean(occurrenceEntity);
		
		historicStatusBean.setHistoricDateChange(calendar.getTime());
		historicStatusBean.setHistoricJustification("ocorrência criada");
		historicStatusBean.setHistoricStatusBean(statusBean);
		historicStatusBean.setResponsibleChangeBean(userBean);
		historicStatusBean.setIdOccurrenceBean(occurrenceBean);
		
		
		try {
			alterStatus(userBean, historicStatusBean,date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return occurrenceBean;
	}

	public OccurrenceBean updateOccurrence(OccurrenceBean occurrenceBean, long hdnIdOcurrence)
			throws Exception {
		OccurrenceBean bean = findOccurrenceId(hdnIdOcurrence);
		bean.setOccurrenceDeleted(occurrenceBean.getOccurrenceDeleted());
		bean.setOccurrenceTitle(occurrenceBean.getOccurrenceTitle());
		bean.setOccurrenceDescription(occurrenceBean.getOccurrenceDescription());
		bean.setProjectBean(occurrenceBean.getProjectBean());
		bean.setOccurrenceUserResponsibleBean(occurrenceBean
				.getOccurrenceUserResponsibleBean());
		bean.setTypeOccurrenceBean(occurrenceBean.getTypeOccurrenceBean());
		bean.setPriorityBean(occurrenceBean.getPriorityBean());
	
		OccurrenceEntityParse entityParse = new OccurrenceEntityParse();
		OccurrenceEntity occurrenceEntity = entityParse.beanToEntity(bean);
		occurrenceEntity = occurrenceDAO.update(occurrenceEntity);
		return entityParse.entityToBean(occurrenceEntity);
	}
	
	public AnnexBean updateAnnex(AnnexBean annexBean, Long hdnIdAnnex)
			throws Exception {
		AnnexBean bean = findAnnexId(hdnIdAnnex);
		
		
		bean.setAnnexDeleted(annexBean.getAnnexDeleted());
		bean.setFileExtension(annexBean.getFileExtension());
		bean.setFileName(annexBean.getFileName());
		bean.setFilePath(annexBean.getFilePath());
		bean.setInclusionDate(annexBean.getInclusionDate());
	
		AnnexEntityParse entityParse = new AnnexEntityParse();
		AnnexEntity annexEntity = entityParse.beanToEntity(bean);
		annexEntity = annexDAO.update(annexEntity);
		
		return entityParse.entityToBean(annexEntity);
	}

	public OccurrenceBean updateOccurrenceStatus(OccurrenceBean occurrenceBean,
			StatusBean status) throws Exception {

		OccurrenceBean bean = findOccurrenceId(occurrenceBean.getId());
		bean.setStatusBean(status);
		bean.setFinalizationDate(occurrenceBean.getFinalizationDate());

		OccurrenceEntityParse entityParse = new OccurrenceEntityParse();

		OccurrenceEntity occurrenceEntity = entityParse.beanToEntity(bean);

		occurrenceEntity = occurrenceDAO.update(occurrenceEntity);
		return entityParse.entityToBean(occurrenceEntity);
	}

	public HistoricStatusBean alterStatus(UserBean userBean,
			HistoricStatusBean historicStatusBean,String dataStr) throws Exception {
		
		OccurrenceBean occurrenceBean = new OccurrenceBean();
		
		if (dataStr != "include") {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
			java.sql.Date data = new java.sql.Date(format.parse(dataStr).getTime());  
			occurrenceBean.setFinalizationDate(data);
		}
		
		occurrenceBean.setId(historicStatusBean.getIdOccurrenceBean().getId());
		occurrenceBean.setStatusBean(historicStatusBean.getHistoricStatusBean());
		updateOccurrenceStatus(occurrenceBean, historicStatusBean.getHistoricStatusBean());

		UserEntity userEntity = loginService.searchUserById(userBean);
		GregorianCalendar calendar = new GregorianCalendar();
		HistoricStatusEntityParse entityParse = new HistoricStatusEntityParse();
		
		
		
		historicStatusBean.setHistoricDateChange(calendar.getTime());
		historicStatusBean.setIdOccurrenceBean(occurrenceBean);

		HistoricStatusEntity historicStatusEntity = entityParse
				.beanToEntity(historicStatusBean);
		historicStatusEntity.setResponsibleChangeEntity(userEntity);
		historicStatusEntity = historicStatusDAO.save(historicStatusEntity);

		return entityParse.entityToBean(historicStatusEntity);
	}

	public void deleteOccurrence(long idOccurrenceBean) throws Exception {
		OccurrenceBean bean = findOccurrenceId(idOccurrenceBean);
		bean.setOccurrenceDeleted(0);
		updateOccurrence(bean,idOccurrenceBean);
	}

	public void deleteAnnex(long idOccurrenceBean) throws Exception {
		AnnexBean bean = findAnnexId(idOccurrenceBean);
		bean.setAnnexDeleted(0);
		updateAnnex(bean,idOccurrenceBean);
	}
	

	public List<OccurrenceBean> findAll() {
		List<OccurrenceBean> list;

		list = new OccurrenceEntityParse().entityToBean(occurrenceDAO.findAll(
				"id", false));

		return list;
	}

	public OccurrenceBean findOccurrenceId(Long id) throws Exception {
		OccurrenceBean bean = new OccurrenceEntityParse()
				.entityToBean(occurrenceDAO.findById(id));

		return bean;
	}
	
	
	public AnnexBean findAnnexId(Long id) throws Exception {
		AnnexBean bean = new AnnexEntityParse()
				.entityToBean(annexDAO.findById(id));

		return bean;
	}
	
	public OccurrenceEntity findOccurrenceIdEntity(Long id) throws Exception {
		OccurrenceEntity entity = occurrenceDAO.findById(id);

		return entity;
	}
	
	public List<OccurrenceBean> filterOccurrences(OccurrenceFilterBean bean, Integer paginationParam,Long IdUserlogged)
			throws ParseException {
		
		List<OccurrenceEntity> list = occurrenceDAO.filterOccurrences(bean, paginationParam,IdUserlogged);
		
		return new OccurrenceEntityParse().entityToBean(list);
	}
	
	public Long sizeOfList(OccurrenceFilterBean bean,Long IdUserlogged){
			
		
		return occurrenceDAO.sizeOfList(bean,IdUserlogged);
	}
	
	
	public AnnexBean upload(MultipartFile file,long IdOcurrence,
			UserBean userBean) throws Exception {
		AnnexBean annexBean = new  AnnexBean();
		OccurrenceBean occurrenceBean = new OccurrenceBean();
		GregorianCalendar calendar = new GregorianCalendar();
		AnnexEntityParse entityParse = new AnnexEntityParse();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		String uploadPath = EnvironmentVariables.getDashboardProperties()
				.getValue(GekkoProperties.UPLOADPATH.getValue());
		String fileName = FilenameUtils.getBaseName(file.getOriginalFilename());
		String extension = FilenameUtils.getExtension(file
				.getOriginalFilename());
		
		String fileFullPathName = uploadPath + "\\" + fileName
				+ dateFormat.format(new Date()) + "." + extension;
		File fileTransfer = new File(fileFullPathName);

		try {

			fileTransfer.mkdirs();

			UserEntity userEntity = loginService.searchUserById(userBean);
			occurrenceBean.setId(IdOcurrence);
			annexBean.setInclusionDate(calendar.getTime());
			annexBean.setAnnexDeleted(1);
			annexBean.setFileName(fileName);
			annexBean.setFileExtension(extension);
			annexBean.setFilePath(fileFullPathName);
			annexBean.setOccurrenceBean(occurrenceBean);
			AnnexEntity annexEntity = entityParse.beanToEntity(annexBean);
			annexEntity.setUserEntity(userEntity);
			annexEntity = annexDAO.save(annexEntity);
			if (fileTransfer.exists()) {
				try {
					file.transferTo(fileTransfer);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;

	}
	
	public void ExportExcel(String title, List<OccurrenceBean> list) {
		ExcelParse excelParse = new ExcelParse();
		
		excelParse.exportExcel(title, list);
	}

}