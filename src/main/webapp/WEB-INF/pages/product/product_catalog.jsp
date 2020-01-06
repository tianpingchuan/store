<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty catalogProductsList}">
	<c:forEach items="${catalogProductsList}" var="catalog">
		<option value="${catalog.rowId}">${catalog.catalogName}</option>
	</c:forEach>
</c:if>