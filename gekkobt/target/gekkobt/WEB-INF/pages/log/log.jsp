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
<link href="resources/css/citi-bootstrap.css" rel="stylesheet" />
<link href="resources/css/brq-prototipo.css" rel="stylesheet" />
<link href="resources/css/flexigrid.css" rel="stylesheet" />
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/brq-prototipo-contingencia.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/uniform.default.css" media="screen" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<script src="jquery.uniform.js"></script>

<link href="resources/css/insert-occurrence.css" rel="stylesheet" />
<script src="resources/js/insert-occurrence.js"></script>
</head>


<script type="text/javascript">
	$(document).ready(function() {
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
				<li class=""><a href="occurrence" title="Home">Ocorrências</a></li>

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
						<h1>Lista de logs</h1>
						<br> <a href="login/logout">Sair do sistema</a> <br>
					</div>

					<form class="form-inline actions-toolbar">
						<div class="row-fluid actions-toolbar-inner">
							<div class="span1" style="width: 110px;">
								<label style="">Evento</label>
							</div>
							<div class="span1" style="width: 105px;">
								<input type="text" value="" style="width: 111px;" />
							</div>
							<div class="span1" style="width: 75px;">
								<label style=""> Tipo de Log</label>
							</div>
							<div class="span1" style="width: 160px;">

								<select id="select1" name="select" style="width: 170px;">
									<option>Selecione...</option>
									<option>Dashboard</option>
									<option>Gekko</option>
								</select>
							</div>
							<div class="span1" style="width: 90px">
								<label style=""> StackTrace</label>
							</div>
							<div class="span1" style="width: 105px;">
								<input type="text" value="" style="width: 111px;" />
							</div>
							<div class="span1" style="width: 70px">
								<label style=""> Usuario</label>
							</div>
							<div class="span1" style="width: 160px;">
								<select id="select1" name="select" style="width: 170px;">
									<option>Selecione...</option>
									<option>Mateus</option>
									<option>Teste</option>
								</select>
							</div>
						</div>
						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">




							<div class="span1" style="width: 90px;">
								<label>Data reportada</label>
							</div>
							<div class="span1" style="width: 162px;">
								<div class="input-append date" id="Div1" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">
									<input type="text" value="02-2014" style="width: 80px;">
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
							</div>
							<div class="span1" style="width: 69px;">
								<label> Até</label>
							</div>
							<div class="span1" style="width: 70px;">
								<div class="input-append date" id="Div2" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">
									<input type="text" value="03-2014" style="width: 80px;">
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
							</div>
							<div class="span2" style="margin-left: 60px; float: right;">

							</div>
						</div>

						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">




							<div class="span1" style="width: 90px;">
								<label> Data resolvida</label>
							</div>
							<div class="span1" style="width: 162px;">
								<div class="input-append date" id="Div1" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">
									<input type="text" value="02-2014" style="width: 80px;">
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
							</div>
							<div class="span1" style="width: 69px;">
								<label> Até</label>
							</div>
							<div class="span1" style="width: 70px;">
								<div class="input-append date" id="Div2" data-date="02-01-2014"
									data-date-format="mm-dd-yyyy">
									<input type="text" value="03-2014" style="width: 80px;">
									<span class="add-on"><i class="icon-th"></i></span>
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

									<th>Tipo de log<i class="sort"></i>
									</th>
									<th>Evento<i class="sort"></i>
									</th>
									<th>Mensagem<i class="sort"></i>
									</th>
									<th>StackTrace<i class="sort"></i>
									</th>
									<th>Data de ocorrência<i class="sort"></i>
									</th>
									<th>Usuário<i class="sort"></i>
									</th>

								</tr>
							</thead>
							<tbody>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
								<tr class="odd">
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
									<td>...</td>
								</tr>
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
	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>

</body>
</html>