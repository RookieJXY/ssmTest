<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>

<body>
	<section id="widget-grid" style="margin:1%">
		<div class="jarviswidget jarviswidget-color-teal" data-widget-deletebutton="false" >
			<header>
<!-- 				<span class="widget-icon"> <i class="fa fa-edit"></i> </span> -->
				<h2>用户修改</h2>				
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
							  	<button class="btn-primary" onclick="listManagerUsers()">搜索</button>
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
	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" 
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				  <h4 class="modal-title" id="myModalLabel">用户信息修改</h4>
				</div>
				<div id="modifyModalBody" class="modal-body">
				</div>
			  <div class="modal-footer">
			    <button type="button" class="btn btn-default" data-dismiss="modal">
			    	关闭
			    </button>
			    <button type="button" class="btn btn-primary" onclick=" return modify()">
			    	保存
			    </button>
			  </div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="js/app/page.js"></script>
	<script type="text/javascript">
		function listManagerUsers() {
			var url = 'user/listManagerByPage';
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
			listManagerUsers()		
		);
		
		function checkFirstPwd(){
			if($('#password').val().trim() != "" && $('#password').val().length < 6){
				alertTips("密码长度不能少于6位!");
				return false;
			}
		}
		
		function checkPhoneNo(value) {
			var regexp = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
			return regexp.test(value);
		}
		
		function checkEmail(value) {
			var regexp = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
			return regexp.test(value);
		}
		
		function modify() {
			if ($("#userCode").val().trim() == '' || $("#email").val().trim() =='') {
				alertTips('请完善信息！');
				return false;
			}
			var phoneNo = $("#phoneNo").val();
			if(!checkPhoneNo(phoneNo)){
				alertTips("联系电话格式不正确!");
				return;
			}
			var email = $("#email").val();
			if(!checkEmail(email)){
				alertTips("电子邮箱格式不正确!");
				return;
			}
			if($("#departmentId").val().trim() == "" && $("#isManager").val() == '0'){
				alertTips("部门为空时,不能是负责人!");
				return false;
			}
			if($("#availState").val().trim() == "0" && $("#isManager").val() == '0'){
				alertTips("用户不可用时,不能选择是负责人!");
				return false;
			}

			if(checkFirstPwd() == false){
				return false;
			}
			var form = $('#user_modify_form');
			var url = form.attr('action');
			var param = form.serialize();
			var modifyUser = function() {
				$.post(url, param,
					function(data) {
						if (data.responseType == 'N') {
							listManagerUsers();
						}
						alertTips(data.responseMessage);
						$('#modifyModal').modal('hide');
					}		
				);
			}
			alertConfirm('请核对用户信息后点击确认!', modifyUser, null);
		}
	</script>
</body>
</html>