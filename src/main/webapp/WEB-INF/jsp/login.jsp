<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="${path}/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${path}/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
<title>${title}</title>
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><img src="${path}/images/logo_1.png"
			style="height: 80px; margin-top: 5px;"></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
			
			<p class="login-form-msg" style="color: #FF0000">${login_error}</p>

			<form id="form_login" action="${path}/login" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="userName" placeholder="Username">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password" placeholder="Password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					
					<!-- /.col -->
					<div class="col-xs-4 col-xs-offset-4">
						<input id="button_login" type="submit" class="btn btn-primary btn-block btn-flat" value="Sign In"/>
					</div>
					<!-- /.col -->
				</div>
			</form>
			

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${path}/dist/js/adminlte.min.js"></script>
	
	<!-- <script type="text/javascript">
		$("#button_login").click(function (){
			var data = $("#form_login").serialize();
			
			$.ajax({
			  url: "${path}/login",
			  type: "post",
			  data: data,
			  success: function (resp) {
              },
              error: function () {
                  alert('Error');
              }
			});
		});
	</script> -->
	
</body>

</html>