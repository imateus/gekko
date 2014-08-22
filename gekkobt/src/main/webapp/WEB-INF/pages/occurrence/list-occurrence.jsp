<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

.not-visible {
	display: none;
}

.pos-absolute {
	position: absolute;
}
</style>
<script>
/* mask of date input */
jQuery(function($){
        $("#idOccurrence").keydown(function(event) {
            if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 
                || event.keyCode == 27 || event.keyCode == 13 
                || (event.keyCode == 65 && event.ctrlKey === true) 
                || (event.keyCode >= 35 && event.keyCode <= 39)){
                    return;
            }else {
                if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
                    event.preventDefault(); 
                }   
            }
        }); 
    	
        if ($('#tableQuery').children().length >= 6) {				
			$("#footer").addClass('pos-absolute');
		}
  
        
	 $( "#datepicker1" ).datepicker();
	 $( "#datepicker2" ).datepicker();
	 $( "#datepicker3" ).datepicker();
	 $( "#datepicker4" ).datepicker();
	/*  $("#labelPagination").text("Showing ${firtsOccurrenceOnPage} a ${qtdOccurrenceOnPage} of ${countOcurrences} Results"); */
	 renderPagination();
	 $("#messageAlert").addClass("not-visible");
	 
	 if ("${occurrenceNotFoud}") {
		$("#occurrenceEmpty").hide();
		$("#messageAlert").removeClass("not-visible"); 
		$("#printError").text("${occurrenceNotFoud}");
		$("#footer").addClass('pos-absolute');
	 } 
	 
	 $("#inclusionDateParamFrom").mask("99/99/9999");
	 $("#inclusionDateParamTo").mask("99/99/9999");
	 $("#finalizationDateParamFrom").mask("99/99/9999");
	 $("#finalizationDateParamTo").mask("99/99/9999");
	 $('#IdResponsableOccurrence option:eq(${userLogged.id})').prop("selected", true);
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

		function renderPagination(){ 
 			$(".numberPagination").click(function() {
					/*$(this).attr("disabled", true);*/			
	    			$("li[id^='li-']").removeClass("active");
					$(this).parent().addClass("active");
				$.post("occurrence/" + $(this).text(), {
					idOccurrence : $("#idOccurrence").val(),
					IdProjectOccurrence : $("#IdProjectOccurrence").find(":selected").get(0).id,
					IdTypeOccurrence : $("#IdTypeOccurrence").find(":selected").get(0).id,
					IdStatusOccurrence : $("#IdStatusOccurrence").find(":selected").get(0).id,
					IdResponsableOccurrence : $("#IdResponsableOccurrence").find(":selected").get(0).id,
					IdUserOccurrence : $("#IdUserOccurrence").find(":selected").get(0).id,
					inclusionDateParamFrom : $("#inclusionDateParamFrom").val(),
					inclusionDateParamTo : $("#inclusionDateParamTo").val(),
					finalizationDateParamFrom : $("#finalizationDateParamFrom").val(),
					finalizationDateParamTo : $("#finalizationDateParamTo").val(),
				}, function(data) {
					obj = handleJSON(data);
					hasError = handleError(obj);
					if (!hasError) { 
						$("#occurrenceEmpty").show();
						$("#footer").removeClass('pos-absolute');
						$("#tableOccurrence").html(data);
						renderPagination();
						if ($('#tableQuery').children().length <= 6) {				
							$("#footer").addClass('pos-absolute');
						}
						$.get("../occurrence/pagination", {
							}, function(data) {
								obj = handleJSON(data);
								hasError = handleError(obj);
								if (!hasError) {
									$("#paginationPage").html(data);								  	 
								  	 renderPagination();
								  	if ($('#tableQuery').children().length <= 6) {				
										$("#footer").addClass('pos-absolute');
									}
								}
								/* $("#labelPagination").text("Showing ${firtsOccurrenceOnPage} a ${qtdOccurrenceOnPage} of ${countOcurrences} Results"); */
						});
					}else{
						if(obj !=null){
							$("#printError").text(obj.message);	
							$("#messageAlert").removeClass('not-visible');
							$("#footer").addClass('pos-absolute');
							$("#occurrenceEmpty").hide();
						}
					}
				});						
		});
 	}; 
	  renderPagination(); 
	  
	$(document).on('click', '#filterOccurrence',
		filter = function() {
			$("#messageAlert").addClass('not-visible');	
			$.blockUI({ message: '<h4><img src="" /> Carregando...</h4>' });
			$.post("occurrence/1", {
				idOccurrence : $("#idOccurrence").val(),
				IdProjectOccurrence : $("#IdProjectOccurrence").find(":selected").get(0).id,
				IdTypeOccurrence : $("#IdTypeOccurrence").find(":selected").get(0).id,
				IdStatusOccurrence : $("#IdStatusOccurrence").find(":selected").get(0).id,
				IdResponsableOccurrence : $("#IdResponsableOccurrence").find(":selected").get(0).id,
				IdUserOccurrence : $("#IdUserOccurrence").find(":selected").get(0).id,
				inclusionDateParamFrom : $("#inclusionDateParamFrom").val(),
				inclusionDateParamTo : $("#inclusionDateParamTo").val(),
				finalizationDateParamFrom : $("#finalizationDateParamFrom").val(),
				finalizationDateParamTo : $("#finalizationDateParamTo").val(),
			}, function(data) {
				obj = handleJSON(data);
				hasError = handleError(obj);					
				if (!hasError) {
					$("#occurrenceEmpty").show();
					$("#footer").removeClass('pos-absolute');
					$("#tableOccurrence").html(data);
					if ($('#tableQuery').children().length <= 6) {				
						$("#footer").addClass('pos-absolute');
					}
					
					$.get("occurrence/pagination", { 
					}, function(data) {
						obj = handleJSON(data);
						hasError = handleError(obj);
						if (!hasError) {
							$("#paginationPage").html(data);						 	
						 	renderPagination();
						 	if ($('#tableQuery').children().length <= 6) {				
								$("#footer").addClass('pos-absolute');
							}
						 	$.unblockUI();
						}
						$.unblockUI();
					});
				}else{
					if(obj !=null){
						$("#printError").text(obj.message);	
						$("#messageAlert").removeClass('not-visible');
						$("#footer").addClass('pos-absolute');
						$("#occurrenceEmpty").hide();
					}
				}
			});
	});
});

