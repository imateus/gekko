package com.gekkobt.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gekkobt.bean.AnnexBean;
import com.gekkobt.dao.AnnexDAO;
import com.gekkobt.dao.db.entity.parser.AnnexEntityParse;
import com.gekkobt.entity.AnnexEntity;

@Service
@Transactional
public class AnnexService {

	@Autowired
	private AnnexDAO annexDAO;

	public List<AnnexBean> findAll() {
		List<AnnexBean> list;

		list = new AnnexEntityParse().entityToBean(annexDAO.findAll());

		return list;
	}

	public AnnexBean findProjectId(Long id) throws Exception {
		AnnexBean bean = new AnnexEntityParse().entityToBean(annexDAO
				.findById(id));

		return bean;
	}

	public List<AnnexBean> filterAnnex(AnnexBean bean) throws ParseException {

		List<AnnexEntity> list = annexDAO.filterAnnex(new AnnexEntityParse()
				.beanToEntity(bean));

		return new AnnexEntityParse().entityToBean(list);
	}

	public void deleteAnnex(long idAnnexBean) throws Exception {
		AnnexBean bean = findAnnexId(idAnnexBean);
		bean.setAnnexDeleted(0);
		AnnexEntityParse entityParse = new AnnexEntityParse();
		AnnexEntity annexEntity = entityParse.beanToEntity(bean);
		annexEntity = annexDAO.save(annexEntity);
	}

	public AnnexBean findAnnexId(Long id) throws Exception {
		AnnexBean bean = new AnnexEntityParse().entityToBean(annexDAO
				.findById(id));

		return bean;
	}

}