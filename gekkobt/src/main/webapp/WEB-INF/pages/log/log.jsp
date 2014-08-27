<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.gekkobt.controller.ReportUserOccurrencesController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lista de logs</title>
<head>
<c:import url="../taglibs/resources.jsp"></c:import>
</head>
<style type="text/css">
.pos-absolute {
	position: absolute;
}
</style>
<script type="text/javascript">

	$(document).ready(function() {
		$("#initialDate").mask("99/99/9999");
		$("#endDate").mask("99/99/9999");
		$("#datepicker1").datepicker();
		$("#datepicker2").datepicker();
		$("#footer").addClass('pos-absolute');
	});

	$(document).on(
	'click',
	'#exportExcel',
	function() {
		window.open("log/excelOccurrences?initialDate="
				+ $("#initialDate").val() + "&endDate="
				+ $("#endDate").val() + "&id="
				+ $("#IdUserOccurrence").find(":selected").get(0).id,
				'_blank');
	});
	
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
					<div class="form-inline actions-toolbar">
						<div class="row-fluid actions-toolbar-inner" style="width: 99%;">
							<div class="span1" style="width: 35px">
								<label style=""> Usuario:</label>
							</div>
							<div class="span1" style="width: 115px;">
								<select name="IdUserOccurrence" style="width: 126px;" id="IdUserOccurrence">
									<option value="">Todos...</option>
									<c:forEach items="${users}" var="user">
											<option id="${user.id}">
											<c:out value="${user.userName}"></c:out>
									</option>
									</c:forEach>
								</select>
							</div>
							<div class="span1" style="width: 105px;">
								<label> Data reportada de:</label>
							</div>
							<div class="span1" style="width: 120px;">
								<div class="input-append date">
									<input name="initialDate" onblur="validationDate(this)" id="initialDate" type="text" value="" style="width: 85px;">
									<span class="add-on"><i id="datepicker1" class="icon-th"></i></span>
								</div>
							</div>
							<div class="span1" style="width: 20px;">
								<label> Até:</label>
							</div>
							<div class="span1" style="width: 105px;">
								<div class="input-append date" id="Div2">
									<input name="endDate" id="endDate" onblur="validationDate(this)" type="text" value="" style="width: 85px;"> <span class="add-on"><i id="datepicker2" class="icon-th"></i></span>
								</div>
							</div>
							<div class="row-fluid actions-toolbar-inner" style="margin-top: 10px;">
								<div class="span2" style="margin-left: 110px; margin-top: -13px;">
									<button data-toggle="dropdown" id="exportExcel" class="btn dropdown-toggle">
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