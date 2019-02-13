<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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


<title>${title}</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	
	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>
		
		<div class="content-wrapper">
			<section class="content-header">
			
			<h1>Backup <small>Edit Backup</small></h1>
			
			<ol class="breadcrumb">
				<li> <a href="">
					<i class="fa fa-dashboard"></i>
					Backup</a></li>
					<li class="active">Edit Backup</li>
			</ol>
			</section>
			
			<section class="content container_fluid">
				<div class="box box-primary">
					
					<div class="box-header with-border">
						<h3 class="box-title">Edit Backup</h3>
					</div>
					
					<div class="box-body">
						
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
							<label>Remark</label> <input type="text" class="form-control" id="remark" value="${remark}"
								name="remark" placeholder="Enter Remark" required />
						</div>

						<div class="form-group">
							<label>Hand Over to</label> <input type="text" id="handOverTo"
								class="form-control" name="handOver" value="${handOver}"
								placeholder="Hand Over to" required />
								
						</div>

						<div class="form-group">
							<label>Send Date</label> <input type="date" value="${sendDate}" class="form-control" id="sendDate"
								name="sendDate" required />
						</div>

						<div class="form-group">
							<label>Return Date</label> <input type="date" id="date-return"
								class="form-control" value="${returnDate}" name="returnDate" required />
						</div>

						<div class="box-footer">
							<button type="button" id="cancel" class="btn btn-default"><a href="${path}/home">Cancel</a></button>
							<button type="button" id="button-editBackup"
								class="btn btn-info pull-right"><i class="fa fa-plus"></i>&nbsp;Edit Backup</button>
						</div>
					</form>
						
					</div>
				</div>
			</section>
		</div>
	</div>
		<jsp:include page="../../core/footer.jsp"></jsp:include>

<div class="modal modal-warning fade" id="modal-danger">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Warning</h4>
                </div>
                <div class="modal-body">
                    Are You Sure ?
                </div>
                <input id="txt-delete-id" type="text" style="display: none;"/>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline" id="button-delete">Yes</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal modal-success fade" id="modal-success">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Success</h4>
                </div>
                <div class="modal-body">
                    Successfully Deleted....
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    
		<jsp:include page="../../core/SuccessEdit.jsp"></jsp:include>

		<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="${path}/dist/js/adminlte.min.js"></script>

<script type="text/javascript">
	
	$('.select2').select2();

	$("#button-editBackup").click(function() {
		var data = "{";
		
		$("#form_edit_backup .form-control").each(function() {
			data += "\"" +$(this).attr("name") + "\" : \"" + $(this).val() + "\",";
		});
		
		var jsonString = data.substring(0,data.length -1);
		jsonString += "}";
		
		$.ajax({
			type:"PUT",
			url:'${path}/backup',
			data:jsonString,
			contentType:"application/json",
			success: function(resp) {
				$("#modal-success").modal("show");
				$("#form_edit_backup").trigger("reset");
			},
			error: function() {
				alert('Error');
			}
		});
		
	});
</script>
</body>
</html>
