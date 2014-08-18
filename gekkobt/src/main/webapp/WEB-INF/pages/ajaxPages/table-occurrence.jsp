<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

		<div style="width: 100%; overflow: auto;" id="tableOccurrence">
								<table id="example" class="table table-bordered table-striped" >
									<thead>
										<tr>
											<th>ID<i class="sort"></i>
											</th>
											<th>Ações<i class="sort"></i>
											</th>
											<th>Nome do projeto<i class="sort"></i>
											</th>
											<th>Ocorrência<i class="sort"></i>
											</th>
											<th>Tipo de ocorrência<i class="sort"></i>
											</th>
											<th>Status<i class="sort"></i>
											</th>
											<th>Prioridade<i class="sort"></i>
											</th>
											<th>Data reportada<i class="sort"></i>
											</th>
											<th>Data resolvida<i class="sort"></i>
											</th>
											<th>Usuário<i class="sort"></i>
											</th>
											<th>Responsável<i class="sort"></i>
											</th>
										</tr>
									</thead>
									<tbody id="tableQuery">
										<c:set var="numberOfItems" value="${fn:length(occurrence)}" />
										<c:forEach items="${occurrence}" var="occurrence">
											<tr id="occurrence-${occurrence.id}">
												<td>${occurrence.id}</td>
												<td><img
													style="cursor: pointer; padding: 0px 0px 0px 17px;"
													src="<c:url value="/resources/img/alter.png"/>"
													title="Detalhe da ocorrência" id="1"
													onclick="openPage(${occurrence.id})"> <img
													style="cursor: pointer; padding: 0px 0px 0px 8px;"
													src="<c:url value="/resources/img/delete.png"/>"
													title="Excluir ocorrência" id="deleteOccurrence12"
													data-toggle="modal" data-target=".bs-example-modal-sm"
													onclick="setDeleteOccurrence(${occurrence.id})"
													id="${occurrence.id}"></td>
												<td>${occurrence.projectBean.projectName}</td>
												<td>${occurrence.occurrenceTitle}</td>
												<td>${occurrence.typeOccurrenceBean.occurenceType}</td>
												<td>${occurrence.statusBean.statusType}</td>
												<td>${occurrence.priorityBean.priorityType}</td>
												<td>${occurrence.inclusionDate}</td>
												<td>${occurrence.finalizationDate}</td>
												<td>${occurrence.occurrenceUserInclusionBean.userName}</td>
												<td>${occurrence.occurrenceUserResponsibleBean.userName}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							
							<div class="modal fade bs-example-modal-sm" id="deleteOccurrenceModal"
								tabindex="-1" role="dialog"
								aria-labelledby="deleteOccurrenceModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-sm">
									<div class="modal-content">
						
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="ModalLabel">Deletar ocorrência</h4>
										</div>
										<div class="modal-body" style="">
											<div>
						
												<div class="txt-fld">
													<label>Deseja realmente excluir a ocorrência: ID <span
														id="idExc"></span></label>
												</div>
												<br />
											</div>
											<div class="modal-footer">
												<div align="center">
													<button type="button" class="btn btn-primary"
														data-dismiss="modal">Não</button>
													<button id="submitFrmEditStatusOccurrence" type="submit"
														data-dismiss="modal" class="btn btn-primary"
														onclick="deleteOccurrence();">Sim</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>