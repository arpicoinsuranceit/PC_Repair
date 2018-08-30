<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="${path}/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${path}/bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${path}/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
<link rel="stylesheet"
	href="${path}/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				DASHBOARD <small>DASHBOARD</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
				<li class="active">Dashboard</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="row">
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-aqua">
						<div class="inner">
							<h3>${values.incomming}</h3>

							<p>Coming Repairs</p>
						</div>
						<div class="icon" style="margin-top: 20px;">
							<i class="fa fa-download"></i>
						</div>
						<a href="#" class="small-box-footer" style="height: 25px;"></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-green">
						<div class="inner">
							<h3>${values.complete}</h3>

							<p>Completed Repairs</p>
						</div>
						<div class="icon" style="margin-top: 15px;">
							<i class="fa fa-upload"></i>
						</div>
						<a href="#" class="small-box-footer" style="height: 25px;"></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-yellow">
						<div class="inner">
							<h3>${values.ongoing}</h3>

							<p>Ongoing Repairs</p>
						</div>
						<div class="icon" style="margin-top: 20px;">
							<i class="fa fa-spinner"></i>
						</div>
						<a href="#" class="small-box-footer" style="height: 25px;"></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-red">
						<div class="inner">
							<h3>${values.hold}</h3>

							<p>Hold Repairs</p>
						</div>
						<div class="icon" style="margin-top: 20px;">
							<i class="fa fa-pause"></i>
						</div>
						<a href="#" class="small-box-footer" style="height: 25px;"></a>
					</div>
				</div>
				<!-- ./col -->
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Repairs To-Do ...</h3>
						</div>

						<div class="box-body">
							<div >
								<table id="table_repair" class="table table-bordered">
									<thead>
										<tr>
											<th>Repair Id</th>
											<th>Asset</th>
											<th>Send From</th>
											<th>Reason</th>
											<th>Priority</th>
											<th>Status</th>
											<th></th>
										</tr>
									</thead>

									<tbody>
									</tbody>

									<tfoot>
										<tr>
											<th>Repair Id</th>
											<th>Asset</th>
											<th>Send From</th>
											<th>Reason</th>
											<th>Priority</th>
											<th>Status</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>


					</div>
				</div>

			</div>

			</section>
		</div>

		<jsp:include page="core/footer.jsp"></jsp:include>


		<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
		<script
			src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="${path}/dist/js/adminlte.min.js"></script>
		<script
			src="${path}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
		<script
			src="${path}/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

		<script type="text/javascript">
			var table = $('#table_repair').DataTable({
				"pageLength" : 10,
				"ajax" : "${path}/dashboard_repair_dt"

			});

			function showRepair(id) {
				window.location.replace("${path}/repair/" + id);
			}
		</script>
</body>
</html>