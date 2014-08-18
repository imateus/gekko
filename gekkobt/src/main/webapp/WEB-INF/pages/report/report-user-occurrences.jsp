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
	/* $(document).ready(function() { */
	/* alert('${dataChange.dataChange}');
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
	}); */

	/* 		$("#btnFiltrar").click(function() {
	 var idSelected = $("#responsibleId").val();
	 $("#idDoUsuario").val(idSelected);
	 $("#meuFormulario").submit();
	 });
	 });
	 */
	 
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
</script>

</head>
<body>
	<!-- Header -->
	<c:import url="../taglibs/header.jsp"></c:import>
	<!-- Header -->
	<form action="<c:url value="/userOccurrences/getUser"/>"
		id="meuFormulario" method="post">
		<input type="hidden" id="idDoUsuario" name="idUserSelected">
	</form>
	<div id="body" style="padding: 4px;">
		<div id="content" style="padding: 5px;">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header">
						<h1>Ocorrências por usuário</h1>
					</div>
					<form class="form-inline actions-toolbar">

						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">
							<div class="span1" style="width: 110px;">Usuário:</div>

							<div class="span1" style="width: 160px;">
								<select name="responsibleId" style="width: 126px;"
									id="responsibleId">
									<option value="">Todos...</option>
									<c:forEach items="${user}" var="user">
										<option value="${user.id}">
											<c:out value="${user.userName}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<%-- <div class="span1" style="width: 75px;">Projetos:</div>
							<div class="span1" style="width: 160px;">
								<select name="user" style="width: 126px;" id="user">
									<option value="">Selecione...</option>
									<c:forEach items="${project}" var="project">
										<option value="${project.id}">
											<c:out value="${project.projectName}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div> --%>
							<div class="span2" style="margin-left: 60px; float: right;">
								<button class="btn btn-primary" id="btnFiltrar">
									<i class="icon-filter icon-white"></i>&nbsp;Filtrar
								</button>
								<button class="btn">
									<i class="icon-remove"></i>&nbsp;Limpar
								</button>
							</div>
						</div>

					</form>
					<div style="width: 100%; overflow: auto;">
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

	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>

</body>
</html>