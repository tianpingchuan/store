$(document).ready(function(){
//	对表单绑定校验
	$('#form_address_add_edit').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有的数据
	initTalbeData(1);
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_address_add_edit')[0].reset();
		$('#modal_address').modal('show');
//		清空所有的校验信息
		$('.formError').remove();
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
		$.ajax({
			 type:'post',
			 url:'address/findbeijing/',
			 success:function(htmlData){
				 $('#cityCode').html(htmlData);
			 }
		});
		$.ajax({
			 type:'post',
			 url:'address/findbeijingarea/',
			 success:function(htmlData){
				 $('#areaCode').html(htmlData);
			 }
		});
		
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_address_add_edit').submit();
	});
	
//	绑定删除超链接事件
	$('#dataTable_wrapper').off('click','#delete').on('click','#delete',function(){
		var rowId = $(this).attr("data-rowId");
		if (confirm("你确定删除吗？")) {
			$.ajax({
				url : 'address/dodelete/' + rowId,
				dataType : 'json',
				success : function(result) {
					if (result) {
						// 调用查询table表单的数据
						initTalbeData(1);
					}
				}
			});
		}
	});
	
	
//	绑定修改超链接
	$('#dataTable_wrapper').off('click','#update').on('click','#update',function(){
		var rowId = $(this).attr("data-rowId");
		$.ajax({
	 		// role/goupdate/1
	 		url : 'address/goupdate/' + rowId,
	 		success : function(user) {
//	 			if(true)	js代表true的
	 			if(user) {
	 	 			$('#modal_address').modal('show');
//	 	 			清空所有的校验信息
	 	 			$('.formError').remove();
	 	 			var userName = user.userName;
//	 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
	 	 			$('#userName').val(userName).attr('data-skip',userName);
	 	 			var userCode = user.userCode;
	 	 			$('#userCode').val(userCode).attr('data-skip',userCode);
	 	 			$('#userCode').val(user.userCode);
	 	 			$('#userPass').val(user.userPass);
	 	 			$('#userPhone').val(user.userPhone);
	 	 			$('#rowId').val(user.rowId);
	 	 			$('#action_info').html('修改');
	 			}
	 		}
	 	});
	});
	
//	绑定搜索按钮
	$('#button_search').on('click',function(){
		initTalbeData(1);
	});
	
//	select框内容改变时触发事件的实现
	$('#provinceCode').change(function(){
		//要触发的事件
		var provinceCode = $('#provinceCode').val();
		$('#cityCode').html('');
		$.ajax({
			type:'post',
	 		url : 'address/gochange1/' + provinceCode,
	 		success : function(htmlData) {
	 			if(htmlData) {
	 				$('#cityCode').html(htmlData);
	 				var cityCode = $('#cityCode').val();
	 				$.ajax({
	 					type:'post',
	 			 		url : 'address/gochange2/' + cityCode,
	 			 		success : function(htmlData) {
	 			 			if(htmlData) {
	 			 				$('#areaCode').html(htmlData);
	 			 			}
	 			 		}
	 			 	});
	 			}
	 		}
	 	});
		 
    });
	$('#cityCode').change(function(){
		//要触发的事件
		var cityCode = $('#cityCode').val();
		$('#areaCode').html('');
		$.ajax({
			type:'post',
	 		url : 'address/gochange2/' + cityCode,
	 		success : function(htmlData) {
	 			if(htmlData) {
	 				$('#areaCode').html(htmlData);
	 			}
	 		}
	 	});
    });
	
});


function saveOrUpdate() {
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断是修改
		$.ajax({
			type:'post',
			url:'address/doupdate',
			data:$('#form_address_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_address').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}else{//判断是新增
		$.ajax({
			type:'post',
			url:'address/add',
			data:$('#form_address_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_address').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'address/find/'+pageNo,
		 data:$('#form_search').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 }
 
//响应分页
 function page_select(pageNo){
	 initTalbeData(pageNo);
 }
 //上一页
 function page_prev(){
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	//console.log(current_page);
	initTalbeData(current_page-1);
 }
 //下一页
 function page_next(){
	 var current_page = $('#ul_pagination').find('.active').find('span').text();
	 initTalbeData(parseInt(current_page)+1);
 }