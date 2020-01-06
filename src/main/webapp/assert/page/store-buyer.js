$(document).ready(function(){
	
//	对表单绑定校验
	$('#form_login').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增
				$.ajax({
					type:'post',
					url:'user/buyerlogin',
					data:$('#form_login').serialize(),
					dataType:'json',
					success:function(result){
						if(result==1){
							location.href = 'user/buyerindex';
						} else {
							alert("登录失败");
						}
					}
				});
			}
		}
	});
	
	
	//绑定Submit按钮
	$('#do_login').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_login').submit();
	});
	
	
	
	//绑定Submit按钮
	$('#login_add').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_login_add').submit();
	});
	
//	对表单绑定校验
	$('#form_login_add').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增
				$.ajax({
					type:'post',
					url:'user/buyerloginadd',
					data:$('#form_login_add').serialize(),
					dataType:'json',
					success:function(result){
						if(result){
							location.href = 'user/buyerindex';
						} else {
							alert("注册失败");
						}
					}
				});
			}
		}
	});
	
//	绑定目录超链接事件

	$('.catalog').off('click').on('click',function(){
		var rowId = $(this).attr("data-rowId");
		alert("1");
		$.ajax({
			url : 'user/findCatalog/' + rowId,
			dataType : 'html',
			success : function(htmldata) {
				$('#catalogList').html(htmldata);
			}
		});
	});
	

	
});