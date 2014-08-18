<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<c:import url="../taglibs/resources.jsp"></c:import>

<style type="text/css">
.includeOccurrence {
	padding-left: 20px;
}

label {
	cursor: text;
}

.inputText {
	width: 300px;
}

option {
	padding-left: 20px;
}

.labelModalAlterStatus {
	width: 300px;
}

select {
	width: 314px;
	cursor: default;
}

.titleMaintenance {
	position: relative;
	top: 0px;
	padding: 6px 5px 5px 20px;
}

/* exemplo form-citi */
/* .control-group:first-child {
	background: none repeat scroll 0 0 transparent;
	padding-top: 0;
}

.control-group {
	background: url("../resources/img/BG-dotted-light.gif") repeat-x scroll
		0 0 transparent;
	margin-bottom: 0;
	padding: 8px 0;
}

fieldset {
	padding: 0;
	margin: 0;
	border: 0;
}

.form-container fieldset {
	padding: 20px 20px 0;
}

element.style {
	
}

.form-container fieldset {
	padding: 20px 20px 0;
}

fieldset {
	padding: 0;
	margin: 0;
	border: 0;
}

.form-container {
	border: 1px solid #cccc;
	font-size: 12px;
	margin: 0;
}

element.style {
	
}

.row-fluid [class*="span"]:first-child {
	margin-left: 0;
}

.row-fluid .span9 {
	width: 74.46808510638297%;
}

.row-fluid [class*="span"] {
	display: block;
	width: 100%;
	min-height: 26px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	float: left;
	margin-left: 2.127659574468085%;
}

.span9 {
	width: 700px;
}

[class*="span"] {
	float: left;
	min-height: 1px;
	margin-left: 20px;
}

user agent stylesheetdiv {
	display: block;
}

Inherited from body
body {
	color: #53565A;
}

body {
	margin: 0;
	font-family: Arial, sans-serif;
	font-size: 12px;
	line-height: 16px;
	color: #3b3d3f;
	background-color: #ffffff;
}

Inherited from html
html {
	font-size: 100%;
	-webkit-text-size-adjust: 100%;
	-ms-text-size-adjust: 100%;
} */
</style>

