<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.gekkobt.controller.ReportUserOccurrencesController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ocorrências por projeto</title>
<head title="DPT - Gerenciador de Parametros">

<c:import url="../taglibs/resources.jsp"></c:import>

</head>

<style type="text/css">
.includeOccurrence {
	padding-left: 20px;
}

label {
	cursor: text;
}

option {
	width: 314px;
}

select {
	width: 314px;
	cursor: default;
}

.not-visible {
	display: none;
}

.pos-absolute {
	position: absolute;
}

button {
	cursor: pointer;
}

</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#Id option:eq(1)').prop("selected", true);
		$("#footer").addClass('pos-absolute');
		$("#sidebar").accordion({
			collapsible : true
		});
	});
	
	
	$(document).on('click', '#filterReport', 
		function() {
		$.blockUI({ message: '<h4><img src="" /> Carregando...</h4>' });
		$.get("projectOccurrences/showTable", {
			Id : $("#Id").find(":selected").get(0).id,
		}, function(data) {
			obj = handleJSON(data);
			hasError = handleError(obj);
			if (!hasError) {
				$("#tableProjects").html(data);
				$.unblockUI();
			}
		});
	});
	
	$(document).on(
			'click',
			'#exportExcel',
			function () {
				window.open("projectOccurrences/excelReportProject?id=" + $("#Id").find(":selected").get(0).id, '_blank');
			});
	
</script>
</head>
<body>
	<!-- Header -->
	<c:import url="../taglibs/header.jsp"></c:import>
	<!-- Header -->

	<div id="body" style="padding: 4px;">
		<div id="content" style="padding: 5px;">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header"><br />
						<h1 style="color: gray;">Ocorrências por projeto</h1>
					</div>
					<div class="btn-group">
						<button data-toggle="dropdown" class="btn dropdown-toggle">
							<i class=" icon-external-link"></i> &nbsp;Exportar <span
								class="icon-sort-down"></span>
						</button>
						<ul class="dropdown-menu">
							<li><input align="justify" type="button" id="exportExcel"
								value="EXCEL"
								style="background: white; border-color: none; border: none; font-size: inherit; margin-left: 10px;">
							</li>
							<!-- <li><input align="justify" type="button" id="exportPDF"
								value="PDF"
								style="background: white; border-color: none; border: none; font-size: inherit; margin-left: 10px;">
							</li> -->
						</ul>
					</div><br><br>
					<div class="form-inline actions-toolbar">

						<div class="row-fluid actions-toolbar-inner"
							style="width: 99%;">

							<div class="span1" style="width: 75px;">Projeto</div>
							<div class="span1" style="width: 160px;">
								<select name="Id" style="width: 126px;"
									id="Id">
									<option value="">Todos...</option>
									<c:forEach items="${project}" var="project">
										<option id="${project.id}">
											<c:out value="${project.projectName}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="span2" style="margin-left: 60px; float: left;">
								<button class="btn btn-primary" id="filterReport">
									<i class="icon-filter icon-white"></i>&nbsp;Filtrar
								</button>
							</div>
						</div>


					</div >
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
									<th>Reincidência<i class="sort"></i>
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
				
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
		<c:import url="../taglibs/footer.jsp"></c:import>
	<!-- Footer -->
</body>
</html>
