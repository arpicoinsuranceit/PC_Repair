<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<div class="wrapper">
    <jsp:include page="../../core/navigation.jsp"></jsp:include>
	
	<div class="content-wrapper ">
        <section class="content-header">
            <h1>
                BACKUP
                <small>RECIVED BACKUP</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}"><i class="fa fa-dashboard"></i>BACKUP</a></li>
                <li class="active">ALL BACKUP</li>
            </ol>
        </section>

        <section class="content container-fluid animated fadeInLeft">

            <div class="row">
                <div class="col-md-3 col-sm-3 col-xs-6">
                    <a href="${path}/add_backup">
                        <button type="button" class="btn btn-block btn-success btn-flat">Add Backup</button>
                    </a>
                </div>
            </div>

            <div class="row voffset10top">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Backup</h3>
                        </div>
                        <div class="box-body">

                            <table id="table_assignee" class="table table-bordered col-10" >
                                <thead>
                                <tr>
                                    <th>Repair ID</th>
                                    <th>Asset Id</th>
                                    <th>Send Date</th>
                                    <th>Return Date</th>
                                    <th>Remark</th>
                                    <th>Hand Over to</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>

                                <tbody>
                                </tbody>

                                <tfoot>
                                <tr>
                                    <th>Repair ID</th>
                                    <th>Asset Id</th>
                                    <th>Send Date</th>
                                    <th>Return Date</th>
                                    <th>Remark</th>
                                    <th>Hand Over to</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </tfoot>
                            </table>

                        </div>
                    </div>
                   
                </div>
                
            </div>


        </section>
    </div>

    <jsp:include page="../../core/footer.jsp"></jsp:include>

    
    
    
    
    <div class="modal modal-success fade" id="modal-success_r">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Success</h4>
                </div>
                <div class="modal-body">
                    Successfully Received....
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    
    

    <script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${path}/dist/js/adminlte.min.js"></script>
    <script src="${path}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="${path}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="${path}/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${path}/bower_components/fastclick/lib/fastclick.js"></script>

    <script type="application/javascript">
    
       
        
    </script>
</body>
</html>