<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>

<body>
	<section id="widget-grid" style="margin:1%">
		<div class="jarviswidget jarviswidget-color-teal" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-fullscreenbutton="false" >
			<header>
<!-- 				<span class="widget-icon"> <i class="fa fa-edit"></i> </span> -->
				<h2>用户查询</h2>				
			</header>
			<div>
				<div class="jarviswidget-editbox"></div>
				<div class="widget-body">
					<div id="searchFrame" class="panel panel-default" style="margin:2%">
						<div>
							<div class="input-group">
								<input id="keywords" type="text" class="form-control"
							  			placeholder="输入用户名或者用户代码查询"/>
							  <span class="input-group-addon">
							  	<button class="btn-primary" onclick="listEntireUsers()">搜索</button>
							  </span>
							</div>
						</div>
					</div>
				
					<div id="mainArea"  style="margin:2%"></div>
				</div>
			</div>
		</div>
	</section>
	
	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" 
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				  <h4 class="modal-title" id="myModalLabel">用户详细信息</h4>
				</div>
				<div id="detailModalBody" class="modal-body">
				</div>
			  <div class="modal-footer">
			    <button type="button" class="btn btn-default" data-dismiss="modal">
			    	关闭
			    </button>
			  </div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="js/app/page.js"></script>
	<script type="text/javascript">
		function listEntireUsers() {
			var url = 'user/listEntireByPage';
			var keywords = $('#keywords').val();
			$.post(url, 
					{
						keywords : keywords
					},
					function(data) {
						$('#mainArea').html(data);
					}
			);
		}
		
		$(document).ready(
			listEntireUsers()
		);
	</script>
</body>
</html>