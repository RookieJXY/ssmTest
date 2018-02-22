<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
String contextRoot = request.getRealPath("/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>500</title>
</head>
<body>
<!--[if IE 9]>
	<style>
		.error-text {
			color: #333 !important;
		}
	</style>
<![endif]-->

	<!-- row -->
	<div class="row">
	
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	
			<div class="row">
				<div class="col-sm-12">
					<div class="text-center error-box">
						<h1 class="error-text tada animated"><i class="fa fa-times-circle text-danger error-icon-shadow"></i> Error 500</h1>
						<h2 class="font-xl"><strong>Oooops, Something went wrong!</strong></h2>
						<br />
						<p class="lead semi-bold">
							<strong>You have experienced a technical error. We apologize.</strong><br><br>
							<small>
								We are working hard to correct this issue. Please wait a few moments and try your search again. <br> In the meantime, check out whats new on SmartAdmin:
							</small>
						</p>
						<ul class="error-search text-left font-md">
				            <li><a href="javascript:void(0);"><small>Go to My Dashboard <i class="fa fa-arrow-right"></i></small></a></li>
				            <li><a href="javascript:void(0);"><small>Contact SmartAdmin IT Staff <i class="fa fa-mail-forward"></i></small></a></li>
				            <li><a href="javascript:void(0);"><small>Report error!</small></a></li>
				            <li><a href="javascript:void(0);"><small>Go back</small></a></li>
				        </ul>
					</div>
	
				</div>
	
			</div>
	
		</div>
		
	</div>
	<!-- end row -->

	<script type="text/javascript">
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		// pageSetUp();

		// PAGE RELATED SCRIPTS
		$("#search-error").focus();
	</script>

</body>
</html>