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
		$.unblockUI();
		$('#Id option:eq(1)').prop("selected", true);
		$("#footer").addClass('pos-absolute');
		$("#sidebar").accordion({
			collapsible : true
		});

		$('#tbBankAccount').flexigrid({
			width : 799,
			singleSelect : true,
			buttons : [ {
				name : 'Adicionar',
			}, {
				separator : true
			}, {
				name : 'Aprovar',
			}, {
				separator : true
			} ]
		});

	function ExibeTelaSemMenu(nomeTela) {
		$("#body").empty();
		$.each(nomeTela.split(','), function(index, nomeTela) {
			$.get(nomeTela, function(data) {
				$("#body").append(data);
				$(".body").datepicker();
			});
		});
	}
	

	$(document).on('click', '#filterReport', function() {
		$.get("projectOccurrences/showTable", {
			Id : $("#Id").find(":selected").get(0).id,
		}, function(data) {
			obj = handleJSON(data);
			hasError = handleError(obj);
			if (!hasError) {
				$("#tableProjects").html(data);
			}
		});
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
						<h1>Ocorrências por projeto</h1>
					</div>
					
					<div class="form-inline actions-toolbar">

						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">

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
				
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
		<c:import url="../taglibs/footer.jsp"></c:import>
	<!-- Footer -->
</body>
</html>