function validationDate(inp){

var pattern = new RegExp("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((10|11|12|13|14|15|16|17|18|19|20)\\d\\d)","m");
 
 if (pattern.test(inp.value)==false) {
	inp.value="";
 }
}
           
/* end */
 	
  	var filterDelete;
	function setDeleteOccurrence(btnDelete) {
		filterDelete = btnDelete;
		
		showIdOnDelete(filterDelete);		
	}
	
	function showIdOnDelete(id) {
		$("#idExc").empty();
		$("#idExc").append(id);
	}
 	
	function openPage(param) {
		var path = "${pageContext.request.contextPath}";
		if (param == undefined) {
			window.location.href = path+"/occurrence/maintenance";
		}else{
			window.location.href = path+"/occurrence/maintenance?id=" + param;	
		}
	}
	
			function deleteOccurrence() {
				$.post("occurrence/delete", {
					id : filterDelete,
					idOccurrence : $("#idOccurrence").val(),
					IdProjectOccurrence : $("#IdProjectOccurrence").find(":selected").get(0).id,
					IdTypeOccurrence : $("#IdTypeOccurrence").find(":selected").get(0).id,
					IdStatusOccurrence : $("#IdStatusOccurrence").find(":selected").get(0).id,
					IdResponsableOccurrence : $("#IdResponsableOccurrence").find(":selected").get(0).id,
					IdUserOccurrence : $("#IdUserOccurrence").find(":selected").get(0).id,
					inclusionDateParamFrom : $("#inclusionDateParamFrom").val(),
					inclusionDateParamTo : $("#inclusionDateParamTo").val(),
					finalizationDateParamFrom : $("#finalizationDateParamFrom").val(),
					finalizationDateParamTo : $("#finalizationDateParamTo").val(),
				},function(data) {
					obj = handleJSON(data);
					hasError = handleError(obj);
					if (!hasError) {
						 if (obj == 1) {
							$("#labelPagination").html(obj + " resultado");
							}else{
								$("#labelPagination").html(obj + " resultados");
							}	
								$("#occurrence-"+filterDelete).remove();
								if (obj <= 6) {				
									$("#footer").addClass('pos-absolute');
								}
								 if (obj<=0) {
									$("#printError").text("Nenhuma ocorrência encontrada.");	
									$("#messageAlert").removeClass('not-visible');
									$("#footer").addClass('pos-absolute');
									$("#occurrenceEmpty").hide();
						}		 
					}
				}
			);
		}
			
			$(document).on(
					'click',
					'#cleanFilters',
					function() {						
						$("#idOccurrence").val('');
						$("#IdResponsableOccurrence option:eq(0)").prop("selected", true);
						$("#IdUserOccurrence option:eq(0)").prop("selected", true);
						$("#IdProjectOccurrence option:eq(0)").prop("selected", true);
						$("#IdTypeOccurrence option:eq(0)").prop("selected", true);
						$("#IdStatusOccurrence option:eq(0)").prop("selected", true);
						$("#inclusionDateParamFrom").val('');
						$("#inclusionDateParamTo").val('');
						$("#finalizationDateParamFrom").val('');
						$("#finalizationDateParamTo").val('');
					});

			$(document).on(
					'click',
					'#exportExcel',
					function () {
						window.open("occurrence/excelOccurrences?idOccurrence=" + $("#idOccurrence").val()
								+"&IdProjectOccurrence=" + $("#IdProjectOccurrence").find(":selected").get(0).id
								+"&IdTypeOccurrence=" + $("#IdTypeOccurrence").find(":selected").get(0).id
								+"&IdStatusOccurrence=" + $("#IdStatusOccurrence").find(":selected").get(0).id
								+"&IdResponsableOccurrence=" + $("#IdResponsableOccurrence").find(":selected").get(0).id  
								+"&IdUserOccurrence=" + $("#IdUserOccurrence").find(":selected").get(0).id
								+"&inclusionDateParamFrom=" + $("#inclusionDateParamFrom").val()
								+"&inclusionDateParamTo=" + $("#inclusionDateParamTo").val()
								+"&finalizationDateParamFrom=" + $("#finalizationDateParamFrom").val()
								+"&finalizationDateParamTo=" +  $("#finalizationDateParamTo").val(), '_blank');
					});
			
