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
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/skin-blue.css">
<link rel="stylesheet" href="dist/css/CustomStyles.css">
<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				REPAIR <small>REPAIR</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/all_repair"><i class="fa fa-dashboard"></i>
						REPAIR</a></li>
				<li class="active">REPAIR</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="col-md-6">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">REPAIR DETAILS</h3>
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td width="25%;">Asset ID</td>
									<td>name</td>
								</tr>
								<tr>
									<td>Location</td>
									<td>name</td>
								</tr>
								<tr>
									<td>Reason</td>
									<td>name</td>
								</tr>
								<tr>
									<td>Priority</td>
									<td>name</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="box box-primary" style="height: 211px;">
					<div class="box-header with-border">
						<h3 class="box-title">REPAIR ASSIGN</h3>
					</div>
					<div class="box-body">
						<label>Assignee</label> <select class="form-control select2"
							style="width: 100%;" name="assetId">
							<c:if test="${not empty assets}">
								<c:forEach items="${assets}" var="asset">
									<option value="${asset.assetId}">${asset.assetId}</option>
								</c:forEach>
							</c:if>
						</select>
					</div>

					<div class="box-footer">

						<button type="button" id="button-addRepair"
							class="btn btn-info pull-right">Add Assignee</button>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Parts</h3>
					</div>
					<div class="box-body">


						<div class="input-group">

							<input type="text" class="form-control">
							<div class="input-group-btn">
								<button type="button" class="btn btn-info">Find By Id</button>
							</div>
						</div>

						<p class="text-muted well well-sm no-shadow"
							style="margin-top: 10px;">
							Name &nbsp;&nbsp;&nbsp;: <br> Serial &nbsp;&nbsp;&nbsp;: <br>
							Value &nbsp;&nbsp;&nbsp;:
						</p>
						<button type="button" class="btn btn-default pull-right">Add</button>

						<div style="height : 200px; margin-top : 70px; ; overflow: auto;">
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>Part Name</th>
										<th>Serial</th>
										<th style="width: 40px">Value</th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td>1.</td>
										<td>Some Part</td>
										<td>154402</td>
										<td><span class="badge bg-red">1500</span></td>
									</tr>
									<tr>
										<td>2.</td>
										<td>Some Part</td>
										<td>154402</td>
										<td><span class="badge bg-red">1500</span></td>
									</tr>
									<tr>
										<td>3.</td>
										<td>Some Part</td>
										<td>154402</td>
										<td><span class="badge bg-red">1500</span></td>
									</tr>
									<tr>
										<td>4.</td>
										<td>Some Part</td>
										<td>154402</td>
										<td><span class="badge bg-red">1500</span></td>
									</tr>
									<tr>
										<td>5.</td>
										<td>Some Part</td>
										<td>154402</td>
										<td><span class="badge bg-red">1500</span></td>
									</tr>

								</tbody>
							</table>
						</div>
						
						<div class="box-footer">
								<button type="button" id="button-addRepair"
									class="btn btn-info pull-right">Add Parts</button>
							</div>

					</div>
				</div>
			</div>

			<div class="col-md-6" >
				<div class="box box-primary" style="height: 511px;">

					<div class="box-header with-border">
						<h3 class="box-title">REPAIR</h3>
					</div>

					<div class="box-body">
						<form id="form_send_repair">
							<div class="form-group">
								<label>Status</label> <select class="form-control select2"
									style="width: 100%;" name="assetId">
									<c:if test="${not empty assets}">
										<c:forEach items="${assets}" var="asset">
											<option value="${asset.assetId}">${asset.assetId}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Error</label> <select class="form-control select2"
									style="width: 100%;" name="assetId">
									<c:if test="${not empty assets}">
										<c:forEach items="${assets}" var="asset">
											<option value="${asset.assetId}">${asset.assetId}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Remark</label> <input type="text"
									class="form-control" name="sendingMethod"
									placeholder="Enter Remark">
							</div>

							

							<div class="box-footer">
								<button type="button" id="button-addRepair"
									class="btn btn-info pull-right">Save Repair</button>
							</div>
						</form>
					</div>
				</div>
			</div>





			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="dist/js/adminlte.min.js"></script>

		<script type="application/javascript">
			
			
			
			
			

        
		
		
		
		
		
		
		
		</script>
</body>
</html>