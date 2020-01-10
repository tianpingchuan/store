$(document).ready(function(){
//	对表单绑定校验
	$('#form_user_add_edit').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增或修改
				update();
			}
		}
	});

	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_user_add_edit').submit();
	});
	
	
//	绑定修改超链接
	$('#dataTable_wrapper').off('click','#update').on('click','#update',function(){
		var rowId = $(this).attr("data-rowId");
		$.ajax({
	 		// role/goupdate/1
	 		url : 'user/goupdate/' + rowId,
	 		success : function(user) {
//	 			if(true)	js代表true的
	 			if(user) {
	 	 			$('#modal_user').modal('show');
//	 	 			清空所有的校验信息
	 	 			$('.formError').remove();
	 	 			var userName = user.userName;
//	 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
	 	 			$('#userName').val(userName).attr('data-skip',userName);
	 	 			var userCode = user.userCode;
	 	 			$('#userCode').val(userCode).attr('data-skip',userCode);
	 	 			$('#userCode').val(user.userCode);
	 	 			$('#userPhone').val(user.userPhone);
	 	 			$('#rowId').val(user.rowId);
	 	 			$('#action_info').html('修改');
	 			}
	 		}
	 	});
	});
	
	
});


function update() {
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断是修改
		$.ajax({
			type:'post',
			url:'user/doupdate',
			data:$('#form_user_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_user').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}

 