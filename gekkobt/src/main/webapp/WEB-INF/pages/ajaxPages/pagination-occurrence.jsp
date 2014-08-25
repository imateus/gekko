<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="paginationPage">

	<div class="span4">
		<c:choose>
			<c:when test="${countOcurrences==1}">
				<p id="labelPagination">${countOcurrences} resultado</p>
			</c:when>
			<c:otherwise>
				<p id="labelPagination">${countOcurrences} resultados</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="span4"></div>
	<div class="span4">
		<div class="pagination pagination-right">
			<c:if test="${paginationNumberEnd >1}">
				<ul id="">
					<c:if test="${paginationNumberBegin != 1}">
						<li><a>Prev</a></li>
					</c:if>
					<c:forEach begin="${paginationNumberBegin}"
						end="${paginationNumberEnd}" var="i">
						<li id="li-${i}"><a class="numberPagination" id="btn-${i}">${i}</a></li>
					</c:forEach>
					
					<c:choose>
						<c:when test="${numberOfOcurrences != paginationNumberEnd}">
							<li id="li-${numberOfOcurrences}"><a class="numberPagination" id="btn-${numberOfOcurrences}">Next</a></li>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</ul>
			</c:if>
		</div>
	</div>
</div>