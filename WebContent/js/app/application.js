/**
 * 重构select2样式
 * @param selectObj 下拉列表对象，应传入JS对象而不是jQuery对象
 */
function reorgCssOfSelect2 (selectObj) {
	if ($.fn.select2) {
		$(selectObj).each(function() {
			var $this = $(this);
			var width = $this.attr('data-select-width') || '100%';
			//, _showSearchInput = $this.attr('data-select-search') === 'true';
			$this.select2({
				//showSearchInput : _showSearchInput,
				allowClear : true,
				width : width
			});
		});
	}
}

/**
 * 发送异步的请求
 * @param url	请求URL
 * @param param	传递给后台的参数
 * @param callBack	请求成功时的回调函数
 */
function sendSynRequest (url, param, callBack) {
	$.ajax({
		type 	:	'post',
		url 	:    url,
		data 	: 	 param,
		async 	:    true,
		success :    callBack
	});
}

/**
 * 发送同步的请求
 * @param url	请求URL
 * @param param	传递给后台的参数
 * @param callBack	请求成功时的回调函数
 */
function sendAsynRequest (url, param, callBack) {
	$.ajax({
		type 	:	'post',
		url 	:    url,
		data 	: 	 param,
		async 	:    false,
		success :    callBack
	});
}

/**
 * 全局的提示框弹出
 */
function alertTips (tips) {
	$('#tipsBody').text(tips);
	$('#standardTips').modal('toggle');
}

/**
 * 全局的提示框隐藏
 */
function standardTipsHide () {
	$('#standardTips').modal('hide');
}

/**
 * 全局的confirm确认提示框
 * @param tips 提示消息
 * @param sureFn 点击确认按钮时触发的方法
 * @param cancelFn 点击取消按钮时出发的方法
 */
function alertConfirm (tips, sureFn, cancelFn) {
	$('#confirmBody').text(tips);
	$('#standardConfirm').modal('toggle');
	var modalMiss = function() {
		$('#standardConfirm').modal('hide');
	};
	var callbacks = $.Callbacks();
	callbacks.add(modalMiss);
	if (sureFn && sureFn instanceof Function) {
		callbacks.add(sureFn);
	}
	if (cancelFn && cancelFn instanceof Function) {
		callbacks.add(cancelFn);
	}
	
	var sureClick = function() {
		if (callbacks.has(cancelFn)) {
			callbacks.remove(cancelFn);
		}
		callbacks.fire();
		callbacks.empty();
	};
	var cancelClick = function() {
		if (callbacks.has(sureFn)) {
			callbacks.remove(sureFn);
		}
		callbacks.fire();
		callbacks.empty();
	};
	$('#sureBtn').click(sureClick);
	$('#cancelBtn').click(cancelClick);
}