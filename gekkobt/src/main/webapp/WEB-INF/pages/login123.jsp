<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.gekkobt.controller.LoginController"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<head title="DPT - Gerenciador de Parametros">


<link href="resources/css/styleLogin.css" rel="stylesheet" />
<link href="resources/css/modal-esqueci-senha.css" rel="stylesheet" />
<link href="resources/css/animate.css" rel="stylesheet" />
<link href="resources/css/citi-bootstrap.css" rel="stylesheet" />
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/insert-occurrence.css" rel="stylesheet" />

<link rel="stylesheet" href="css/uniform.default.css" media="screen" />
<script src="resources/js/modal-esqueci-senha.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<script src="jquery.uniform.js"></script>

<c:import url="taglibs/resources.jsp"></c:import>

<script src="resources/js/insert-occurrence.js"></script>

</head>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		
		if("${mensagem}" == "Senha enviada com sucesso, Verifique seu email."){
			$("#messageAlert").addClass("alert-success");
			$("#messageAlert").removeClass("alert-danger");
		}
		});

</script>

<body>
	<div id="citi-header">
		<a class="logo pull-right"> <img src="assets/img/Logo.png"
			style="width: 70px; position: relative; top: -20px;" />
		</a>
		<div class="app_logo">
			<span style="color: white; font-size: 17px; font-weight: bold;">Gekko
				Bug tracker</span>
		</div>
	</div>
	<div id="main-nav" class="navbar">
		<div class="navbar-inner"></div>
	</div>
	<div id="body" style="padding: 4px;">
		<c:if test="${not empty mensagem}">
			<div class="bs-example">
				<div id="messageAlert" class="alert alert-danger fade in" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">× 
					</button>
					<h4 id="">${mensagem}</h4>
				</div>
			</div>
			<%--<h6 style="float: left; position: relative; top: 5px; text-align: justify;">
			<font color="red">${mensagem}</font></h6> --%>
		</c:if>
		<form action="login/userMake" method="post">

			<div id="container">
				<label for="userLogin">Username:</label> <input type="text"
					id="userLogin" name="userLogin"> <label for="userPassword">Password:</label>
				<input type="password" id="userPassword" name="userPassword">
				<div>
					<p>
						<a style="cursor: pointer;" data-toggle="modal"
							data-target="#forgotPasswordModal">Esqueci minha senha</a>
					</p>
				</div>

				<div id="lower">
					<!-- <input type="submit" value="Entrar" /> -->

					<button type="submit" id="logar" class="btn btn-primary"
						style="margin-top: 20px; float: right; margin-right: 20px;">
						Logar</button>
				</div>
			</div>

		</form>
	</div>

	<!-- 	</form> -->
	<!--/ lower-->


	<!-- mascara para cobrir o site -->
	<div id="mascara"></div>
	<div style="bottom: 0px; width: 97%; position: absolute;">
		<c:import url="taglibs/footer.jsp"></c:import>
	</div>

	<form action="login/email">

		<div class="modal fade" id="forgotPasswordModal" tabindex="-1"
			role="dialog" aria-labelledby="forgotPasswordModalLabel"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="ModalLabel">Esqueceu sua senha?</h4>
					</div>

					<div class="modal-body">

						<h5 style="padding: 10px 17px 0px;">Digite seu email abaixo para sua senha:</h5>
						<br /> <label class="label_1"
							style="float: left; position: relative; top: 8px;">
							E-mail:</label> <input id="userEmail" name="userEmail"
							style="width: 300px;" type="text" MaxLength="40" size="60" />
						
					</div>
					<div class="btn-fld">
							<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Enviar</button>
								<button type="button" class="btn"
									data-dismiss="modal">Cancelar</button>
							</div>

						</div>
				</div>
				<div id="tabs"></div>
			</div>
		</div>
	</form>

	<!-- end -->


</body>
</html>