<script>
	$(document).on(
			'click',
			'#submitFrmNewOccurrence',
			function() {
				var url = null;

				if ($("#hdn-id-ocurrence").val() == null
						|| $("#hdn-id-ocurrence").val() == "") {
					url = "insert";
				} else {
					url = "update";
				}
				$.post(url, {

					id : $("#hdn-id-ocurrence").val(),

					occurrenceTitle : $("#occurrenceTitle").val(),
					occurrenceDescription : $("#occurrenceDescription").val(),
					"occurrenceUserResponsibleBean.id" : $("#users").find(
							":selected").get(0).id,
					"statusBean.id" : $("#statusOccurrenceEdit").find(
							":selected").get(0).id,
					"priorityBean.id" : $("#typesPriority").find(":selected")
							.get(0).id,
					"projectBean.id" : $("#listProjects").find(":selected")
							.get(0).id,
					"typeOccurrenceBean.id" : $("#typesOccurrences").find(
							":selected").get(0).id,

				}, function(data) {
					obj = handleJSON(data);
					hasError = handleError(obj);
					window.location.href = "maintenance?id=" + $("#id").val();
					if (!hasError) {
						$("#hdn-id-ocurrence").val(obj.id);
					}
				});
			});

	$(document).on(
			'click',
			'#submitFrmEditStatusOccurrence',
			function() {
				$.post("alterStatus", {
					id : $("#hdn-id-ocurrence").val(),
					'idOccurrenceBean.id' : $("#id").val(),
					historicJustification : $("#historicJustification").val(),
					"historicStatusBean.id" : $("#statusOccurrenceEdit").find(
							":selected").get(0).id,
				}, function(data) {
					obj = handleJSON(data);
					hasError = handleError(obj);
					window.location.href = "maintenance?id=" + $("#id").val();
					if (!hasError) {
						$("#hdn-id-ocurrence").val(obj.id);
					}
				});
			});

	$(document).on(
			'click',
			'#submitFrmEditOccurrence',
			function() {
				if ($('#id').val() == null) {
					$('#id').prop('disabled', true);
					$('#statusOccurrenceForm').prop('disabled', true);
				} else {
					$('#id').prop('disabled', true);
					$('#statusOccurrenceForm').prop('disabled', true);
					$('#listProjects').prop('disabled', false);
					$('#profileType').prop('disabled', false);
					$('#occurrenceTitle').prop('disabled', false);
					$('#occurrenceDescription').prop('disabled', false);
					$('#users').prop('disabled', false);
					$('#typesOccurrences').prop('disabled', false);
					$('#typesPriority').prop('disabled', false);
					$("#TitlePageEdit").html("Alterar Ocorrência");
					$("#titleWindow").html("Alterar Ocorrência");
					$('#submitFrmEditOccurrence').hide();
					$('#listProjects option:eq(${occurrence.projectBean.id})')
							.prop("selected", true);
					$("#hdn-id-ocurrence").val("${occurrence.id}");
				}
			});

	$(document)
			.ready(
					function() {
						if ('${occurrence.id}' == '') {
							$('#buttonDiv').hide();
							$('#id').hide();
							$('#statusOccurrenceForm').hide();
							$("#TitlePageEdit").html("Inserir ocorrência");
							$("#titleWindow").html("Inserir ocorrência");
							$('#alteterStatus').hide();
						} else {
							$('#id').prop('disabled', true);
							$('#statusOccurrenceForm').prop('disabled', true);
							$('#listProjects').prop('disabled', true);
							$('#occurrenceTitle').prop('disabled', true);
							$('#occurrenceDescription').prop('disabled', true);
							$('#users').prop('disabled', true);
							$('#typesOccurrences').prop('disabled', true);
							$('#typesPriority').prop('disabled', true);
							$("#TitlePageEdit").html("Detalhe da ocorrência");
							$("#titleWindow").html("Detalhe da ocorrência");
							$(
									'#listProjects option:eq(${occurrence.projectBean.id})')
									.prop("selected", true);
							$(
									'#users option:eq(${occurrence.occurrenceUserResponsibleBean.id})')
									.prop("selected", true);
							$(
									'#typesOccurrences option:eq(${occurrence.typeOccurrenceBean.id})')
									.prop("selected", true);
							$(
									'#typesPriority option:eq(${occurrence.priorityBean.id})')
									.prop("selected", true);
							$(
									'#statusOccurrenceForm option:eq(${occurrence.statusBean.id})')
									.prop("selected", true);
							$(
									'#statusOccurrenceEdit option:eq(${occurrence.statusBean.id})')
									.prop("selected", true);
							$('#occurrenceTitle').val(
									"${occurrence.occurrenceTitle}");
							$('#occurrenceDescription').val(
									"${occurrence.occurrenceDescription}");
						}
					});

	function handleEnter(field, event) {
		alert("shd");
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
		if (keyCode == 13) {
			alert("shd");
			var i;
			for (i = 0; i < field.form.elements.length; i++)
				if (field == field.form.elements[i])
					break;
			i = (i + 1) % field.form.elements.length;
			field.form.elements[i].focus();
			return false;
		} else
			return true;
	}
