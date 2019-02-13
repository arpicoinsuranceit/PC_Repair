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
	href="${path}/bower_components/font-awesome/css/font-awesome.css">
<link rel="stylesheet"
	href="${path}/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
<link rel="stylesheet" href="${path}/dist/css/CustomStyles.css">
<link rel="stylesheet"
	href="${path}/bower_components/select2/dist/css/select2.min.css">
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
				<li><a href="${path}/all_repair"><i class="fa fa-dashboard"></i>
						REPAIR</a></li>
				<li class="active">REPAIR</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="col-md-6">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">REPAIR DETAILS</h3>
						<h3 class="box-title pull-right">JOB : ${repair.jobNo}</h3>
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td width="25%;">Asset ID</td>
									<td>${repair.assetDto.serialNo}</td>
								</tr>
								<tr>
									<td>Location</td>
									<td>${repair.locationDto.locationName}</td>
								</tr>
								<tr>
									<td>Reason</td>
									<td>${repair.reason}</td>
								</tr>
								<tr>
									<td>Priority</td>
									<td>${repair.priority}</td>
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
							style="width: 100%;" name="assetId" id="select_assignee">

							<c:if test="${not empty assignees}">
								<c:forEach items="${assignees}" var="assignee">
									<c:choose>
										<c:when
											test="${assignee.assigneeId eq repair.assigneeDto.assigneeId}">
											<option value="${assignee.assigneeId}" selected>${assignee.assigneeName}</option>
										</c:when>
										<c:otherwise>
											<option value="${assignee.assigneeId}">${assignee.assigneeName}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</c:if>
						</select>
					</div>

					<div class="box-footer">

						<button type="button" id="button-addAssignee"
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

							<input type="text" class="form-control" id="txt_search_serial">
							<div class="input-group-btn">
								<button type="button" class="btn btn-info"
									id="button_search_serial">Find By Id</button>
							</div>
						</div>

						<div style="height: 150px; margin-top: 10px; overflow: auto;">
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>Part Name</th>
										<th>Serial</th>
										<th style="width: 40px">Value</th>
									</tr>
								</thead>
								<tbody id="tbody_search_parts">


								</tbody>
							</table>
						</div>

						<div style="height: 150px; margin-top: 50px; overflow: auto;">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Part Name</th>
										<th>Serial</th>
										<th style="width: 40px">Value</th>
									</tr>
								</thead>
								<tbody id="tbody_add_parts">
									<c:if test="${not empty repair.partsDtos}">
										<c:forEach items="${repair.partsDtos}" var="part">
											<tr>
												<td style="display: none;">${part.partId}</td>
												<td>${part.partName}</td>
												<td>${part.serialId}</td>
												<td>${part.value}</td>
											</tr>
										</c:forEach>
									</c:if>

								</tbody>
							</table>
						</div>

						<div class="box-footer">
							<button type="button" id="button-parts-cart"
								class="btn btn-info pull-right">Add Parts</button>
						</div>

					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="box box-primary" style="height: 511px;">

					<div class="box-header with-border">
						<h3 class="box-title">REPAIR</h3>
					</div>

					<div class="box-body">
						<form id="form_repair_basics">
							<div class="form-group">
								<label>Status</label> <select class="form-control select2"
									style="width: 100%;" name="status">
									<c:if test="${not empty status}">
										<c:forEach items="${status}" var="state">
											<c:choose>
												<c:when
													test="${state.statusId eq repair.statusDto.statusId}">
													<option value="${state.statusId}" selected>${state.description}</option>
												</c:when>
												<c:otherwise>
													<option value="${state.statusId}">${state.description}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Error</label> <select class="form-control select2"
									multiple="multiple" style="width: 100%;" name="error">
									<c:if test="${not empty errors}">
										<c:forEach items="${errors}" var="error">
											<c:set var="isAvailable" value="0" scope="session" />
											<c:forEach items="${repair.errorDtos}" var="errorDto">
												<c:if test="${errorDto.id eq error.id}">
													<c:set var="isAvailable" value="1" scope="session" />
												</c:if>
											</c:forEach>
											<c:choose>
												<c:when test="${isAvailable eq 1}">
													<option value="${error.id}" selected>${error.name}</option>
												</c:when>
												<c:otherwise>
													<option value="${error.id}">${error.name}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Remark</label> <input type="text" class="form-control"
									name="remark" placeholder="Enter Remark"
									value="${repair.remark}">
							</div>

							<div class="form-group">
								<label>Priority</label> <select class="form-control select2"
									style="width: 100%;" name="priority">
									<c:if test="${not empty priorities}">
										<c:forEach items="${priorities}" var="priority">
											<c:choose>
												<c:when test="${priority eq repair.priority}">
													<option value="${priority}" selected>${priority}</option>
												</c:when>
												<c:otherwise>
													<option value="${priority}">${priority}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</c:if>
								</select>
							</div>



							<div class="box-footer">
								<button type="button" id="button-save_basic_repair"
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


		<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
		<script
			src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script
			src="${path}/bower_components/select2/dist/js/select2.full.min.js"></script>
		<script src="${path}/dist/js/adminlte.min.js"></script>
		<script type="application/javascript">
			
			
			
			
			
			
			
			
		$('.select2').select2();
		
		$("#button_search_serial").click(function () {
			var value = $("#txt_search_serial").val();
			
			$.ajax({
                type: 'GET',
                url: '${path}/searchPartSerial/'+value,
                success: function (resp) {
                    console.log(resp);
                    
                    var html ="";
                    
                    if(resp != null ){
                    	for(var i in resp) {
                    		var part = resp[i];
                    		var rowNum = parseInt(i) + parseInt(1);
                    		
                    		var row = "<tr class = \"part_search_tr\"> \
                                <td style=\"display: none;\">" + part.partId + "</td>\
                                <td>" + rowNum + "</td>\
                                <td>" + part.partName + "</td>\
                                <td>" + part.serialId + "</td>\
                                <td style = \"text-align: right;\">" + part.value + "</td>";
                    		
                    		html += row;
                    	}
                    	
                    	console.log(html);
                    }
                    
                    $("#tbody_search_parts").append(html);
                    
                },
                error: function () {
                    alert('Error');
                }
            });
		});
		
		
		$(document).on("dblclick", "#tbody_search_parts tr", function () {
			console.log($(this).closest("tr").find("td:nth-child(1)").text());
			
			var row = "<tr class = \"part_search_tr\"> \
                <td style=\"display: none;\">" + $(this).closest("tr").find("td:nth-child(1)").text() + "</td>\
                <td>" + $(this).closest("tr").find("td:nth-child(3)").text() + "</td>\
                <td>" + $(this).closest("tr").find("td:nth-child(4)").text() + "</td>\
                <td style = \"text-align: right;\">" + $(this).closest("tr").find("td:nth-child(5)").text() + "</td>";
			
			$("#tbody_add_parts").append(row);
			
			$(this).closest("tr").remove();
		});
		
		$("#button-parts-cart").click();
		
		$("#button-addAssignee").click(function () {
			
			var assignee = $("#select_assignee").val();
			
			var receipt = "${repair.repairId}";
			
			$.ajax({
                type: 'GET',
                url: "${path}/addAssigneeToRepair/"+receipt+"/"+ assignee,
                success: function (resp) {
                	$("#modal-success").modal("show");
                },
                error: function () {
                    alert('Error');
                }
			});
		});
		
		$("#button-save_basic_repair").click(function (){
			var data = "{";
            $("#form_repair_basics .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";
            
            var receipt = "${repair.repairId}";
            
            $.ajax({
                type: 'POST',
                url: '${path}/send_repair_basics/'+receipt,
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
		
		$("#button-parts-cart").click (function () {
			
			var receipt = "${repair.repairId}";
			
			var arr = new Array();
			$("#tbody_add_parts tr").each(function () {
				arr.push($(this).closest("tr").find("td:nth-child(1)").text());
				
			});
			
			var jsonString = JSON.stringify(arr);
			
			console.log(jsonString)
		  	$.ajax({
                type: 'POST',
                url: '${path}/send_repair_cart/'+receipt,
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