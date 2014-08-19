<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div style="width: 100%; overflow: auto;" id=tableProjects>


						<table id="tbReportProject"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Status<i class="sort"></i>
									</th>
									<th>Erro<i class="sort"></i>
									</th>
									<th>Alteração de escopo<i class="sort"></i>
									</th>
									<th>Ações<i class="sort"></i>
									</th>
								</tr>

							</thead>
							<tbody>															
								<c:forEach items="${reportsProject}" var="report">
									<tr>
									<th>${report.descriptionStatus}</th>
									<td>${report.qtdError}</td>
									<td>${report.qtdAlterScope}</td>
									<td>${report.qtdRecurrence}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>