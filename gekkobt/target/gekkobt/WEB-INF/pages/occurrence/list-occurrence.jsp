<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ocorrência</title>
<head title="DPT - Gerenciador de Parametros">

<c:import url="../taglibs/resources.jsp"></c:import>
<!-- <script src="resources/jsPages/insert-occurrence.js"></script> -->

<style type="text/css">
label {
	cursor: text;
}
</style>
<script>

/* mask of date input */

jQuery(function($){
	 $("#inclusionDateParamFrom").mask("99/99/9999");
	 $("#inclusionDateParamTo").mask("99/99/9999");
	 $("#finalizationDateParamFrom").mask("99/99/9999");
	 $("#finalizationDateParamTo").mask("99/99/9999");

	        if (location.protocol.indexOf('http')>-1) {
	            $.getScript('http://www.citigroup.net/search/js/search_rebrand_prod2.js', function(){
	                if (topSearch && topSearch.createSearch) {
	                    setTimeout(function(){topSearch.createSearch('top','global-search')},1000);
	                }
	            });
	        }
	        var megamenuContent='';
	        $('.megamenu ul a').hover(function(){
	            megamenuContent=$(this).parents('.megamenu').find('.megamenu-content').html();
	            $(this).parents('.megamenu').find('.megamenu-content').css('background-image','url(assets/img/examples/'+$(this).attr('data-bg')+'.jpg)').html('');
	        },function(){
	            $(this).parents('.megamenu').find('.megamenu-content').css('background-image','url()').html(megamenuContent);
	        });

	    
	 
});


function validationDate(inp){

var pattern = new RegExp("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((10|11|12|13|14|15|16|17|18|19|20)\\d\\d)","m");
 
 if (pattern.test(inp.value)==false) {
	inp.value="";
 }
}
           
/* end */
 
	function disableEmpty() {
		if ($("#inclusionDate").val() == "") {
			$("#inclusionDate").attr('disabled', true);
		}
		if ($("#finalizationDate").val() == "") {
			$("#finalizationDate").attr('disabled', true);
		}
	}

	function openPage(param) {
		if (param == undefined) {
			window.location.href = "occurrence/maintenance";
		}else{
			window.location.href = "occurrence/maintenance?id=" + param;	
		}
	}


	var filterDelete;
	function setDeleteFilter(btnDelete) {
		filterDelete = btnDelete;
		
		showIdOnDelete(filterDelete);		
	}
	
	function showIdOnDelete(id) {
		$("#idExc").empty();
		$("#idExc").append(id);
	}
			function deleteOccurrence() {
				
				$.post("occurrence/delete", {
					id : filterDelete
				}, function(data) {
					window.location.href = "occurrence";
					obj = handleJSON(data);
					hasError = handleError(obj);
					if (!hasError) {
						
		 			}
				});
			}
			
</script>
<%-- 	$(document)
			.ready(
					function() {
						alert("ini");
							$('#projectBean.id option:eq(${project.id})').prop("selected", true);
							alert("shbd");
					});  --%>
