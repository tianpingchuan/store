$(document).ready(
		function() {
			// 对表单绑定校验
			$('#form_cart_add_edit').validationEngine('attach', {
				onValidationComplete : function(form, status) {
					// 如果表单校验通过
					if (status) {
						// 执行新增或修改
						saveOrUpdate();
					}
				}
			});
			// 查询所有的数据
			initTalbeData(1);
			// 绑定新增按钮
			$('#button_add').off('click').on('click', function() {
				$('#form_cart_add_edit')[0].reset();
				$('#modal_cart').modal('show');
				// 清空所有的校验信息
				$('.formError').remove();
				// 将rowId属性的value清除，为了判断修改还是新增
				$('#rowId').removeAttr('value');
				$('#action_info').html('新增');
			});
			// 绑定Submit按钮
			$('#button_submit').off('click').on('click', function() {
				// 让当前的表单执行提交动作
				// 表单提交动作会触发表单的校验。
				$('#form_cart_add_edit').submit();
			});

			// 绑定删除超链接事件
			$('#dataTable_wrapper').off('click', '#delete').on('click',
					'#delete', function() {
						var rowId = $(this).attr("data-rowId");
						if (confirm("你确定删除吗？")) {
							$.ajax({
								url : 'cart/dodelete/' + rowId,
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

			// 绑定修改超链接
			$('#dataTable_wrapper').off('click', '#update').on('click',
					'#update', function() {
						var rowId = $(this).attr("data-rowId");
						$.ajax({
							// role/goupdate/1
							url : 'cart/goupdate/' + rowId,
							success : function(cart) {
								// if(true) js代表true的
								if (cart) {
									$('#modal_cart').modal('show');
									// 清空所有的校验信息
									$('.formError').remove();
									$('#userId').val(cart.userId);
									$('#productNum').val(cart.productNum);
									$('#bayCount').val(cart.bayCount);
									$('#bayCount').val(cart.bayCount);
									$('#totalPrices').val(cart.totalPrices);
									$('#rowId').val(cart.rowId);
									$('#action_info').html('修改');
								}
							}
						});
					});

			// 绑定搜索按钮
			$('#button_search').on('click', function() {
				initTalbeData(1);
			});

			$('#productNum').change(function() {
				var productNum = $('#productNum').val();
				$.ajax({
					type : 'post',
					url : 'product/findNum/' + productNum,
					success : function(product) {
						$('#productPrice').val(product.productPrice);
						var bayCount = $('#bayCount').val();
						var productPrice = $('#productPrice').val();
						var totalPrices = bayCount * productPrice;
						$('#totalPrices').val(totalPrices);
					}
				});
			});
//绑定改变事件将价格算出
			$("#bayCount").change(function() {
				var bayCount = $('#bayCount').val();
				var productPrice = $('#productPrice').val();
				var totalPrices = bayCount * productPrice;
				$('#totalPrices').val(totalPrices);
			});

		});

function saveOrUpdate() {
	var rowId = $('#rowId').val();
	if (rowId) {// 如果主键有信息，则判断是修改
		$.ajax({
			type : 'post',
			url : 'cart/doupdate',
			data : $('#form_cart_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_cart').modal('hide');
					initTalbeData(1);
				}
			}
		});
	} else {// 判断是新增
		$.ajax({
			type : 'post',
			url : 'cart/add',
			data : $('#form_cart_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_cart').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}

// init table data
function initTalbeData(pageNo) {
	$.ajax({
		type : 'post',
		url : 'cart/find/' + pageNo,
		data : $('#form_search').serialize(),
		success : function(htmlData) {
			$('#dataTable_wrapper').html(htmlData);
		}
	});
}

// 响应分页
function page_select(pageNo) {
	initTalbeData(pageNo);
}
// 上一页
function page_prev() {
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	// console.log(current_page);
	initTalbeData(current_page - 1);
}
// 下一页
function page_next() {
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	initTalbeData(parseInt(current_page) + 1);
}