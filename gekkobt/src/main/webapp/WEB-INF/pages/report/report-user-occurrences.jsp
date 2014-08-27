<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.gekkobt.controller.ReportUserOccurrencesController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ocorrências por usuário</title>
<head title="DPT - Gerenciador de Parametros">

<c:import url="../taglibs/resources.jsp"></c:import>

</head>
<style>
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
		 $("#footer").addClass('pos-absolute');
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
	
	$(document).on('click', '#filterReportUser',
	 		function() {
	 		$.blockUI({ message: '<h4><img src="" /> Carregando...</h4>' });
			$.get("userOccurrences/showTableUser", {
				responsibleId : $("#responsibleId").find(":selected").get(0).id,
			}, function(data) {
				obj = handleJSON(data);
				hasError = handleError(obj);
				if (!hasError) {
					$("#tableUsers").html(data);
					$.unblockUI();
				}
			});
		});
	
	$(document).on(
			'click',
			'#exportExcel',
			function () {
				window.open("userOccurrences/excelUserOccurrences?id=" + $("#responsibleId").find(":selected").get(0).id, '_blank');
			});
	
</script>

</head>
<body>
	<!-- Header -->
	<c:import url="../taglibs/header.jsp"></c:import>
	<!-- Header -->
	<form action="<c:url value="/userOccurrences/getUser"/>" id="meuFormulario" method="post">
		<input type="hidden" id="idDoUsuario" name="idUserSelected">
	</form>
	<div id="body" style="padding: 4px;">
		<div id="content" style="padding: 5px;">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header">
						<h1 style="color: gray;">Ocorrências por usuário</h1>
					</div>
					<div class="btn-group">
						<button data-toggle="dropdown" class="btn dropdown-toggle">
							<i class=" icon-external-link"></i> &nbsp;Exportar <span class="icon-sort-down"></span>
						</button>
						<ul class="dropdown-menu">
							<li><input align="justify" type="button" id="exportExcel" value="EXCEL" style="background: white; border-color: none; border: none; font-size: inherit; margin-left: 10px;"></li>
						</ul>
					</div>
					<br><br>
					<div class="form-inline actions-toolbar">
						<div class="row-fluid actions-toolbar-inner" style="width: 99%;">
							<div class="span1" style="width: 75px;">Usuário:</div>
							<div class="span1" style="width: 160px;">
								<select name="responsibleId" style="width: 126px;" id="responsibleId">
									<option value="">Todos...</option>
									<c:forEach items="${user}" var="user">
										<option id="${user.id}">
											<c:out value="${user.userName}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="span2" style="margin-left: 60px; float: left;">
								<button class="btn btn-primary" id="filterReportUser">
									<i class="icon-filter icon-white"></i>&nbsp;Filtrar
								</button>
							</div>
						</div>
					</div >
					<div style="width: 100%; overflow: auto;" id="tableUsers">
						<table id="example" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Usuário<i class="sort"></i></th>
									<th>Ocorrências criadas<i class="sort"></i></th>
									<th>Ocorrências resolvidas<i class="sort"></i></th>
									<th>Ocorrências pendentes<i class="sort"></i></th>
									<th>Ultima atualização<i class="sort"></i></th>
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
					<div class="row-fluid actions-toolbar">
						<div class="actions-toolbar-inner">
							<div class="span4">
								<div class="control-group">
									<label class="control-label" for="select01"> </label>
								</div>
							</div>
							<div class="span4">
								<p></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--  footer -->
	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>
<!--  footer -->
</body>
</html>