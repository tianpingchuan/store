<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">用户ID</th>
					<th scope="col">商品编号</th>
					<th scope="col">购买数量</th>
					<th scope="col">商品总价</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty cartList}">
					<c:forEach items="${cartList}" var="cart" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${cart.userName}</td>
							<td>${cart.productNum}</td>
							<td>${cart.bayCount}</td>
							<td>${cart.totalPrices}</td>
							<td>
								<a href="javascript:;" data-rowId="${cart.rowId}" id="update">修改</a>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${cart.rowId}" id="delete">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp"%>