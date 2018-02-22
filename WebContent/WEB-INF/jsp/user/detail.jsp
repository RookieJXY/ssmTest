<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix="fmt" %>

<!DOCTYPE html >
<html>
<head></head>
<body>
	<div id="user_detail">
		<form class="form-horizontal smart-form">
			<div class="row">
				<label class="col-sm-3 control-label">用户编号：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-user"></i> 
						<input type="text" name="username" class="form-control" 
							value="${user.username }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">用户名称：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-user"></i> 
						<input type="text" name="userCode" class="form-control" 
							value="${user.userCode }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">联系电话：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-earphone"></i> 
						<input type="text" name="phoneNo" class="form-control" 
							value="${user.phoneNo }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">电子邮箱：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-envelope"></i> 
						<input type="text" name="email" class="form-control" 
							value="${user.email }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">所属部门：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-tag"></i> 
						<input type="text" name="departmentName" class="form-control" 
							value="${user.departmentName }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">是否为部门负责人：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-tag"></i> 
						<input type="text" name="isManager" class="form-control" 
							value="${user.isManager == '0' ? '是' : '否' }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">用户角色：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-user"></i> 
						<input type="text" name="用户角色" class="form-control" 
							value="${user.roleName }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">可用状态：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-sort"></i> 
						<input type="text" name="userCode" class="form-control" 
							value="${user.availState == '0' ? '不可用' : '可用' }" disabled="disabled">
					</label>
				</section>
			</div>
			<div class="row">
				<label class="col-sm-3 control-label">注册时间：</label>
				<section class="col-sm-4">
					<label class="input">
						<i class="icon-append glyphicon glyphicon-calendar"></i> 
						<input type="text" name="crtTime" class="form-control" disabled="disabled"
							value="<fmt:formatDate type="both" 
								value='${user.crtTime }'/>">
					</label>
				</section>
			</div>
		</form>
	</div>
</body>
</html>