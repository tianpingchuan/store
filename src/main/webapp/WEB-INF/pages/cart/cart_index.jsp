<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 订单列表管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">新增</button>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<!-- 搜索页面开始 -->
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<form id="form_search">
						<div class="form-row align-items-center">
							<div class="col-auto my-1">
								<select class="form-control" name="userId">
									<option value="">用户姓名</option>
									<c:if test="${!empty userCartList}">
										<c:forEach items="${userCartList}" var="user">
											<option value="${user.rowId}">${user.userName}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="col-auto my-1">
								<select class="form-control" name="productNum">
									<option value="">商品编号</option>
									<c:if test="${!empty productCartList}">
										<c:forEach items="${productCartList}" var="product">
											<option value="${product.productNum}">${product.productNum}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="col-auto my-1">
								<button type="reset" class="btn btn-dark">重置</button>
								<button type="button" class="btn btn-primary" id="button_search">搜索</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- 搜索页面结束 -->
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"></div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					订单列表<span id="action_info"></span>
				</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_cart_add_edit">
				<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户姓名</label>
						<div class="col-sm-7">
							<select class="form-control" name="userId" id="userId">
								<c:if test="${!empty userCartList}">
									<c:forEach items="${userCartList}" var="user">
										<option value="${user.rowId}">${user.userName}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">商品编号</label>
						<div class="col-sm-7">
							<select class="form-control" name="productNum" id="productNum">
								<c:if test="${!empty productCartList}">
									<c:forEach items="${productCartList}" var="product">
										<option value="${product.productNum}">${product.productName}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-7">
						<!-- 隐藏域存放商品单价 -->
							<input type="hidden" name="productPrice" id="productPrice" value="${productOrderList[0].productPrice}"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">商品数量</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,custom[number],min[1]]" id="bayCount" name="bayCount">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">商品总价</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,custom[number],min[0]]" id="totalPrices" name="totalPrices" readonly="readonly">
						</div>
					</div>
					
					<input type="hidden" id="rowId" name="rowId" />
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
					<a class="btn btn-primary" href="javascript:;" id="button_submit">提交</a>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/store-cart.js"></script>