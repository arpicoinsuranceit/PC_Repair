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
<link rel="stylesheet"
	href="/bower_components/select2/dist/css/select2.min.css">
<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				REPAIR <small>SEND REPAIR</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/all_repair"><i class="fa fa-dashboard"></i>
						REPAIR</a></li>
				<li class="active">SEND REPAIR</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">SEND REPAIR</h3>
				</div>

				<div class="box-body">
					<form id="form_send_repair">
						<div class="form-group">
							<label>Asset Id</label> <select class="form-control select2"
								style="width: 100%;" name="assetId">
								<c:if test="${not empty assets}">
									<c:forEach items="${assets}" var="asset">
										<option value="${asset.assetId}">${asset.assetId}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>Reason</label> <input type="text" class="form-control"
								name="reason" placeholder="Enter Reason">
						</div>

						<div class="form-group">
							<label>From Location</label> <select class="form-control select2"
								style="width: 100%;" name="fromLocation">
								<c:if test="${not empty locations}">
									<c:forEach items="${locations}" var="location">
										<option value="${location.value}">${location.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>To Location</label> <select class="form-control select2"
								style="width: 100%;" name="toLocation">
								<c:if test="${not empty locations}">
									<c:forEach items="${locations}" var="location">
										<option value="${location.value}">${location.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>Sending Method</label> <input type="text"
								class="form-control" name="sendingMethod"
								placeholder="Enter Sending Method">
						</div>

						<div class="form-group">
							<label>Courire Id</label> <input type="text" class="form-control"
								name="courierId" placeholder="Enter Courire Id">
						</div>

						<div class="form-group">
							<label>Remark</label> <input type="text" class="form-control"
								name="remark" placeholder="Enter Remark">
						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default">Cancel</button>
							<button type="button" id="button-addRepair"
								class="btn btn-info pull-right">Send Repair</button>
						</div>
					</form>
				</div>
			</div>


			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="dist/js/adminlte.min.js"></script>
		<script src="/bower_components/select2/dist/js/select2.full.min.js"></script>
		<script type="application/javascript">
			
		$('.select2').select2();
			

        $("#button-addRepair").click(function () {

            var data = "{";
            $("#form_send_repair .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: 'send_repair',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_send_repair").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        });
    
		
		
		</script>
</body>
</html>