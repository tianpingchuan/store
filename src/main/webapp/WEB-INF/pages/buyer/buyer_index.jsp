<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 个人信息管理
	</div>
	<div class="card-body">
		<div class="table-responsive">

			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">用户名称</th>
									<th scope="col">用户账号</th>
									<th scope="col">用户手机</th>
									<th scope="col">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${!empty buyerUserPersonal}">
										<tr>
											<td>${buyerUserPersonal.userName}</td>
											<td>${buyerUserPersonal.userCode}</td>
											<td>${buyerUserPersonal.userPhone}</td>
											<td><a href="javascript:;" data-rowId="${buyerUserPersonal.rowId}" id="update">修改</a> <!-- data-XXX H5以后允许自定义元素的属性 --> 
										</tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_user" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
			
				<h5 class="modal-title" id="exampleModalLabel">用户<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_user_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[ajaxUserName]]" id="userName" name="userName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户账号</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[ajaxUserCode]]" id="userCode" name="userCode">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户密码</label>
						<div class="col-sm-7">
							<input type="password" class="form-control validate[required]" id="userPass" name="userPass">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户手机</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,custom[phone]]" id="userPhone" name="userPhone">
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

<script src="assert/page/store-personal.js"></script>