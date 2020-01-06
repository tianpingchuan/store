<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
	
		<table class="table table-bordered" style="width: 1400px">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">目录ID</th>
					<th scope="col">商品名称</th>
					<th scope="col">商品编号</th>
					<th scope="col">商品图片地址</th>
					<th scope="col">商品价格</th>
					<th scope="col">商品数量</th>
					<th scope="col">商品上下架状态</th>
					<th scope="col">商品介绍</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty ProductList}">
					<c:forEach items="${ProductList}" var="product" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${product.catalogName}</td>
							<td>${product.productName}</td>
							<td>${product.productNum}</td>
							<td>
							<img height="50px" width="70px" alt="" src="${product.productFile}">
							</td>
							<td>${product.productPrice}</td>
							<td>${product.productCount}</td>
							<td>${product.putawayOrSoldOut==1?'上架状态':'下架状态'}</td>
							<td>${product.productIntro}</td>
							<td>
								<a href="javascript:;" data-rowId="${product.rowId}" id="update">修改</a>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${product.rowId}" id="delete">删除</a>
								<a href="javascript:;" data-rowId="${product.rowId}" data-putawayOrSoldOut="${product.putawayOrSoldOut}" id="putawayOrSoldOut">${product.putawayOrSoldOut==1?'下架':'上架'}</a>
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