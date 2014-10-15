<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="header">
	<div id="citi-header">
		<a class="logo pull-left" href="<c:url value="occurrence"/>"> <img src="<c:url value="/resources/img/logo.png"/>" style=" z-index: 3;width: 35px; position: relative; top: -18px; padding: 8px 10px 10px 5px; cursor: pointer;">
		</a>
		<div class="app_logo">
			<span style="color: white; font-size: 17px; font-weight: bold; z-index: 1;">Gekko Bug tracker</span>
		</div>
	</div>
	<div id="main-nav" class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">
				<li class="dropdown"><a href="#" data-toggle="dropdown" class="authentication dropdown-toggle"> <i class="icon-lock icon-white" style="display: inline-block;"></i>Olá: ${userLogged.userLogin} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/login/logout"><i class="icon-signout"></i>Sair</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav">
				<li class=""><a href="<c:url value="/occurrence"/>" title="Home">Ocorrências</a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"class"dropdown-toggle">Relatórios<b class="caret"></b></a>
					<div class="dropdown-menu megamenu" style="width: 400px">
						<div class="row-fluid">
							<div class="span4">
								<ul>
									<li><a href="<c:url value="/userOccurrences"/>">Ocorrências por usuário</a></li>
									<li><a href="<c:url value="/projectOccurrences"/>">Ocorrências por projeto</a></li>
									<li><a href="<c:url value="/log"/>">Logs</a></li>
								</ul>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>