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
	href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="/bower_components/select2/dist/css/select2.min.css">

<link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="/dist/css/skins/skin-blue.css">

<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				PARTS <small>EDIT PARTS</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/all_parts"><i class="fa fa-dashboard"></i>
						PARTS</a></li>
				<li class="active">EDIT PARTS</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">EDIT PARTS</h3>
				</div>

				<div class="box-body">
					<form id="form_edit_part">
						<div class="form-group">
							<div class="row">
								<div class="col-md-6 col-xs-6">
									<label>Supplier</label> <select class="form-control select2"
										style="width: 100%;" name="supplier">
										<c:if test="${not empty suppliers}">
											<c:forEach items="${suppliers}" var="supplier">
												<c:choose>
													<c:when test="${supplier.value eq sup_id}">
														<option value="${supplier.value}" selected>${supplier.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${supplier.value}">${supplier.name}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
									</select>
								</div>
								<div class="col-md-6 col-xs-6">
									<label>Serial No</label> <input type="text"
										class="form-control" value="${serialId}" name="serialId"
										placeholder="Enter Serial No">
								</div>
							</div>
						</div>



						<div class="form-group">
							<div class="row">
								<div class="col-md-6 col-xs-6">
									<label>Part Id</label> <input type="text" class="form-control"
										value="${part_id}" readonly="readonly" name="partId"
										placeholder="Enter Part Id">
								</div>
								<div class="col-md-6 col-xs-6">
									<label>Name</label> <input type="text" class="form-control"
										value="${name}" name="partName" placeholder="Enter Part Name">
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-6 col-xs-6">
									<label>Part Value</label> <input type="number"
										class="form-control" name="value" value="${value}"
										placeholder="Enter Value">
								</div>
								<div class="col-md-6 col-xs-6">
									<label>Purchase Date</label> <input type="date"
										class="form-control" name="purchaseDate"
										value="${purchasedate}" placeholder="Enter Purchase Date">
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-6 col-xs-6">
									<label>Remark</label> <input type="text" class="form-control"
										name="remark" value="${remark}" placeholder="Enter Remark">
								</div>
								<div class="col-md-3 col-xs-6">
									<label>Warranty Details</label> <input type="text"
										class="form-control" name="warrentyPeriod"
										value="${warrenty_per}" placeholder="Enter Warrenty Details">
								</div>
								<div class="col-md-3 col-xs-6">
									<label>Warranty Expired</label> <input type="date"
										class="form-control" name="warrentyExp"
										value="${warrenty_exp}" placeholder="Enter Warrenty Exp Date">
								</div>
							</div>
						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default">Cancel</button>
							<button type="button" id="button-addAsset"
								class="btn btn-info pull-right">Edit Part</button>
						</div>
					</form>
				</div>
			</div>


			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessEdit.jsp"></jsp:include>


		<script src="/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="/bower_components/select2/dist/js/select2.full.min.js"></script>
		<script src="/dist/js/adminlte.min.js"></script>


		<script type="application/javascript">
			
			
        $('.select2').select2();

        $("#button-addAsset").click(function () {

            var data = "{";
            $("#form_edit_part .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'PUT',
                url: '/parts',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_edit_part").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        });
    
		
		</script>
</body>
</html>