<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">订单编号</th>
					<th scope="col">商品编号</th>
					<th scope="col">商品购买信息</th>
					<th scope="col">购买数量</th>
					<th scope="col">商品总价</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty orderList}">
					<c:forEach items="${orderList}" var="order" varStatus="status">
						<tr id="tr${order.indentCode}">
							<th scope="row">${status.index+1}</th>
							<td>
								<a href="javascript:findChild('${order.indentCode}');">
								<i class="fa fa-chevron-right"></i>
								</a>
								 ${order.indentCode}
							</td>
							<td>${order.productNum}</td>
							<td>${order.productInfo}</td>
							<td>${order.bayCount}</td>
							<td>${order.totalPrices}</td>
							<td>
								<a href="javascript:;" data-rowId="${order.rowId}" id="update">修改</a>
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${order.rowId}" id="delete">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

<script type="text/javascript">
	function findChild(indentCode) {
		//根据id取得tr的jQuery对象
		var $tr = $('#tr' + indentCode);
		// 通过 tr找到有 fa这个样式的 i 
		var $i = $tr.find('.fa');
		//判断 如果是 右向图标，则执行 下拉数据的查询
		if ($i.hasClass('fa-chevron-right')) {
			$i.removeClass('fa-chevron-right').addClass('fa-chevron-down');
			$.ajax({
				url:'indent/list/'+indentCode,
				success : function(htmlData) {
					console.log(htmlData);
					$tr.after(htmlData);
				}
			});
		} else {
			//否则清空下拉列表数据
			$i.removeClass('fa-chevron-down').addClass('fa-chevron-right');
			$('#child' + indentCode).remove();
		}

	}
</script>
<%-- 引入分页 --%>
<%@ include file="/page.jsp"%>