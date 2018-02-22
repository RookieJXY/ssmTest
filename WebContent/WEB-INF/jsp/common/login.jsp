<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en-us">
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<!-- <script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script> -->
</head>
<body id="login" class="animated fadeInDown" onload="checkError();"
	onkeydown="login()">
	<nav class="navbar navbar-inverse">
		<h2 style="color: white; text-align: center;">员工管理系统，欢迎登陆</h2>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-8">
					<img
						src="http://www.d9soft.com/uploadfile/2014/0630/20140630115110237.jpg"
						class="img-responsive" alt="Responsive image">
				</div>
				<div class="col-md-4">
					<form action="user/login" method="post" id="login-form">
						<div class="form-group">
							<label for="username">用户名</label> <input type="text"
								name="username" class="form-control" id="username"
								placeholder="Username" value="${cookie.username.value}" />
								<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i>请输入用户名</b>
						</div>
						<section>
						<div class="form-group">
							<label for="password">密码</label> <input type="password"
								name="password" class="form-control" id="password"
								placeholder="Password" value="${cookie.password.value}" />
								<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i>请输入密码</b>
						</div>
						</section>
						<div id="errorDiv" class="alert adjusted alert-info fade in"
							style="display: none">
							<button class="close" data-dismiss="alert">x</button>
							<i class="fa-fw fa-lg fa fa-exclamation-triangle"></i> <strong>${error}</strong>
						</div>
						
						<section>
						<div class="checkbox">
							<label> <input type="checkbox" name="rememberMe"
								id="rememberMe"><i></i>记住我
							</label>
						</div>
						</section>
						<button id="sign" type="submit" class="btn btn-primary">登录</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script src="js/plugin/pace/pace.min.js"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');} </script>

	<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

	<!-- BOOTSTRAP JS -->
	<script src="js/bootstrap/bootstrap.min.js"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script src="js/notification/SmartNotification.min.js"></script>

	<!-- JARVIS WIDGETS -->
	<script src="js/smartwidgets/jarvis.widget.min.js"></script>

	<!-- EASY PIE CHARTS -->
	<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

	<!-- SPARKLINES -->
	<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script src="js/plugin/select2/select2.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices -->
	<script src="js/plugin/fastclick/fastclick.js"></script>

	<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

	<!-- MAIN APP JS FILE -->
	<script src="js/app.js"></script>

	<script type="text/javascript">
			var message = '${ message }';
			if(message != null && message != '') {
				alert(message);
			}
		
			runAllForms();

			$(function() {
				var username = "${cookie.username.value}";
				console.log(username);
				if(username) {
					$('#rememberMe')[0].checked = true;
				} else {
					$('#rememberMe')[0].checked = '';
				}
				// Validation
				$("#login-form").validate({
					// Rules for form validation
					rules : {
						username : {
							required : true
						},
						password : {
							required : true
						}
					},

					// Messages for form validation
					messages : {
						username : {
							required : 'Please enter your userName'
						},
						password : {
							required : 'Please enter your password'
						}
					},

					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
				});
			});
			
			
		 	function checkError(){
		 		if( "${error}".length > 0 ){
		 			$('#errorDiv').show();	 	
		 		}
		 	}
		 	
		 	function login(){
		 		if(event.keyCode == 13){
		 			document.getElementById("sign").click();
		 		}
		 	}
		</script>

</body>
</html>