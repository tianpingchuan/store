<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered" style="width: 1400px">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">订单编号</th>
					<th scope="col">用户名</th>
					<th scope="col">总价</th>
					<th scope="col">收货详细地址</th>
					<th scope="col">订单状态</th>
					<th scope="col">支付方式</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty IndentList}">
					<c:forEach items="${IndentList}" var="indent" varStatus="status">
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
							<td>
								<a href="javascript:;" data-rowId="${indent.rowId}" id="update">修改</a>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${indent.rowId}" id="delete">删除</a>
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