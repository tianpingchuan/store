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
						<tr id="tr${indent.indentCode}">
							<th scope="row">${status.index+1}</th>
							<td>
								<a href="javascript:findChild('${indent.indentCode}');">
								<i class="fa fa-chevron-right"></i>
								</a>
								${indent.indentCode}
							</td>
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
				url:'order/list/'+indentCode,
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