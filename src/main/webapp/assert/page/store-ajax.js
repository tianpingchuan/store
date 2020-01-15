/**
 * 重写jQuery的ajax方法,将一些通用的方法,配置放在此处统一书写。
 * @param $
 */
(function($) {
	// '严格模式'（strict mode）。顾名思义,这种模式使得Javascript在更严格的条件下运行。
	'use strict';
	// 备份jquery的ajax方法
	var _ajax = $.ajax;
	// 重写jquery的ajax方法
	$.ajax = function(opt) {
		// 备份opt中error,beforeSend,complete方法
		var fn = {
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			},
			beforeSend : function(XMLHttpRequest) {
			},
			complete : function(XMLHttpRequest, textStatus) {
			},
		};
		if (opt.error) {
			fn.error = opt.error;
		}
		if (opt.beforeSend) {
			fn.beforeSend = opt.beforeSend;
		}
		if (opt.complete) {
			fn.complete = opt.complete;
		}
		if (opt.type) {
			fn.type = opt.type;
		} else {
			opt.type = 'POST';// 默认ajax的提交方式为POST
		}
		// 扩展增强处理
		var _opt = $.extend({
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				// 错误方法增强处理
				if (XMLHttpRequest.status == '500') {// 处理500错误
					//返回的是错误信息的页面直接展示即可。
					var responseText = XMLHttpRequest.responseText;
					if (responseText != null) {
						//$('.page-content').html(responseText);
						//Layout.initContent(); // init metronic core componets
					}
					
				} else if (XMLHttpRequest.status == '404') {// 处理404错误
					//XApp.initHTML('404');
				}
			},
			beforeSend : function(XMLHttpRequest) {
				 // update the block message
			},
			complete : function(XMLHttpRequest, textStatus) {
				// unblock when remote call returns
               // $.unblockUI();
			},
			statusCode : {
				700 :function(){//自定义AJAX状态码(700:未登录)
					if(confirm("您处在未登录状态，请先登录！")){
						location.href='index';
						return false;
					}
				}
			}
		}, opt);
		return _ajax(_opt);
	};
})(jQuery);