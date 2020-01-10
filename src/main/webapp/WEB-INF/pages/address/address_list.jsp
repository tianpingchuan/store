<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered" style="width: 1400px">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">用户名称</th>
					<th scope="col">省名称</th>
					<th scope="col">市名称</th>
					<th scope="col">县名称</th>
					<th scope="col">详细地址</th>
					<th scope="col">邮政编码</th>
					<th scope="col">收货人电话</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty addressList}">
					<c:forEach items="${addressList}" var="address" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${address.userName}</td>
							<td>${address.provinceName}</td>
							<td>${address.cityName}</td>
							<td>${address.areaName}</td>
							<td>${address.trueAddress}</td>
							<td>${address.postCode}</td>
							<td>${address.userPhone}</td>
							<td>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${address.rowId}" id="delete">删除</a>
								<!-- 当用户登录个人中心时显示修改超链接 -->
								<c:if test="${!empty user}">
									<a href="javascript:;" data-rowId="${address.rowId}" id="update">修改</a>
								</c:if>
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