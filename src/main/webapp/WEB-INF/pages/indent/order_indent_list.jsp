<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr id="child${indentCode}">
	<td colspan="7">
		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">商品名称</th>
					<th scope="col">购买数量</th>
					<th scope="col">商品总价</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty indentOrderList}">
					<c:forEach items="${indentOrderList}" var="order" varStatus="status">
						<tr id="tr${order.indentCode}">
							<th scope="row">${status.index+1}</th>
							<td>${order.productName}</td>
							<td>${order.bayCount}</td>
							<td>${order.totalPrices}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</td>
</tr>