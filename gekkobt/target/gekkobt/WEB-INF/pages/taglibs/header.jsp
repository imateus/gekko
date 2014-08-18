<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>





<div id="header">
	<script>
		jQuery(document).ready(function($) {
			$(document).ajaxStop($.unblockUI);
			$("#messageModal").dialog({
				autoOpen : false,
				modal : true,
				show : {
					effect : "fade",
					duration : 400
				},
				width : 300,
				marginTop : 200
			});
		});
	</script>

	
	<div id="citi-header">
		<a class="logo pull-left"> <img src="<c:url value="/resources/img/logo.png"/>" style="width:70px;position:relative;top:-18px; padding:8px 10px 10px 5px;">
		</a>
		<div class="app_logo">
			<span style="color: white; font-size: 17px; font-weight: bold;">Gekko Bug tracker</span>
		</div>
	</div>
	


</div>

<c:if test="${not empty error}">
	<script>
		jQuery(document).ready(function($) {
			ShowMessage('${ error }', null, true);
		});
	</script>
</c:if>

