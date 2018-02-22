<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
	<section id="widget-grid" style="margin:1%">
		<div class="jarviswidget jarviswidget-color-teal" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-fullscreenbutton="false">
			<header>
				<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
				<h2>用户新增 </h2>				
			</header>			
			<div>
				<div class="jarviswidget-editbox"></div>
				<div class="widget-body">
					<form id="user_register_form" class="smart-form form-horizontal" action="user/register">
						<fieldset>
							<div class="row">
								<label class="col-sm-2 control-label">用户编号：</label>
								<section class="col-sm-3">
									<label class="input"> 
										<i class="icon-append glyphicon glyphicon-user"></i> 
										<input id="username" type="text" name="username" maxlength="10">
										<b class="tooltip tooltip-top-right">
											<i class="fa fa-warning txt-color-teal"></i> 
											不能出现中文，不得超过10个字符
										</b> 
									</label>
								</section>
								<label class="col-sm-2 control-label">用户名称：</label>
								<section class="col-sm-3"> 
									<label class="input"> 
										<i class="icon-append glyphicon glyphicon-user"></i> 
										<input id="userCode" type="text" name="userCode" maxlength="10">
										<b class="tooltip tooltip-top-right">
											<i class="fa fa-warning txt-color-teal"></i> 
											用户实际名称，可以是中文，不得超过30个字符
										</b>
									</label> 
								</section>
							</div>
							<div class="row">
								<label class="col-sm-2 control-label">用户密码：</label>
								<section class="col-sm-3"> 
									<label class="input"> 
										<i class="icon-append fa fa-asterisk"></i> 
										<input id="password" type="password" name="password" maxlength="16" onblur="checkFirstPwd()">
										<b class="tooltip tooltip-top-right">
											<i class="fa fa-warning txt-color-teal"></i> 
											 请输入6到16位密码，只能包含字母、数字、下划线
										</b> 
									</label> 
								</section>
			
								<label class="col-sm-2 control-label">重复密码：</label>
								<section class="col-sm-3"> 
									<label class="input"> 
										<i class="icon-append fa fa-asterisk"></i> 
										<input id="pwd_echo" type="password" name="pwd_echo" maxlength="16" 
											onblur="checkPwd();"> 
									</label>
								</section>
							</div>
							<div class="row">
								<label class="col-sm-2 control-label">联系电话：</label>
								<section class="col-sm-3"> 
									<label class="input"> 
										<i class="icon-append glyphicon glyphicon-earphone"></i> 
										<input id="phoneNo" type="text" name="phoneNo" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" maxlength="30"> 
									</label> 
								</section>
			
								<label class="col-sm-2 control-label">电子邮箱：</label>
								<section class="col-sm-3"> 
									<label class="input"> 
										<i class="icon-append glyphicon glyphicon-envelope"></i> 
										<input id="email" type="text" name="email" maxlength="50">
									</label> 
								</section>
							</div>
							<div class="row">
								<label class="col-sm-2 control-label">所属部门：</label>
								<section class="col-sm-3">
									<select id="departmentId" name="departmentId" class="select2">
										<option value="">--请选择部门--</option>
										<c:forEach var="department" items="${ departmentList }">
											<option value="${department.departmentId }">${department.departmentName }</option>
										</c:forEach>
									</select>
								</section>
								<label class="col-sm-2 control-label">是否为部门负责人：</label>
								<section class="col-sm-3">
									<select id="isManager" name="isManager" class="select2">
										<option value="">--请选择--</option>
<%-- 										<c:forEach var="department" items="${ departmentList }"> --%>
<%-- 											<option value="${department.departmentId }">${department.departmentName }</option> --%>
<%-- 										</c:forEach> --%>
										<option value="0">是</option>
										<option value="1">否</option>
									</select>
								</section>
							</div>
							<div class="row">
								<label class="col-sm-2 control-label">用户角色：</label>
								<section class="col-sm-3">
									<select id="roleId" name="roleId" class="select2">
										<c:forEach var="role" items="${ roleList }">
<%-- 											<option  value="${role.roleId }"  --%>
<%-- 												<c:if test="${ role.roleName == '普通用户' }">selected</c:if>>${role.roleName }</option> --%>
											<option  value="${role.roleId }"
											<c:if test="${ role.roleName == '普通用户' }">selected</c:if>>${role.roleName }</option>
										</c:forEach>
									</select>
								</section>
							</div>
							<div class="row">
								<section class="col-sm-5 control-label">
									<button type="button" class="btn btn-sm btn-primary" onclick=" return register()">
										确认
									</button>
								</section>
								<section class="col-sm-2 control-label">
									<button type="reset" class="btn btn-sm btn-warning">重置</button>
								</section>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	<script type="text/javascript">
		pageSetUp();
		function checkPwd() {
			if ($('#password').val() != $('#pwd_echo').val()) {
				alertTips("两次密码输入不一致，请重新输入！");
				return;
			}
		}

		function checkFirstPwd(){
			if($('#password').val().length < 6){
				alertTips("密码长度不能少于6位!");
				return;
			}
		}
		
		function checkUsername(value) {
			var regexp = /^[a-zA-Z0-9_-]{1,10}$/;
			return regexp.test(value);
		}
		
		function checkPhoneNo(value) {
			var regexp = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
			return regexp.test(value);
		}
		
		function checkEmail(value) {
			var regexp = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
			return regexp.test(value);
		}
		
		function register() {
			if ($("#username").val().trim() == "" 
				|| $("#userCode").val().trim() == ""
					|| $("#password").val().trim() == ""
						|| $("#pwd_echo").val().trim() == ""
// 							|| $("#phoneNo").val().trim() == ""
								|| $("#email").val().trim() == ""
									|| $("#roleId").val().trim() == "") {
				alertTips('请完善信息！');
				return false;
			}
			
			var username = $("#username").val();
			if(!checkUsername(username)){
				alertTips("用户编号只能写字母或者数字!");
				return;
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
			
			if($("#isManager").val().trim() == "" && $("#departmentId").val().trim() == ""){
				$("#isManager").val('1');
			}
			
			if($("#departmentId").val().trim() == "" && $("#isManager").val() == '0'){
				alertTips("部门为空时,不能是负责人!");
				return;
			}
			
			checkFirstPwd();
			checkPwd();
			
			var form = $('#user_register_form');
			var url = form.attr('action');
			var param = form.serialize();
			var registerUser = function() {
				sendAsynRequest(url, param, 
						function(data) {
							alertTips(data.responseMessage);
							if ('N' == data.responseType) {
								$.post('user/toRegister',
										function (data) {
											$('#content').html(data);
										}
								);
							}
						});
			}
			alertConfirm('请核对用户信息后点击确认!', registerUser, null);
		}
	</script>
</body>
</html>