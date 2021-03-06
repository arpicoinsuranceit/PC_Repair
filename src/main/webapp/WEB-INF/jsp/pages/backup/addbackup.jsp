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
<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				BACKUP <small>ADD BACKUP</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${path}/all_errors"><i class="fa fa-dashboard"></i>BACKUP</a></li>
				<li class="active">ADD BACKUP</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">ADD BACKUP</h3>
				</div>

				<div class="box-body">
					<form id="form_add_backup">
						<div class="form-group">
							<label>Repair Id</label> 
							<select class="form-control"
								name="repairId" placeholder="Repair Id">
								<c:if test="${not empty repairs}">
									<c:forEach items="${repairs}" var="repair">
										<option value="${repair.repairId}">${repair.jobNo}</option>
									</c:forEach>
								</c:if>	
							</select>
						</div>

						<div class="form-group">
							<label>Asset Id</label> 
							<select class="form-control"
								name="assetId" placeholder="Asset Id">
								<c:if test="${not empty assets}">
									<c:forEach items="${assets}" var="asset">
										<option value="${asset.assetId}">${asset.assetId}</option>
									</c:forEach>
								</c:if>	
							</select>
						</div>

						<div class="form-group">
							<label>Remark</label> <input type="text" class="form-control"
								name="remark" placeholder="Enter Remark">
						</div>

						<div class="form-group">
							<label>Hand Over to</label> <input type="text"
								class="form-control" name="handOver"
								placeholder="Hand Over to">
						</div>

						<div class="form-group">
							<label>Send Date</label> <input type="date" class="form-control"
								name="sendDate">
						</div>

						<div class="form-group">
							<label>Return Date</label> <input type="date" id="date-return"
								class="form-control" name="returnDate">
						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default">Cancel</button>
							<button type="button" id="button-addBackup"
								class="btn btn-info pull-right">Add Backup</button>
						</div>
					</form>
				</div>
			</div>


			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


		<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
		<script
			src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="${path}/dist/js/adminlte.min.js"></script>

		<script type="application/javascript">
		
		var now = new Date(),
	    minDate = now.toISOString().substring(0,10);

		$('#date-return').prop('min', minDate);

        $("#button-addBackup").click(function () {

            var data = "{";
            $("#form_add_backup .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/backup',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_add_error").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        });
    
		</script>
</body>
</html>