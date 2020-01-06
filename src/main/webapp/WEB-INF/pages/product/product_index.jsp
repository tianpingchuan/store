<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 商品管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">商品新增</button>
	</div>
	<div class="card-body">
		<div class="table-responsive">
		
		<!-- <img alt="" src="" > -->
		
			<!-- 搜索页面开始 -->
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<form id="form_search">
							<div class="form-row align-items-center">
								<div class="col-auto my-1">
									<select class="form-control" name="catalogId">
										<option value="">目录名称</option>
										<c:if test="${!empty catalogList3}">
											<c:forEach items="${catalogList3}" var="catalog">
												<option value="${catalog.rowId}">${catalog.catalogName}</option>	
											</c:forEach>
										</c:if>
									</select>
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="productName" placeholder="产品名称">
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="productNum" placeholder="产品编号">
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
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_product" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">商品<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_product_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">目录名称</label>
						<div class="col-sm-3">
							<select class="form-control" id="change_select">
								<c:if test="${!empty catalogList3}">
									<c:forEach items="${catalogList3}" var="catalog">
										<option value="${catalog.rowId}">${catalog.catalogName}</option>	
									</c:forEach>
								</c:if>
							</select>
						</div>
						<div class="col-sm-3">
							<select class="form-control" id="catalogId" name="catalogId">
								<c:if test="${!empty catalogProductList}">
									<c:forEach items="${catalogProductList}" var="catalog">
										<option value="${catalog.rowId}">${catalog.catalogName}</option>	
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[checkProductName]]" id="productName" name="productName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品编号</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[checkProductNum]]" id="productNum" name="productNum">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品图片</label>
						<div class="col-sm-7">
							<input type="file" class="form-control validate[required]" id="proFile" name="proFile">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品价格</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,custom[number],min[0]]" id="productPrice" name="productPrice">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品库存</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,custom[number],min[0]]" id="productCount" name="productCount">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">产品介绍</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required]" id="productIntro" name="productIntro">
						</div>
					</div>
					
					<input type="hidden" id="rowId" name="rowId"/>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
				<a class="btn btn-primary" href="javascript:;" id="button_submit">提交</a>
			</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/store-product.js"></script>