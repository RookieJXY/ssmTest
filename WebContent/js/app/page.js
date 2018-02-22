/**
 * 添加监听事件
 * 调用
 * 	在应用页面导入改JS文件
 * 	在添加page.jsp页面调用方法listenClickEvent(area, url, parentId)启动事件监听 ,如:
 * 	$(document).ready(
 * 		listenClickEvent($('#mainArea'), 
 * 						'/agree-soa/department/listByPage')
 * 	);
 * 
 * @param area 响应页面赢写入的父元素的jQuery对象
 * @param url 请求Url
 * @param parentId 分页组件父元素的jQuery对象 可不传
 */
function listenClickEvent(area, url, parentId) {
	if (parentId == undefined || parentId == '') {
		parentId = '';
	} else {
		parentId = '#' + parentId + ' ';
	}
	
	$(parentId + '#previousPage').click(function(){
		toPreviousPage(area, url, parentId);
	});
	$(parentId + '#nextPage').click(function(){
		toNextPage(area, url, parentId);
	});
	$(parentId + '#firstPage').click(function() {
		toFirstPage(area, url, parentId);
	});
			
	$(parentId + '#lastPage').click(function() {
		toLastPage(area, url, parentId);
	});
	$(parentId + '#pageNum').change(function() {
		toChangePage(area, url, parentId);
	});
	$(parentId + '#pageSize').change(function() {
		toChangePageSize(area, url, parentId);
	});
}

function toPreviousPage(area, url, parentId){
	var currentPage = parseInt($(parentId + '#pageNum').val());
	var keywords = $('#keywords').val();
	if (currentPage > 1) {
		currentPage -= 1;
	}
	$.post(url,
		{
			currentPage : currentPage,
			pageSize : $(parentId + '#pageSize').val(),
			keywords : keywords
		},
		function(data){
			area.html(data);
		}
	);
}

function toNextPage(area, url, parentId){
	var totalPage = $(parentId + '#totalPage').val();
	var currentPage = parseInt($(parentId + '#pageNum').val());
	var keywords = $('#keywords').val();
	if (currentPage < totalPage) {
		currentPage += 1;
	}
	$.post(url,
		{
			currentPage : currentPage,
			pageSize : $(parentId + '#pageSize').val(),
			keywords : keywords
		},
		function(data){
			area.html(data);
		}
	);
}

function toFirstPage(area, url, parentId){
	var keywords = $('#keywords').val();
	$.post(url,
		{
			currentPage : 1,
			pageSize : $(parentId + '#pageSize').val(),
			keywords : keywords
		},
		function(data){
			area.html(data);
		}
	);
}

function toLastPage(area, url, parentId){
	var totalPage = $(parentId + '#totalPage').val();
	var keywords = $('#keywords').val();
	$.post(url,
		{
			currentPage : totalPage,
			pageSize : $(parentId + '#pageSize').val(),
			keywords : keywords
		},
		function(data){
			area.html(data);
		}
	);
}

function toChangePage(area, url, parentId) {
	var currentPage = $(parentId + '#pageNum').val();
	var keywords = $('#keywords').val();
	$.post(url,
			{
				currentPage : currentPage,
				pageSize : $(parentId + '#pageSize').val(),
				keywords : keywords
			},
			function(data){
				area.html(data);
			}
		);
}

function toChangePageSize(area, url, parentId) {
	var keywords = $('#keywords').val();
	$.post(url,
			{
				currentPage : 1,
				pageSize : $(parentId + '#pageSize').val(),
				keywords : keywords
			},
			function(data){
				area.html(data);
			}
		);
}
	