</script>
<title id="titleWindow"></title>
</head>
<body>
	<!-- Header -->
	<c:import url="../taglibs/header.jsp"></c:import>
	<div id="main-nav" class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="authentication dropdown-toggle"> <i
						class="icon-lock icon-white" style="display: inline-block;"></i>Olá:
						${userLogged.userLogin} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/login/logout"><i
								class="icon-signout"></i>Sair</a></li>
					</ul></li>
			</ul>
			<ul class="nav">
				<li class=""><a href="../occurrence" title="Home">Ocorrências</a></li>

				<li class="dropdown"><a href="#" data-toggle="dropdown"class"dropdown-toggle">Relatórios<b
						class="caret"></b></a>
					<div class="dropdown-menu megamenu" style="width: 400px">
						<div class="row-fluid">
							<div class="span4">
								<ul>
									<li><a href="userOccurrences">Ocorrências por usuário</a></li>
									<li><a href="projectOccurrences"> Ocorrências por
											projeto</a></li>
								</ul>
							</div>
						</div>
					</div></li>
			</ul>

		</div>
	</div>
	<!-- Header end -->


	<br />
	<h4 id="TitlePageEdit" class="titleMaintenance"></h4>
	<br />
	<div id="buttonDiv" class="titleMaintenance">
		<input class="btn btn-primary" type="submit"
			id="submitFrmEditOccurrence" value="Editar ocorrência" /> <br /> <br />
	</div>
	<form action="upload" method="post" enctype="multipart/form-data">

		<div class="">
			<div>
				<c:if test="${occurrence != null}">

					<div class="control-group" id="idDiv">
						<label class="label_1">ID da ocorrência:</label> <input id="id"
							onkeypress="return handleEnter(this, event)" class="inputText"
							name="id" type="text" MaxLength="30" size="68"
							value="${occurrence.id}" disabled />
					</div>
					<div class="txt-fld" id="statusDiv">
						<label class="label_1">Status:</label> <select class=""
							name="statusOccurrenceForm" id="statusOccurrenceForm">
							<option value="0">Selecione...</option>
							<c:forEach items="${status}" var="status">
								<option id="${status.id}">
									<c:out value="${status.statusType}"></c:out>
								</option>
							</c:forEach>
						</select> <img style="cursor: pointer; padding: 0px 0px 8px 3px;"
							src="../resources/img/alter.png" title="Alterar status"
							id="alteterStatus" data-toggle="modal"
							data-target="#AlterStatusModal">

					</div>

				</c:if>
				<div class="txt-fld">
					<label class="label_1"> Nome projeto:</label> <select
						name="listProjects" style="cursor: default; width: 314px;"
						id="listProjects">
						<option id="0">Selecione...</option>
						<c:forEach items="${listProjects}" var="projeto">
							<option id="${projeto.id}">
								<c:out value="${projeto.projectName}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>

				<div class="txt-fld">
					<label class="label_1">Ocorrência:</label> <input
						id="occurrenceTitle" class="inputText" name="occurrenceTitle"
						type="text" MaxLength="30" size="68" />
				</div>
				<div class="txt-fld">
					<label class="label_1">Descrição:</label>
					<textarea id="occurrenceDescription" name="occurrenceDescription"
						class="inputText" rows="8" cols="100"></textarea>
					<br />
				</div>
				<div class="txt-fld">
					<label class="label_1">Nome do responsável:</label> <select
						name="users" id="users" id="users">
						<option id="0">Selecione...</option>
						<c:forEach items="${users}" var="user">
							<option id="${user.id}">
								<c:out value="${user.userName}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="txt-fld">

					<label class="label_1">Tipo da ocorrência:</label> <select
						name="typesOccurrences" ;"
			id="typesOccurrences">
						<option id="0">Selecione...</option>
						<c:forEach items="${typesOccurrences}" var="occurrence">
							<option id="${occurrence.id}">
								<c:out value="${occurrence.occurenceType}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="txt-fld">
					<label class="label_1">Prioridade: </label> <select
						name="typesPriority" ;" id="typesPriority">
						<option value="0">Selecione...</option>
						<c:forEach items="${typesPriority}" var="priority">
							<option id="${priority.id}">
								<c:out value="${priority.priorityType}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>

				<div class="txt-fld">
					<label class="label_1">Anexar arquivos:</label> <input id="file"
						name="file" type="file" style="width: 300px;" MaxLength="30"
						size="40" />
				</div>
				<br />


				<div id="tabs"></div>
				<label class="label_1"
					style="float: left; position: relative; top: 5px;"> Anexos:</label>
				<div style="width: 24%;">
					<table id="example" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Nome Arquivo<i class="sort"></i>
								</th>
								<th>Download<i class="sort"></i>
								</th>
							</tr>

						</thead>
						<tbody>
							<tr class="odd">
								<td>evidencia.pdf</td>
								<td><a href="#anexo"> download</a></td>
							</tr>
							<tr class="odd">
								<td>...</td>
								<td>...</td>
							</tr>
							<tr class="odd">
								<td>...</td>
								<td>...</td>
							</tr>
						</tbody>
					</table>
				</div>
				<input type="hidden" id="hdn-id-ocurrence" name="hdn-id-ocurrence"
					value="${idOccurrece}">
				<div class="btn-fld"
					style="float: left; padding: 6px 5px 5px 220px;">
					<input class="btn btn-primary" type="submit"
						id="submitFrmNewOccurrence" value="Salvar" />
					<input	onclick="window.location.href='../occurrence';"
						class="btn btn-primary" type="button" value="Cancelar" />
				</div>
			</div>
		</div>
	</form>
	<br />
	<%-- <div class="span9">
		<div class="page-header">
			<h1 id="TitlePageEdit"></h1>
		</div>
		<form class="form-horizontal form-container">
			<fieldset>
				<div class="control-group">
					<label for="input01" class="control-label"><strong
						class="required">*</strong>ID da ocorrência</label>
					<div class="controls">
						<input id="id" onkeypress="return handleEnter(this, event)"
							name="id" type="text" MaxLength="30" size="68"
							value="${occurrence.id}" disabled class="inputText">
					</div>
				</div>

				<div class="control-group">
					<label for="select01" class="control-label">Status</label>
					<div class="controls">
						<select class="select01" name="statusOccurrenceForm"
							id="statusOccurrenceForm">
							<option value="0">Selecione...</option>
							<c:forEach items="${status}" var="status">
								<option id="${status.id}">
									<c:out value="${status.statusType}"></c:out>
								</option>
							</c:forEach>
						</select> <img style="cursor: pointer;" src="../resources/img/alter.png"
							title="Alterar status" id="alteterStatus" data-toggle="modal"
							data-target="#AlterStatusModal">
					</div>
				</div>
				<div class="control-group">
					<label for="select01" class="control-label">Nome projeto</label>
					<div class="controls">
						<select name="listProjects" style="cursor: default; width: 314px;"
							id="listProjects">
							<option id="0">Selecione...</option>
							<c:forEach items="${listProjects}" var="projeto">
								<option id="${projeto.id}">
									<c:out value="${projeto.projectName}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label for="input01" class="control-label"><strong
						class="required">*</strong>Ocorrência</label>
					<div class="controls">
						<input id="occurrenceTitle" class="inputText"
							name="occurrenceTitle" type="text" MaxLength="30" size="68"
							class="input-xlarge">
					</div>
				</div>
				<div class="control-group">
					<label for="textarea" class="control-label">Descrição</label>
					<div class="controls">
						<textarea rows="3" id="occurrenceDescription"
							name="occurrenceDescription" class="input-xlarge"
							style="width: 242px; height: 64px;"></textarea>
					</div>
				</div>
				<div class="control-group">
					<label for="select01" class="control-label">Nome do
						responsável</label>
					<div class="controls">
						<select name="users" id="users" id="users">
							<option id="0">Selecione...</option>
							<c:forEach items="${users}" var="user">
								<option id="${user.id}">
									<c:out value="${user.userName}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label for="select01" class="control-label">Tipo da
						ocorrência</label>
					<div class="controls">
						<select name="typesOccurrences" id="typesOccurrences">
							<option id="0">Selecione...</option>
							<c:forEach items="${typesOccurrences}" var="occurrence">
								<option id="${occurrence.id}">
									<c:out value="${occurrence.occurenceType}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label for="select01" class="control-label">Prioridade</label>
					<div class="controls">
						<select name="typesPriority" id="typesPriority">
							<option value="0">Selecione...</option>
							<c:forEach items="${typesPriority}" var="priority">
								<option id="${priority.id}">
									<c:out value="${priority.priorityType}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="control-group">
					<label for="fileInput" class="control-label">Anexar
						arquivos</label>
					<div class="controls">
						<input type="file" id="file" name="file" class="input-file">
					</div>
				</div>
				<br />

				<div>
					<table id="example" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Nome Arquivo<i class="sort"></i>
								</th>
								<th>Download<i class="sort"></i>
								</th>
							</tr>

						</thead>
						<tbody>
							<tr class="odd">
								<td>evidencia.pdf</td>
								<td><a href="#anexo"> download</a></td>
							</tr>
							<tr class="odd">
								<td>...</td>
								<td>...</td>
							</tr>
							<tr class="odd">
								<td>...</td>
								<td>...</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			<!-- <form action="upload" method="post" enctype="multipart/form-data"> -->
				<input type="hidden" id="hdn-id-ocurrence" name="hdn-id-ocurrence"
						value="${idOccurrece}">
				<div class="form-actions">
					<button class="btn btn-primary" type="submit" id="submitFrmNewOccurrence" value="Salvar">Salvar</button>
					<button class="btn" onclick="window.location.href='../occurrence';"type="button">Cancelar</button>
				</div>				
			</form>
<!-- 		</form> -->

	</div>
 --%>
	<!-- Footer -->
	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>
	<!-- Footer -->

	<!-- Modal alter status of occurrence -->
	<div class="modal fade" id="AlterStatusModal" tabindex="-1"
		role="dialog" aria-labelledby="AlterStatusModalLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="ModalLabel">Alterar status</h4>
				</div>
				<div class="modal-body">
					<div>
						<div class="txt-fld">
							<label style="float: left; position: relative; top: 5px;">Status:</label>
							<select name="statusOccurrenceEdit" id="statusOccurrenceEdit">
								<option value="0">Selecione...</option>
								<c:forEach items="${status}" var="status">
									<option id="${status.id}">
										<c:out value="${status.statusType}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="txt-fld">
							<label class="label_1"
								style="float: left; position: relative; top: 5px;">Justificativa:</label>
							<textarea id="historicJustification" name="historicJustification"
								style="width: 300px;" class="" rows="8" cols="100"></textarea>
							<br />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
						<button id="submitFrmEditStatusOccurrence" type="button"
							class="btn btn-primary">Salvar</button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- end -->
</body>
</html>