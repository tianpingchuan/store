<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
	
		<table class="table table-bordered" id="example-basic-expandable">
			<thead>
				<tr>
					<th scope="col">目录名称</th>
					<th scope="col">目录介绍</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty catalogList}">
					<c:forEach items="${catalogList}" var="catalog">
						<tr data-tt-id="${catalog.rowId}" data-tt-parent-id="${catalog.parentCatalogId==-1?'':catalog.parentCatalogId}">
							<td>${catalog.catalogName}</td>
							<td>${catalog.catalogInfo}</td>
							<td>
								<a href="javascript:;" data-rowId="${catalog.rowId}" id="update">修改</a>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${catalog.rowId}" id="delete">删除</a>
								<a href="javascript:;" data-parentCatalogId="${catalog.rowId}" id="add_new">增加子目录</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

<script>
	$("#example-basic-expandable").treetable({ expandable: true, stringExpand:"展开",stringCollapse:"收起" });
</script>
<%-- 引入分页 --%>
<%@ include file="/page.jsp"%>