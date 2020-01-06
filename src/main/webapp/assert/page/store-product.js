$(document).ready(function(){
//	对表单绑定校验
	$('#form_product_add_edit').validationEngine('attach',{
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
		$('#form_product_add_edit')[0].reset();
		$('#modal_product').modal('show');
//		清空所有的校验信息
		$('.formError').remove();
//		尝试移出data-skip的属性（为了唯一性校验）
		$('#catalogName').removeAttr('data-skip');
//		将rowId属性的value清除，为了判断修改还是新增
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
		
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_product_add_edit').submit();
	});
	
//	绑定删除超链接事件
	$('#dataTable_wrapper').off('click','#delete').on('click','#delete',function(){
		var rowId = $(this).attr("data-rowId");
		if (confirm("你确定删除吗？")) {
			$.ajax({
				url : 'product/dodelete/' + rowId,
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
	
//	绑定上下架超链接事件
	$('#dataTable_wrapper').off('click','#putawayOrSoldOut').on('click','#putawayOrSoldOut',function(){
		var rowId = $(this).attr("data-rowId");
		var putawayOrSoldOut = $(this).attr("data-putawayOrSoldOut");
		if (putawayOrSoldOut == 1) {//下架
			if (confirm("你确定下架吗？")) {
				$.ajax({
					url : 'product/soldout/' + rowId,
					dataType : 'json',
					success : function(result) {
						if (result) {
							// 调用查询table表单的数据
							initTalbeData(1);
						}
					}
				});
			}
		} else {//上架
			if (confirm("你确定上架商品吗？")) {
				$.ajax({
					url : 'product/putaway/' + rowId,
					dataType : 'json',
					success : function(result) {
						if (result) {
							// 调用查询table表单的数据
							initTalbeData(1);
						}
					}
				});
			}
		}
		
	});
	
//	绑定修改超链接
	$('#dataTable_wrapper').off('click','#update').on('click','#update',function(){
		var rowId = $(this).attr("data-rowId");
		$.ajax({
	 		// role/goupdate/1
	 		url : 'product/goupdate/' + rowId,
	 		success : function(product) {
//	 			if(true)	js代表true的
	 			if(product) {
	 	 			$('#modal_product').modal('show');
//	 	 			清空所有的校验信息
	 	 			$('.formError').remove();
	 	 			$('#catalogId').val(product.catalogId);
	 	 			$('#productName').val(product.productName);
	 	 			$('#productNum').val(product.productNum);
	 	 			$('#proFile').val(product.proFile);
	 	 			$('#productPrice').val(product.productPrice);
	 	 			$('#productCount').val(product.productCount);
	 	 			$('#productIntro').val(product.productIntro);
	 	 			
//	 	 			var catalogName = product.catalogName;
////	 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
//	 	 			$('#catalogName').val(catalogName).attr('data-skip',catalogName);
	 	 			$('#rowId').val(product.rowId);
	 	 			$('#action_info').html('修改');
	 			}
	 		}
	 	});
	});
	
//	绑定搜索按钮
	$('#button_search').on('click',function(){
		initTalbeData(1);
	});
	
//	绑定select框内容改变事件
	$('#change_select').change(function(){
		//要触发的事件
		var parentCatalogId = $('#change_select').val();
		$('#catalogId').html('');
		$.ajax({
			type:'post',
	 		url : 'product/gochange/' + parentCatalogId,
	 		success : function(htmlData) {
	 			if(htmlData) {
	 				$('#catalogId').html(htmlData);
	 			}
	 		}
	 	});
    });
	
});


function saveOrUpdate() {
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断是修改
		var formObj = $('#form_product_add_edit')[0];
		var formData = new FormData(formObj);
		$.ajax({
			type:'post',
			url:'product/doupdate',
			data:formData,
			cache: false, //不缓存
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false,// 告诉jQuery不要去设置Content-Type请求头
			success:function(result){
				if(result){
					$('#modal_product').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}else{//判断是新增
		//将表单封装成异步上传二进制文件。
		//new FormData的参数是一个DOM对象，而非jQuery对象
		//var formObj = document.getElementById('form_test');
		var formObj = $('#form_product_add_edit')[0];
		var formData = new FormData(formObj);
		$.ajax({
			type:'post',
			url:'product/upload',
			data:formData,//异步上传的二进制文件
			cache: false, //不缓存
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false,// 告诉jQuery不要去设置Content-Type请求头
			success:function(result){
//				$("img").attr("src",result);
				$('#modal_product').modal('hide');
				initTalbeData(1);
			}
		});
		
//		$.ajax({
//			type:'post',
//			url:'product/add',
//			data:$('#form_product_add_edit').serialize(),
//			dataType:'json',
//			success:function(result){
//				if(result){
//					$('#modal_product').modal('hide');
//					initTalbeData(1);
//				}
//			}
//		});
	}
}

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'product/find/'+pageNo,
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