</script>
<body>
	<div id="main">
		<!-- Header -->
		<c:import url="../taglibs/header.jsp"></c:import>
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
										<li><input align="justify" type="button" id="exportPDF"
											value="PDF"
											style="background: white; border-color: none; border: none; font-size: inherit; margin-left: 10px;">
										</li>
									</ul>
								</div>
						</div>

						<div class="form-inline actions-toolbar"
							style="padding: 08px 12px 08px 0px; width: 99%;">

							<div class="row-fluid actions-toolbar-inner">
								<div class="span1" style="width: 50px;">
									<label style="">ID</label>
								</div>
								<div class="span1" style="width: 150px;">
									<input class="numbersOnly" name="idOccurrence"
										id="idOccurrence" type="text" value="${searchId}"
										maxlength="5" style="width: 111px;" />
								</div>
								<div class="span1" style="width: 75px;">
									<label style=""> Nome projeto</label>
								</div>
								<div class="span1" style="width: 160px;">

									<select name="IdProjectOccurrence" style="width: 126px;"
										id="IdProjectOccurrence">
										<option value="">Todos...</option>
										<c:forEach items="${project}" var="project">
											<option id="${project.id}">
												<c:out value="${project.projectName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 102px">
									<label style=""> Tipo ocorrência</label>
								</div>
								<div class="span1" style="width: 160px;">
									<select name="IdTypeOccurrence" style="width: 126px;"
										id="IdTypeOccurrence">
										<option value="">Todos...</option>
										<c:forEach items="${typeOccurrence}" var="occurrence">
											<option id="${occurrence.id}">
												<c:out value="${occurrence.occurenceType}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 30px">
									<label style=""> Status</label>
								</div>
								<div class="span1" style="width: 160px;">
									<select name="IdStatusOccurrence" style="width: 126px;"
										id="IdStatusOccurrence">
										<option value="">Todos...</option>
										<c:forEach items="${status}" var="status">
											<option id="${status.id}">
												<c:out value="${status.statusType}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row-fluid actions-toolbar-inner"
								style="margin-top: 10px;">
								<div class="span1" style="width: 50px;">Usuário</div>
								<div class="span1" style="width: 150px;">
									<select name="IdUserOccurrence" style="width: 126px;"
										id="IdUserOccurrence">
										<option value="">Todos...</option>
										<c:forEach items="${occurrenceUserInclusion}" var="user">
											<option id="${user.id}">
												<c:out value="${user.userName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 75px;">Responsável</div>
								<div class="span1" style="width: 160px;">
									<select name="IdResponsableOccurrence" style="width: 126px;"
										id="IdResponsableOccurrence">
										<option value="">Todos...</option>
										<c:forEach items="${occurrenceUserResponsible}" var="user">
											<option id="${user.id}">
												<c:out value="${user.userName}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
								<div class="span1" style="width: 102px;">
									<label> Data reportada de:</label>
								</div>
								<div class="span1" style="width: 162px;">
									<div class="input-append date" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">

										<input name="inclusionDateParamFrom"
											onblur="validationDate(this)" id="inclusionDateParamFrom"
											type="text" value="${inclusionDateFrom}" style="width: 85px;" />
										<span class="add-on"><i id="datepicker1"
											class="icon-th"></i></span>
									</div>
								</div>
								<div class="span1" style="width: 30px;">
									<label> Até:</label>
								</div>
								<div class="span1" style="width: 105px;">
									<div class="input-append date" id="Div2" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="inclusionDateParamTo" id="inclusionDateParamTo"
											onblur="validationDate(this)" type="text"
											value="${inclusionDateUtil}" style="width: 85px;" /> <span
											class="add-on"><i id="datepicker2" class="icon-th"></i></span>
									</div>
								</div>
							</div>
							<div class="row-fluid actions-toolbar-inner"
								style="margin-top: 10px;">
								<div class="span1" style="width: 110px;"></div>
								<div class="span1" style="width: 105px;"></div>
								<div class="span1" style="width: 75px;"></div>
								<div class="span1" style="width: 145px;"></div>
								<div class="span1" style="width: 102px;">
									<label> Data resolvida de:</label>
								</div>
								<div class="span1" style="width: 162px;">
									<div class="input-append date" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="finalizationDateParamFrom"
											onblur="validationDate(this)" id="finalizationDateParamFrom"
											type="text" value="${finalizationDateFrom}"
											style="width: 85px;" /> <span class="add-on"><i
											id="datepicker3" class="icon-th"></i></span>
									</div>
								</div>
								<div class="span1" style="width: 30px;">
									<label> Até:</label>
								</div>
								<div class="span1" style="width: 70px;">
									<div class="input-append date" id="Div2" data-date="02-01-2014"
										data-date-format="mm-dd-yyyy">
										<input name="finalizationDateParamFrom"
											onblur="validationDate(this)" id="finalizationDateParamTo"
											type="text" value="${finalizationDateUtil}"
											style="width: 85px;" /> <span class="add-on"><i
											id="datepicker4" class="icon-th"></i></span>
									</div>
								</div>
								<div class="span2" style="margin-left: 60px; float: right;">
									<button id="filterOccurrence" id="filterOccurrence"
										class="btn btn-primary">
										<i class="icon-filter icon-white"></i>&nbsp;Filtrar
									</button>
									<button class="btn" id="cleanFilters">
										<i class="icon-remove"></i>&nbsp;Limpar
									</button>
								</div>
							</div>
						</div>
						<div id="messageAlert">
							<div class="alert alert-danger fade in" role="alert">
								<button type="button" class="close" data-dismiss="alert">

								</button>
								<h4 id="printError"></h4>
							</div>
						</div>

						<div id="occurrenceEmpty">
							<div style="width: 100%; overflow: auto;" id="tableOccurrence">
								<table id="tableQuery"
									class="table table-bordered table-striped">
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

								<div class="modal fade bs-example-modal-sm"
									id="deleteOccurrenceModal" tabindex="-1" role="dialog"
									aria-labelledby="deleteOccurrenceModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">

											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="ModalLabel">Deletar
													ocorrência</h4>
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
							<%-- 	<div class="" id="paginationPage">
								<div class="pagination pagination-right">
									<ul>
										<li><a class="numberPagination">&lt;&lt;</a></li>
										<c:forEach begin="1" end="${numberOfOcurrences}" var="i">
									</ul>
									<ul>
										<li id="li-${i}"><a class="numberPagination"
											id="btn-${i}">${i}</a></li>
									</ul>
									</c:forEach>
								</div>
								<!-- <ul>
												<li><a href="#">&lt;&lt;</a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a class="numberPagination">2</a></li>
												<li><a class="numberPagination" href="">3</a></li>
											</ul> -->
							</div> --%>
							<div>
								<div class="row-fluid actions-toolbar">
									<div class="actions-toolbar-inner">

										<div id="paginationPage">
											<div class="span4">
												<c:choose>
													<c:when test="${countOcurrences==1}">
														<p id="labelPagination">${countOcurrences}resultado</p>
													</c:when>
													<c:otherwise>
														<p id="labelPagination">${countOcurrences}resultados</p>
													</c:otherwise>
												</c:choose>
											</div>
											<div class="span4"></div>
											<div class="span4">
												<div class="pagination pagination-right">
													<c:if test="${numberOfOcurrences >1}">
														<ul id="">
															<li><a>Prev</a></li>
															<c:forEach begin="1" end="${numberOfOcurrences}" var="i">
																<li id="li-${i}"><a class="numberPagination"
																	id="btn-${i}">${i}</a></li>
															</c:forEach>
															<li><a>Next</a></li>
														</ul>
													</c:if>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer" id="footerDiv">
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>

	<!-- Small modal -->
	<!-- <div id="mascara"></div>
	<div style="bottom: 0px; width: 97%;"></div> -->
</body>
</html>