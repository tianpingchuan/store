<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr id="child${indentCode}">
	<td colspan="7">
		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">订单编号</th>
					<th scope="col">用户名</th>
					<th scope="col">总价</th>
					<th scope="col">收货详细地址</th>
					<th scope="col">订单状态</th>
					<th scope="col">支付方式</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty indentOrderList}">
					<c:forEach items="${indentOrderList}" var="indent" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${indent.indentCode}</td>
							<td>${indent.userName}</td>
							<td>${indent.totalPrices}</td>
							<td>${indent.trueAddress}</td>
							<td>
								${indent.indentState ==0 ? '未发货':''}
								${indent.indentState ==1 ? '发货':''}
								${indent.indentState ==2 ? '已收货':''}
							</td>
							<td>
								${indent.payWay ==1 ? '支付宝':''}
								${indent.payWay ==2 ? '银行卡':''}
								${indent.payWay ==3 ? '微信':''}
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</td>
</tr>