<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link rel="stylesheet"
	href="${path}/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${path}/bower_components/font-awesome/css/font-awesome.css">
<link rel="stylesheet"
	href="${path}/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
<link rel="stylesheet"
	href="${path}/bower_components/select2/dist/css/select2.min.css">
<link rel="stylesheet" href="${path}/dist/css/animate.css">

<title>${title}</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	
	<div class="wrapper slideInLeft">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>
		
		<div class="content-wrapper">
		
			<section class="content-header ">
            <h1>
                Warranty
                <small>Warranty Clame</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}"><i class="fa fa-dashboard"></i> Warranty</a></li>
                <li class="active">Warranty Clame</li>
            </ol>
        </section>
        
        <section class="content container-fluid animated fadeInLeft">
        	
        	<div class="box box-primary">
        		
        		<div class="box-header with-border">
                    <h3 class="box-title">Warranty Clame</h3>
                </div>
        		
        		<div class="box-body">
        		
        		</div>
        		
        	</div>
        	
        </section>
		</div>
	</div>

    <jsp:include page="../../core/footer.jsp"></jsp:include>
	<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


    <script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${path}/bower_components/select2/dist/js/select2.full.min.js"></script>
    <script src="${path}/dist/js/adminlte.min.js"></script>
	<script src="${path}/dist/js/notify.min.js"></script>
</body>
</html>