<body>
	<div id="main">
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
							<li><a
								href="${pageContext.request.contextPath}/login/logout"><i
									class="icon-signout"></i>Sair</a></li>
						</ul></li>
				</ul>
				<ul class="nav">
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
		<!-- Header -->

		<div id="body" style="padding: 4px;">
			<div id="content" style="padding: 5px;">


				<div class="row-fluid">
					<div class="span12">
						<div class="page-header">
							<h1>Lista de ocorrências</h1>
						</div>

						<div class="btn-toolbar">
							<div class="btn-group">
								<button class="btn" onclick="openPage()">
									<i class="icon-plus"></i>&nbsp; Add Record
								</button>
							</div>
							<div class="btn-group">
								<button href="#" data-toggle="dropdown"
									class="btn dropdown-toggle">
									<i class=" icon-external-link"></i> &nbsp;Export <span
										class="icon-sort-down"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Excel File</a></li>
									<li><a href="#">Text File</a></li>
								</ul>
							</div>
							<div class="btn-group">
								<button class="btn" data-toggle="modal" href="#myModal">
									<i class="icon-cog"></i>&nbsp;Settings
								</button>
							</div>
						</div>

						<form class="form-inline actions-toolbar" method="get"
							action="occurrence" onsubmit="disableEmpty()">
							<div class="row-fluid actions-toolbar-inner">
								<div class="span1" style="width: 110px;">
									<label style="">ID</label>
								</div>
								<div class="span1" style="width: 105px;">
									<input name="id" id="id" type="text" value="${searchId}"
										onkeypress="return handleEnter(this, event)"
										style="width: 111px;" />
								</div>
								<div class="span1" style="width: 75px;">
									<label style=""> Nome projeto</label>
								</div>
								<div class="span1" style="width: 160px;">

									<select name="projectBean.id" style="width: 126px;"
										id="projectBean.id">
										<option value="">Selecione...</option>
										<c:forEach items="${project}" var="project">
											<option value="${project.id}">
												<c:out value="${project.projectName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 90px">
									<label style=""> Tipo ocorrência</label>
								</div>
								<div class="span1" style="width: 160px;">
									<select name="typeOccurrenceBean.id" style="width: 126px;"
										id="typeOccurrenceBean.id">
										<option value="">Selecione...</option>
										<c:forEach items="${typeOccurrence}" var="occurrence">
											<option value="${occurrence.id}">
												<c:out value="${occurrence.occurenceType}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 70px">
									<label style=""> Status</label>
								</div>
								<div class="span1" style="width: 160px;">
									<select name="statusBean.id" style="width: 126px;"
										id="statusBean.id">
										<option value="">Selecione...</option>
										<c:forEach items="${status}" var="status">
											<option value="${status.id}">
												<c:out value="${status.statusType}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row-fluid actions-toolbar-inner"
								style="margin-top: 10px;">
								<div class="span1" style="width: 110px;">Usuário</div>
								<div class="span1" style="width: 105px;">
									<select name="occurrenceUserInclusionBean.id"
										style="width: 126px;" id="occurrenceUserInclusionBean.id">
										<option value="">Selecione...</option>
										<c:forEach items="${occurrenceUserInclusion}" var="user">
											<option value="${user.id}">
												<c:out value="${user.userName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 75px;">Responsável</div>
								<div class="span1" style="width: 160px;">
									<select name="occurrenceUserResponsibleBean.id"
										style="width: 126px;" id="occurrenceUserResponsibleBean.id">
										<option value="">Selecione...</option>
										<c:forEach items="${occurrenceUserResponsible}" var="user">
											<option value="${user.id}">
												<c:out value="${user.userName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 90px;">
									<label> Data reportada de:</label>
								</div>
								<div class="span1" style="width: 162px;">
									<div class="input-append date" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">

										<input name="inclusionDateParamFrom"
											onblur="validationDate(this)" id="inclusionDateParamFrom"
											type="text" value="${inclusionDateFrom}" style="width: 85px;" />
										<span class="add-on"><i class="icon-th"></i></span>
									</div>
								</div>
								<div class="span1" style="width: 69px;">
									<label> Até:</label>
								</div>
								<div class="span1" style="width: 105px;">
									<div class="input-append date" id="Div2" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="inclusionDateParamTo" id="inclusionDateParamTo"
											onblur="validationDate(this)" type="text"
											value="${inclusionDateUtil}" style="width: 85px;" /> <span
											class="add-on"><i class="icon-th"></i></span>
									</div>
								</div>
							</div>
							<div class="row-fluid actions-toolbar-inner"
								style="margin-top: 10px;">
								<div class="span1" style="width: 110px;"></div>
								<div class="span1" style="width: 105px;"></div>
								<div class="span1" style="width: 75px;"></div>
								<div class="span1" style="width: 160px;"></div>
								<div class="span1" style="width: 90px;">
									<label> Data resolvida de:</label>
								</div>
								<div class="span1" style="width: 162px;">
									<div class="input-append date" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="finalizationDateParamFrom"
											onblur="validationDate(this)" id="finalizationDateParamFrom"
											type="text" value="${finalizationDateFrom}"
											style="width: 85px;" /> <span class="add-on"><i
											class="icon-th"></i></span>
									</div>
								</div>
								<div class="span1" style="width: 69px;">
									<label> Até:</label>
								</div>
								<div class="span1" style="width: 70px;">
									<div class="input-append date" id="Div2" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="finalizationDateParamTo"
											onblur="validationDate(this)" id="finalizationDateParamTo"
											type="text" value="${finalizationDateUtil}"
											style="width: 85px;" /> <span class="add-on"><i
											class="icon-th"></i></span>
									</div>
								</div>
								<div class="span2" style="margin-left: 60px; float: right;">
									<button class="btn btn-primary">
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
										<th>ID<i class="sort"></i>
										</th>
										<th>Açôes<i class="sort"></i>
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
								<tbody>

									<c:forEach items="${occurrence}" var="occurrence">
										<tr id="occurrence_${occurrence.id}">
											<td>${occurrence.id}</td>
											<td><img
												style="cursor: pointer; padding: 0px 0px 0px 17px;"
												src="resources/img/alter.png" title="Detalhe da ocorrência"
												id="1" onclick="openPage(${occurrence.id})"> <img
												style="cursor: pointer; padding: 0px 0px 0px 8px;"
												src="resources/img/delete.png" title="Excluir ocorrência"
												id="deleteOccurrence12" data-toggle="modal"
												data-target=".bs-example-modal-sm"
												onclick="setDeleteFilter(${occurrence.id})"
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
								<div class="span4">
									<div class="pagination pagination-right">
										<ul>
											<li><a href="#">&lt;&lt;</a></li>
											<li class="active"><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">&gt;&gt;</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Small modal -->

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
								class="btn btn-primary" onclick="deleteOccurrence();">Sim</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<!-- end -->


	<%-- <!-- Modal insert occurence -->
	<div id="boxes1">
		<div id="boxes" class="label_1">
			<div id="dialog" class="window"
				style="padding: 30px; overflow-y: scroll;">
				<a href="#" class="close"
					style="float: right; color: #2ECC71; font-size: 18px;"><b>Fechar
						X</b></a><br />

				<div>
					<div>
						<h3 style="color: #2ECC71;">Inserir ocorrência</h3>
						<br />
					</div>
					<div class="txt-fld">
						<label class="label_1"
							style="float: left; position: relative; top: 5px;"> Nome
							projeto:</label> <select name="listProjects" style="width: 314px;"
							id="listProjects">
							<option value="">Selecione...</option>
							<c:forEach items="${listProjects}" var="projeto">
								<option value="${projeto.id}">
									<c:out value="${projeto.projectName}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="txt-fld">
						<label class="label_1"
							style="float: left; position: relative; top: 5px;">Ocorrência:</label>
						<input id="occurrenceTitle" style="width: 300px;"
							name="occurrenceTitle" type="text" MaxLength="30" size="68" />
					</div>
					<div class="txt-fld">
						<label class="label_1"
							style="float: left; position: relative; top: 5px;">Descrição:</label>
						<textarea id="occurrenceDescription" name="occurrenceDescription"
							style="width: 300px;" class="" rows="8" cols="100"></textarea>
						<br />
					</div>
					<div class="txt-fld">
						<label class="label_1"
							style="float: left; position: relative; top: 5px;">Nome
							do responsável:</label> <input id="occurrenceResponsible"
							name="occurrenceResponsible" style="width: 300px;" type="text"
							MaxLength="30" size="40" />
					</div>
					<div class="txt-fld">

						<label class="label_1"
							style="float: left; position: relative; top: 5px;">Tipo
							da ocorrência:</label> <select name="typesOccurrences"
							style="width: 314px;" id="typesOccurrences">
							<option value="">Selecione...</option>
							<c:forEach items="${typesOccurrences}" var="occurrence">
								<option value="${occurrence.id}">
									<c:out value="${occurrence.occurenceType}"></c:out>
								</option>
							</c:forEach>
						</select> <label class="label_1"
							style="float: left; position: relative; top: 5px;">Prioridade:
						</label> <select name="typesPriority" style="width: 314px;"
							id="typesPriority">
							<option value="">Selecione...</option>
							<c:forEach items="${typesPriority}" var="priority">
								<option value="${priority.id}">
									<c:out value="${priority.priorityType}"></c:out>
								</option>
							</c:forEach>
						</select> <label class="label_1"
							style="float: left; position: relative; top: 5px;">Anexos:</label>
						<input name="tipoOcorrencia" type="file" style="width: 300px;"
							MaxLength="30" size="40" />
					</div>
					<br />

					<div id="tabs"></div>
					<label class="label_1" style="float: left"> Anexo</label>
					<div style="width: 100%; overflow: auto;">
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
				</div>

				<div class="btn-fld" style="float: right">
					<input class="btn btn-primary" type="submit"
						id="submitFrmNewOccurrence" value="Salvar" /> <input
						class="btn btn-primary" type="submit" value="Cancelar" />
				</div>
			</div>
		</div>
	</div>
	<!-- end -->
	<!-- Modal detail occurrence -->
	<div id="boxes" class="label_1">
		<div id="dialog2" class="window"
			style="padding: 30px; overflow-y: scroll;">
			<a href="#" class="close"
				style="float: right; color: #2ECC71; font-size: 18px;"><b>Fechar
					X</b></a><br />

			<div>
				<div>
					<h3 style="color: #2ECC71;">Detalhe de ocorrência</h3>
					<br />
				</div>
				<label class="label_1" style="float: left"><a
					href="#dialog3" class="label_1" name="modal">Status:</a></label><input
					id="filterValue" style="width: 226px;" value="em analise"
					name="ocorrencia" type="text" maxlength="30" size="50"> <input
					class="btn btn-primary" type="submit" value="Alterar" />

				<div class="txt-fld">
					<label class="label_1"
						style="float: left; position: relative; top: 5px;"> Nome
						projeto:</label> <select name="nomeProjeto" style="width: 314px;"
						id="nomeProjeto">
						<option value="">Selecione...</option>
						<c:forEach items="${typefilters}" var="option">
							<option value="${option.filterTypeId}">
								<c:out value="${option.name}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="txt-fld">
					<label class="label_1" style="float: left">Ocorrência:</label> <input
						id="filterValue" style="width: 300px;" name="ocorrencia"
						type="text" MaxLength="30" size="68" />
				</div>
				<div class="txt-fld">
					<label class="label_1"
						style="float: left; position: relative; top: 5px;">Descrição:</label>
					<textarea name="descricao" style="width: 300px;" class="" rows="8"
						cols="100"></textarea>
					<br />
				</div>
				<div class="txt-fld">
					<label class="label_1" style="float: left">Nome do
						responsável:</label> <input id="filterValue" name="nomeResponsavel"
						style="width: 300px;" type="text" MaxLength="30" size="40" />
				</div>
				<div class="txt-fld">

					<label class="label_1" style="float: left">Tipo da
						ocorrência:</label> <input name="tipoOcorrencia" type="text"
						style="width: 300px;" MaxLength="30" size="40" /> <label
						class="label_1" style="float: left">Anexos:</label> <input
						name="tipoOcorrencia" type="file" style="width: 300px;"
						MaxLength="30" size="40" />
				</div>

				<div id="tabs">
					<ul>



					</ul>
					<div id="historico">
						<label class="label_1" style="float: left"> historico:</label>
						<div style="width: 100%; overflow: auto;">
							<table id="example" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Justificativa<i class="sort"></i>
										</th>
										<th>Status<i class="sort"></i>
										</th>
										<th>Data alteração<i class="sort"></i>
										</th>
										<th>Responsável por alteração<i class="sort"></i>
										</th>

									</tr>
								</thead>
								<tbody>
									<tr class="odd">
										<td>teste</td>
										<td>Projeto1</td>
										<td>teste</td>
										<td>teste</td>

									</tr>
									<tr class="odd">
										<td>teste</td>
										<td>Projeto1</td>
										<td>teste</td>
										<td>teste</td>
									</tr>

									<tr class="odd">
										<td>teste</td>
										<td>Projeto1</td>
										<td>teste</td>
										<td>teste</td>
									</tr>
							</table>
						</div>
						<label class="label_1" style="float: left"> Anexo:</label>
						<div style="width: 100%; overflow: auto;">
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
										<td>evidencia.pdf</td>
										<td><a href="#anexo"> download</a></td>
									</tr>

									<tr class="odd">
										<td>evidencia.pdf</td>
										<td><a href="#anexo"> download</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div class="btn-fld" style="float: right">
						<input class="btn btn-primary" type="submit" id="salvaOcorrencia"
							value="Salvar" /> <input class="btn btn-primary" type="submit"
							value="Cancelar" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end -->

	<!-- Modal alter status of occurrence -->
	<div id="boxes" class="label_1">

		<div id="dialog3" class="window2" style="padding: 30px;">
			<a href="#" class="close"
				style="float: right; color: #2ECC71; font-size: 18px;"><b>Fechar
					X</b></a><br />

			<div>
				<div>
					<h3 style="color: #2ECC71;">Alterar status</h3>
					<br />
				</div>
				<div class="txt-fld">
					<label class="label_1" style="float: left">Status:</label> <select
						style="width: 314px;" name="status" id="statusOcorrencia">
						<option value="">Selecione...</option>
						<c:forEach items="${typefilters}" var="option">
							<option value="${option.filterTypeId}">
								<c:out value="${option.name}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>

				<div class="txt-fld">
					<label class="label_1"
						style="float: left; position: relative; top: 5px;">Justificativa:</label>
					<textarea name="descricao" style="width: 300px;" class="" rows="8"
						cols="100"></textarea>
					<br />
				</div>


				<div id="tabs"></div>
			</div>

			<div class="btn-fld" style="float: right">
				<input class="btn btn-primary" type="submit" id="salvaOcorrencia"
					value="Salvar" /> <input class="btn btn-primary" type="submit"
					value="Cancelar" />
			</div>
		</div>
	</div>

	<!-- end --> --%>

	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>
	<div id="mascara"></div>
	<div style="bottom: 0px; width: 97%;"></div>
</body>
</html>