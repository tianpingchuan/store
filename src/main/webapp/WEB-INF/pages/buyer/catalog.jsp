<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty catalogList}">
	<c:forEach items="${catalogList}" var="catalog">
		<li class="dropdown menu__item">
			<a href="javascript:;" data-rowId="${catalog.rowId}">${catalog.catalogName} 
			</a>
		</li>
	</c:forEach>
</c:if>