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
						<h1>Ocorrências por usuário</h1>
					</div>
					<br> <a href="login/logout">Sair do sistema</a> <br>
					<form class="form-inline actions-toolbar">

						<div class="row-fluid actions-toolbar-inner"
							style="margin-top: 10px;">
							<div class="span1" style="width: 110px;">Usuário</div>
							<div class="span1" style="width: 105px;">
								<input type="text" value="" style="width: 111px;" />
							</div>
							<div class="span1" style="width: 75px;">Projetos</div>
							<div class="span1" style="width: 160px;">
								<input type="text" value="" style="width: 156px;" />
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
								<tr class="odd">
									<td>Lucas</td>
									<td>02</td>
									<td>01</td>
									<td>01</td>
									<td>28/05/2014</td>
								</tr>
								<tr class="even">
									<td>Mateus</td>
									<td>03</td>
									<td>03</td>
									<td>00</td>
									<td>28/05/2014</td>
								</tr>
								<tr class="odd">
									<td>Vitor</td>
									<td>04</td>
									<td>03</td>
									<td>01</td>
									<td>28/05/2014</td>
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- <div id="footer" style="width: 97%;">
		<div class="navbar">
			<div class="navbar-inner">
				<a href="#" class="pull-right">Back to top</a>

			</div>
		</div>
		<div id="copyright">
			<a target="_blank" href="http://www.citigroup.net/CITINETWebApp/">
			</a> <span>Gekko é um programa de gerenciamento de ocorrências de
				projeto.</span> <span class="pull-right copyright"> &copy; 2014
				Gekko Bug Tracker.</span>
				</div>
		</div>
 -->
	<div>
		<c:import url="../taglibs/footer.jsp"></c:import>
	</div>

</body>
</html>