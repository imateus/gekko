<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.gekkobt.controller.ReportUserOccurrencesController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lista de logs</title>
<head title="DPT - Gerenciador de Parametros">
<c:import url="../taglibs/resources.jsp"></c:import>
</head>
<style type="text/css">
.pos-absolute {
	position: absolute;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
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

	<div id="body" style="padding: 4px;">
		<div id="content" style="padding: 5px;">
			<div class="row-fluid">
				<div class="span12">
					<br>
					<div class="page-header">
						<h1 style="color: gray;">Relatório de logs</h1>
					</div>

					<div class="btn-group">

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
					<br> <br>

					<div class="form-inline actions-toolbar">
						<div class="row-fluid actions-toolbar-inner">

							<div class="span1" style="width: 101px">
								<label style=""> Usuario</label>
							</div>
							<div class="span1" style="width: 160px;">
								<select id="select1" name="select" style="width: 130px;">
									<option>Selecione...</option>
									<option>Mateus</option>
									<option>Teste</option>
								</select>
							</div>
						</div>
						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">

							<div class="span1" style="width: 102px;">
								<label> Data reportada de:</label>
							</div>
							<div class="span1" style="width: 162px;">
								<div class="input-append date" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">

									<input name="inclusionDateParamFrom"
										onblur="validationDate(this)" id="inclusionDateParamFrom"
										type="text" value="${inclusionDateFrom}" style="width: 85px;" />
									<span class="add-on"><i id="datepicker1" class="icon-th"></i></span>
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
								<button data-toggle="dropdown" class="btn dropdown-toggle">
									<i class=" icon-external-link"></i> &nbsp;Exportar
								</button>
							</div>
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