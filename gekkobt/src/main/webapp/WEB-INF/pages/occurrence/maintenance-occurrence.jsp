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

option {
	width: 314px;
}

select {
	width: 314px;
	cursor: default;
}

.labelModalAlterStatus {
	width: 300px;
}

.titleMaintenance {
	position: relative;
	top: 0px;
	padding: 6px 5px 5px 20px;
}

.first {
	background: none repeat scroll 0 0 transparent;
	padding-top: 0;
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

<script>
	function verificar() {

		var tecla = window.event.keyCode;

		if (tecla == 226) {
			event.keyCode = 0;
			event.returnValue = false;
		}

	}

	function validationField(param, field) {
		if (param == null || param == "" || param == 0) {
			$("#" + field).text("*");
			return false;
		}
		return true;
	}

	function validationRequired() {
		if (!validationField($("#occurrenceTitle").val(),
				"labelOccurrenceTitle")
				| (!validationField($("#occurrenceDescription").val(),
						"labelOccurrenceDescription"))
				| (!validationField($("#occurrenceUserResponsibleBean").find(
						":selected").get(0).id, "labelOccurrenceResponsible"))
				| (!validationField(
						$("#priorityBean").find(":selected").get(0).id,
						"labelOccurrencePriority"))
				| (!validationField(
						$("#projectBean").find(":selected").get(0).id,
						"labelOccurrenceProject"))
				| (!validationField($("#typeOccurrenceBean").find(":selected")
						.get(0).id, "labelOccurrenceType"))) {
			return false;
		}
		return true;
	}

	function validationStatusRequired() {
		if (!validationField($("#statusOccurrenceEdit").find(":selected")
				.get(0).id, "labelAlterStatus")
				| (!validationField($("#historicJustification").val(),
						"labelAlterStatusDescription"))
				| (!validationField($("#dateChange").val(),
						"labelDateFinalization"))) {
			return false;
		}
		return true;
	}

	function validationDate(inp) {

		var pattern = new RegExp(
				"(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((10|11|12|13|14|15|16|17|18|19|20)\\d\\d)",
				"m");

		if (pattern.test(inp.value) == false) {
			inp.value = "";
		}
	}

	$(document)
			.ready(
					function() {
						/* $( "#datepicker1" ).datepicker(); */
						$("#dateChange").mask("99/99/9999");
						$("#filePath").click(function() {
							var filePath = $(this).attr("href");
							$.post("download", {
								filePath : filePath
							});
						});

						$("#occurrenceDescription").empty();
						$("#btnQuery").hide();
						$("#fileNameDiv").hide();

						$("#file")
								.on(
										'change',
										function(e) {
											var fsize = $('#file')[0].files[0].size;
											if (fsize > 5242880) //do something if file size more than 5 mb (5242880)
											{
												$("#messageAlert").removeClass(
														"not-visible");
												$("#messageAlert").removeClass(
														"alert-danger");
												$("#messageAlert").addClass(
														"alert-danger");
												$("#messageAlert")
														.text(
																"Seu arquivo excedeu o tamanho máximo de 5MB, atualmente seu aquivo possui: "
																		+ parseInt(
																				((fsize / 1000) / 1000),
																				10)
																		+ "MB");

											} else {
												$("#messageAlert").addClass(
														"not-visible");
												var valuePath = $(this).val();
												var valueSplited = valuePath
														.split("\\");
												$("#pathFile").text(
														valueSplited[2]);
												if ($("#pathFile").text() != null) {

													$("#btnQuery").show();
													$("#fileNameDiv").show();
													$("#btnConsultar").focus();
												}
											}

										});

						$("#btnFile1").click(function() {
							$("#file").trigger("click");
						});
					});

	$(document).on('click', '#btnCancelImport', closeImportFIle = function() {
		$("#btnQuery").hide();
		$("#fileNameDiv").hide();
	});

	$(document)
			.on(
					'click',
					'#submitFrmNewOccurrence',
					function() {
						var url = null;
						$("#labelOccurrenceTitle").text("");
						$("#labelOccurrenceDescription").text("");
						$("#labelOccurrenceResponsible").text("");
						$("#labelOccurrencePriority").text("");
						$("#labelOccurrenceProject").text("");
						$("#labelOccurrenceType").text("");
						if ($("#id").val() == null || $("#id").val() == "") {
							url = "insert";
						} else {
							url = "update";
						}
						var validation = true;

						if (validationRequired()) {
							var data = new FormData();
							$
									.post(
											url,
											{
												"id" : $("#hdn-id-ocurrence")
														.val(),
												"occurrenceTitle" : $(
														"#occurrenceTitle")
														.val().replace('\\',
																"/"),
												"occurrenceDescription" : $(
														"#occurrenceDescription")
														.val().replace('\\',
																"/"),
												"occurrenceUserResponsibleBean.id" : $(
														"#occurrenceUserResponsibleBean")
														.find(":selected").get(
																0).id,
												"statusBean.id" : $(
														"#statusOccurrenceEdit")
														.find(":selected").get(
																0).id,
												"typeOccurrenceBean.id" : $(
														"#typeOccurrenceBean")
														.find(":selected").get(
																0).id,
												"projectBean.id" : $(
														"#projectBean").find(
														":selected").get(0).id,
												"priorityBean.id" : $(
														"#priorityBean").find(
														":selected").get(0).id,
											},
											function(data) {
												obj = handleJSON(data);
												hasError = handleError(obj);
												var data = new FormData();
												if (!hasError) {
													$("#hdn-id-ocurrence").val(
															obj.id);
													document.forms[0].submit();
													$("#messageAlert")
															.removeClass(
																	"not-visible");
													$("#messageAlert")
															.removeClass(
																	"alert-danger");
													$("#messageAlert")
															.addClass(
																	"alert-success");
													if (url == "insert") {
														$("#printError")
																.text(
																		"Ocorrencia cadastrada com sucesso.");
													} else {
														$("#printError")
																.text(
																		"Ocorrencia alterada com sucesso.");
													}
													window.location.href = "maintenance?id="
															+ $(
																	"#hdn-id-ocurrence")
																	.val();
												}
											});
						} else {
							$("#messageAlert").removeClass("not-visible");
							$("#messageAlert").removeClass("alert-success");
							$("#messageAlert").addClass("alert-danger");
							$("#printError")
									.text(
											"* campos não preenchidos, favor preencher todos os campos.");
						}
					});

	$(document).on(
			'click',
			'#submitFrmEditStatusOccurrence',
			function() {
				$("#labelAlterStatus").text("");
				$("#labelAlterStatusDescription").text("");
				$("#labelDateFinalization").text("");
				if (validationStatusRequired()) {
				$.post("alterStatus", {
					id : $("#hdn-id-ocurrence").val(),
					'idOccurrenceBean.id' : $("#id").val(),
					'dateChange' : $("#dateChange").val(),
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
				}else{
					$("#messageAlertStatus").removeClass("not-visible");
					$("#messageAlertStatus").removeClass("alert-success");
					$("#messageAlertStatus").addClass("alert-danger");
					$("#printErrorStatus")
							.text("* campos não preenchidos, favor preencher todos os campos.");
				}
			});

	$(document).on(
			'click',
			'#submitReturnOccurrence',
			function() {

				if ($("#TitlePageEdit").text() == "Detalhe da ocorrência"
						|| $("#TitlePageEdit").text() == "Inserir ocorrência") {
					window.location.href = "../occurrence";
				} else {
					window.location.href = "maintenance?id="
							+ $("#hdn-id-ocurrence").val();
				}

			});

	$(document)
			.on(
					'click',
					'#submitFrmEditOccurrence',
					function() {
						if ($('#id').val() == null) {
							$('#id').prop('disabled', true);
							$('#statusOccurrenceForm').prop('disabled', true);
						} else {
							closeImportFIle();
							$('#id').prop('disabled', true);
							$('#statusOccurrenceForm').prop('disabled', true);
							$('#projectBean').prop('disabled', false);
							$('#occurrenceTitle').prop('disabled', false);
							$('#occurrenceDescription').prop('disabled', false);
							$('#occurrenceUserResponsibleBean').prop(
									'disabled', false);
							$('#typeOccurrenceBean').prop('disabled', false);
							$('#priorityBean').prop('disabled', false);
							$("#TitlePageEdit").html("Alterar Ocorrência");
							$("#titleWindow").html("Alterar Ocorrência");
							$('#submitFrmEditOccurrence').hide();
							$('#tbAnnex').hide();
							$('#submitFrmNewOccurrence').show();
							$('#buttonEdit').hide();
							$('#buttonExport').hide();
							
							$('#projectBean option:eq(${occurrence.projectBean.id})').prop("selected", true);
							$("#hdn-id-ocurrence").val("${occurrence.id}");
						}
					});

	$(document)
			.ready(
					function() {
						if ('${occurrence.id}' == '') {
							$('#buttonDiv').hide();
							$('#fieldsDetails').hide();
							$('#statusOccurrenceForm').hide();
							$("#TitlePageEdit").html("Inserir ocorrência");
							$("#titleWindow").html("Inserir ocorrência");
							$('#fileForm').hide();
							$('#fileNameDiv').hide();
							$("#footer").addClass('pos-absolute');
							$("#firstDiv").addClass("first");
							$('#alteterStatus').hide();
							$('#buttonEdit').hide();
							$('#buttonExport').hide();
							$('#buttonUpload').hide();
						} else {
							$('#id').prop('disabled', true);
							$('#statusOccurrenceForm').prop('disabled', true);
							$('#projectBean').prop('disabled', true);
							$('#occurrenceTitle').prop('disabled', true);
							$('#occurrenceDescription').prop('disabled', true);
							$('#occurrenceUserResponsibleBean').prop(
									'disabled', true);
							$('#typeOccurrenceBean').prop('disabled', true);
							$('#submitFrmNewOccurrence').hide();
							$('#priorityBean').prop('disabled', true);

							$("#TitlePageEdit").html("Detalhe da ocorrência");
							$("#titleWindow").html("Detalhe da ocorrência");
							$('#tbAnnex').show();
							$(
									'#projectBean option:eq(${occurrence.projectBean.id})')
									.prop("selected", true);
							$(
									'#occurrenceUserResponsibleBean option:eq(${occurrence.occurrenceUserResponsibleBean.id})')
									.prop("selected", true);
							$(
									'#typeOccurrenceBean option:eq(${occurrence.typeOccurrenceBean.id})')
									.prop("selected", true);
							$(
									'#priorityBean option:eq(${occurrence.priorityBean.id})')
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
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
		if (keyCode == 13) {

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

	function openPage(param) {
		if (param == undefined) {
			window.location.href = "maintenance";
		} else {
			window.location.href = "maintenance?id=" + param;
		}
	}

	var filterDelete;
	function setDeleteOccurrence(id, fileName) {
		filterDelete = id;
		showIdOnDelete(fileName);
	}

	function showIdOnDelete(fileName) {
		$("#idExc").empty();
		$("#idExc").append(fileName);

	}

	$(document).on('click', '#submitFrmEditStatusAnnex', function() {
		$.post("deleteAnnex", {
			id : filterDelete,
		}, function(data) {
			obj = handleJSON(data);
			hasError = handleError(obj);
			window.location.href = "maintenance?id=" + $("#id").val();
			if (!hasError) {
			}
		});
	});
	
	$(document).on(
			'click',
			'#exportExcel',
			function () {
				window.open("maintenance/exportExcelMaintenance?id=" + $("#id").val(), '_blank');
			});
	
</script>
<title id="titleWindow"></title>
</head>
<body>
	<!-- Header -->
	<c:import url="../taglibs/header.jsp"></c:import>
	<!-- Header end -->
	<br />
	<div style="width: 90%; margin: 0px auto;">
		<div class="page-header">
			<h1 style="color: gray;" id="TitlePageEdit"></h1>
		</div>
		<div id="messageAlert" class="alert alert-danger fade in not-visible"
			role="alert">
			<button type="button" class="close" data-dismiss="alert"></button>
			<h4 id="printError"></h4>
		</div>
		<div class="btn-toolbar" id="buttonExport">
			<div class="btn-group">
				<button class="btn" onclick="openPage()">
					<i class="icon-plus"></i>&nbsp; Ocorrência
				</button>
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
			</div>
			<div class="btn-group" id="">
				<button class="btn" id="submitFrmEditOccurrence">
					<i class="icon-edit"></i> &nbsp;Editar
				</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn" id="btnFile1">
					<i class="icon-upload-alt"></i> &nbsp;Upload de Aquivos
				</button>
			</div>

		</div>
	</div>
	<div class="form-inline actions-toolbar"
		style="width: 90%; margin: 0px auto;" id="fileNameDiv">
		<strong id="pathFile" style="padding: 10px 13px 0 10px;"></strong>
	</div>
	<br />
	<div id="btnQuery" style="width: 90%; margin: 0px auto;">
		<table>
			<tr>

				<th>
					<form action="upload" method="POST" enctype="multipart/form-data"
						id="fileForm">

						<button id="btnConsultar" class="btn btn-primary">
							<i class="glyphicon glyphicon-upload"></i>Importar
						</button>

						<input type="file" class="input-medium" name="file" id="file"
							style="display: none; aling: left;"> <input type="hidden"
							id="hdnId" name="hdnId" value="${occurrence.id}">
					</form>
				</th>
				<th>
					<button id="btnCancelImport" class="btn" style="margin-top: -15px;">
						<i class="glyphicon glyphicon-upload"></i>Cancelar
					</button>
				</th>
			</tr>
		</table>
	</div>
	<!-- </div> -->
	<form class="form-horizontal form-container"
		style="width: 90%; margin: 0px auto;">
		<fieldset>
			<div id="fieldsDetails">
				<div class="control-group">
					<label for="input01" class="control-label"><strong
						class="required"></strong>ID da ocorrência</label>
					<div class="controls">
						<input id="id" onkeypress="return handleEnter(this, event)"
							name="id" type="text" value="${occurrence.id}" disabled />
					</div>
				</div>


				<div class="control-group">
					<label for="select01" class="control-label"> <strong
						id="labelOccurrenceStatus" class="required"></strong> Status
					</label>
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
			</div>

			<div id="firstDiv" class="control-group">
				<label for="select01" class="control-label"> <strong
					id="labelOccurrenceProject" class="required"></strong>Nome projeto
				</label>
				<div class="controls">
					<select name="projectBean.id" id="projectBean">
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
					id="labelOccurrenceTitle" class="required"></strong>Ocorrência</label>
				<div class="controls">
					<input style="width: 300px;" id="occurrenceTitle" class="inputText"
						name="occurrenceTitle" type="text" MaxLength="43" size="68"
						class="input-xlarge" onKeyDown="verificar()">
				</div>
			</div>
			<div class="control-group">
				<label for="textarea" class="control-label"><strong
					id="labelOccurrenceDescription" class="required"></strong>Descrição</label>
				<div class="controls">
					<textarea rows="2" id="occurrenceDescription" maxlength="255"
						name="occurrenceDescription" class="input-xlarge"
						style="width: 300px; height: 84px;" onKeyDown="verificar()">
						</textarea>
				</div>
			</div>
			<div class="control-group">
				<label for="select01" class="control-label"> <strong
					id="labelOccurrenceResponsible" class="required"> </strong>Nome do
					responsável
				</label>
				<div class="controls">
					<select name="occurrenceUserResponsibleBean.id"
						id="occurrenceUserResponsibleBean">
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
				<label for="select01" class="control-label"> <strong
					id="labelOccurrenceType" class="required"></strong> Tipo da
					ocorrência
				</label>
				<div class="controls">
					<select name="typeOccurrenceBean.id" id="typeOccurrenceBean">
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
				<label for="select01" class="control-label"> <strong
					id="labelOccurrencePriority" class="required"></strong> Prioridade
				</label>
				<div class="controls">
					<select name="priorityBean.id" id="priorityBean">
						<option value="0">Selecione...</option>
						<c:forEach items="${typesPriority}" var="priority">
							<option id="${priority.id}">
								<c:out value="${priority.priorityType}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<br />
			<c:if test="${annex.size() > 0}">
				<div>
					<table id="tbAnnex" class="table table-bordered table-striped"
						style="width: 50%;">
						<thead>
							<tr>
								<th>Nome Arquivo<i class="sort"></i>
								</th>
								<th>Data de inclusão<i class="sort"></i>
								</th>
								<th>Usuário<i class="sort"></i>
								</th>
								<th>Ações<i class="sort"></i>
								</th>
							</tr>

						</thead>
						<tbody>
							<c:forEach items="${annex}" var="annex">
								<tr id="annex_${annex.id}">
									<td>${annex.fileName}.${annex.fileExtension}</td>
									<td>${annex.inclusionDate}</td>
									<td>${annex.userBean.userName}</td>
									<td><a class="icon-download-alt"
										href="download/${annex.id}"
										style="cursor: pointer; padding: 0px 10px 0px '' 8px;"> </a> <img
										style="cursor: pointer; padding: 0px 0px 0px 8px;"
										src="<c:url value="/resources/img/delete.png"/>"
										title="Deletar arquivo" data-toggle="modal"
										data-target=".bs-example-modal-sm"
										onclick="setDeleteOccurrence('${annex.id}', '${annex.fileName}.${annex.fileExtension}')"
										id="${annex.id}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</fieldset>

		<!-- <form action="upload" method="post" enctype="multipart/form-data"> -->
		<input type="hidden" id="hdn-id-ocurrence" name="hdn-id-ocurrence"
			value="${idOccurrece}"> <input type="hidden"
			id="hdn-id-ocurrence" name="hdn-id-ocurrence" value="${idOccurrece}">
		<input type="hidden" name="hdnIdOcurrence" id="hdnIdOcurrence"
			value="${occurrence.id}">
		<div class="form-actions">
			<input class="btn btn-primary" type="button"
				id="submitFrmNewOccurrence" value="Salvar" />
			<button id="submitReturnOccurrence" class="btn" type="button">Cancelar</button>
		</div>
	</form>


	<!-- Footer -->
	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>
	<!-- Footer -->

	<!-- Modal alter status-->
	<div class="modal fade" id="AlterStatusModal" tabindex="-1"
		style="display: none;" role="dialog"
		aria-labelledby="AlterStatusModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="ModalLabel">Alterar status</h4>
				</div>
				<div class="modal-body">
					<div id="messageAlertStatus"
						class="alert alert-danger fade in not-visible" role="alert">
						<button type="button" class="close" data-dismiss="alert"></button>
						<h4 id="printErrorStatus"></h4>
					</div>
					<div>
						<div class="txt-fld">
							<label><strong id="labelAlterStatus" class="required"></strong>Status:</label>
							<select name="statusOccurrenceEdit" id="statusOccurrenceEdit">
								<c:forEach items="${status}" var="status">
									<option id="${status.id}">
										<c:out value="${status.statusType}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="txt-fld">
							<label class="label_1"><strong
								id="labelAlterStatusDescription" class="required"></strong>Justificativa:</label>
							<textarea id="historicJustification" name="historicJustification"
								style="width: 300px;" class="" rows="8" cols="100"></textarea>
							<br />
						</div>
						<div class="txt-fld">
							<div>
								<label><strong id="labelDateFinalization"
									class="required"></strong>Data de alteração de status:</label>
							</div>
							<div class="" style="width: 162px;">
								<div class="input-append date" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">
									<input name="dateChange" onblur="validationDate(this)"
										id="dateChange" type="text" value="" style="width: 85px;" />
									<span class="add-on"><i id="datepicker1" class="icon-th"></i></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="submitFrmEditStatusOccurrence" type="button" class="btn btn-primary">Salvar</button>
					<button type="button" class="btn" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end modal-->
	
	<!-- Modal delete annex -->

	<div class="modal fade bs-example-modal-sm" id="deleteOccurrenceModal"
		style="display: none;" tabindex="-1" role="dialog"
		aria-labelledby="deleteOccurrenceModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="ModalLabel">Deletar anexo</h4>
				</div>
				<div class="modal-body" style="">
					<div>
						<div class="txt-fld">
							<label>Deseja realmente excluir o arquivo: <strong id="idExc"></strong></label>
						</div>
						<br />
					</div>
				</div>
				<div class="modal-footer">
					<div align="center">
						<button id="submitFrmEditStatusAnnex" type="submit" class="btn btn-primary" onclick="deleteOccurrence();">Sim</button>
						<button type="button" class="btn" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- end modal-->
</body>
</html>