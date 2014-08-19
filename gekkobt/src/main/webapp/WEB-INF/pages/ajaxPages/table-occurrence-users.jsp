<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div style="width: 100%; overflow: auto;" id="tableUsers">
						<table id="example" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Usuário<i class="sort"></i>
									</th>
									<th>Ocorrências criadas<i class="sort"></i>
									</th>
									<th>Ocorrências resolvidas<i class="sort"></i>
									</th>
									<th>Ocorrências pendentes<i class="sort"></i>
									</th>
									<th>Ultima atualização<i class="sort"></i>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reports}" var="report">
									<tr>
										<td>${report.responsibleName}</td>
										<td>${report.qtdIncluida}</td>
										<td>${report.qtdFinalizado}</td>
										<td>${report.qtdPendende}</td>
										<td>${report.dataChange}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>