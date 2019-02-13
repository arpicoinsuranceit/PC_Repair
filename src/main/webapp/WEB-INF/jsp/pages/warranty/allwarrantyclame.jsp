<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${path}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/bower_components/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${path}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${path}/dist/css/CustomStyles.css">
    <link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
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
                <small>All Warranty Clame</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}"><i class="fa fa-dashboard"></i> Warranty</a></li>
                <li class="active">All Warranty Clame</li>
            </ol>
        </section>
        
        <section class="content container-fluid animated fadeInLeft">
        	
        	<div class="row">
                <div class="col-md-3 col-sm-3 col-xs-6">
                   
                </div>
            </div>

            <div class="row voffset10top">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">All Warranty Clame</h3>
                        </div>
                        <div class="box-body">

                            <table id="table_warranty" class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Repair ID</th>
                                    <!-- <th>Assest ID</th> -->
                                    <th>Priority</th>
                                    <th>Remark</th>
                                    <!-- <th></th> -->
                                </tr>
                                </thead>

                                <tbody>
                                </tbody>

                                <tfoot>
                                <tr>
                                    <th>Repair ID</th>
                                    <!-- <th>Assest ID</th> -->
                                    <th>Priority</th>
                                    <th>Remark</th>
                                    <!-- <th></th> -->
                                </tr>
                                </tfoot>
                            </table>

                        </div>
                    </div>
                   
                </div>
                
            </div>


        </section>
    </div>
        	
        </section>
		</div>
	</div>

    <jsp:include page="../../core/footer.jsp"></jsp:include>
	<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


    <script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${path}/dist/js/adminlte.min.js"></script>
    <script src="${path}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="${path}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="${path}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${path}/bower_components/fastclick/lib/fastclick.js"></script>
	
	<script type="application/javascript">
	
		var table = $('#table_warranty').DataTable({
            "pageLength": 10,
            "ajax": "${path}/all_warranty_clame_dt"

        });
	</script>

</body>
</html>