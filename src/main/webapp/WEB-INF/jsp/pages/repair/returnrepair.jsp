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
	href="${path}/bower_components/select2/dist/css/select2.min.css">

<style type="text/css">
	
	.error{
	
		display:none;
		color:red;
		
	}

</style>

<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				REPAIR <small>RETURN REPAIR</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${path}/all_repair"><i class="fa fa-dashboard"></i>
						REPAIR</a></li>
				<li class="active">RETURN REPAIR</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">RETURN REPAIR</h3>
				</div>

				<div class="box-body">
					<form id="form_return_repair">
						<div class="form-group">
							<label>Asset Id</label> <select class="form-control select2"
								style="width: 100%;" name="repairId">
								<c:if test="${not empty assets}">
									<c:forEach items="${assets}" var="asset">
										<option value="${asset.repairId}">${asset.assetId}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>Hand Over To</label> <input type="text" id="handOver"
								class="form-control" name="handOverTo" onkeyup="Prosees(this) & req(this)"
								placeholder="Enter Hand Over To" required  />
								<span class="error" id="spnHandOver">Hand Over Is Requird</span>
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
							<label>Sending Method</label> <input type="text" id="sendingMethord"
								class="form-control" name="sendingMethod"
								placeholder="Enter Sending Method" required oninvalid="this.setCustomValidity('Pleace Input Sending Methord')" />
								<span class="error" id="spnSendingMethord">Sending Methord Is Required</span>
						</div>

						<div class="form-group">
							<label>Courire Id</label> <input type="text" class="form-control"
								id="courireID"  name="courierId" placeholder="Enter Courire Id" required oninvalid="this.setCustomValidity('Pleace Input Courire Id')" />
								<span class="error" id="spnCourireID">Courire ID Is Required</span>
						</div>

						<div class="form-group">
							<label>Remark</label> <input type="text" class="form-control"
								name="remark" id="remark" placeholder="Enter Remark" required oninvalid="this.setCustomValidity('Pleace Input Remark')" />
								<span class="error" id="spnRemark">Remark Is Required</span>
						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default">Cancel</button>
							
							<button type="submit button" id="button-addRepair" disabled="true"
								class="btn btn-info pull-right">Return Repair</button>
						</div>
					</form>
				</div>
			</div>


			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessAdd.jsp"></jsp:include>


		<script src="${path}/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="${path}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="${path}/dist/js/adminlte.min.js"></script>
		<script src="${path}/bower_components/select2/dist/js/select2.full.min.js"></script>

		<script type="application/javascript">
			
		function req(color) {
			
			if ($('#handOver').val() == '') {
			    $('#handOver').css('border-color', 'red');
			}
			else {
			    $('#handOver').css('border-color', '');
			}
			
		}
		
		
		function Prosees(txt) {
			
			var xd = document.getElementById('button-addRepair');
			
			if(txt.value !=''){
				
				xd.disabled = false;
			}else{
				xd.disabled = true;
			}
			
		}
		
		
			
		$('.select2').select2();

        $("#button-addRepair").click(function () {

        	var a=$("#handOver").val();
        	var b=$("#sendingMethord").val();
        	var c=$("#courireID").val();
        	var d=$("#remark").val();
        	
        	var ab = document.getElementById('spnHandOver');
        	var ac = document.getElementById('spnSendingMethord');
        	var ad = document.getElementById('spnCourireID');
        	var ae = document.getElementById('spnRemark');
        		
            var data = "{";
            $("#form_return_repair .form-control").each(function () {
            	
            	
               
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            /* if(a !== ""){
            	 ab.visible = true;
            	 
            }else{
            	ab.visible = false;
            	
            }if(b !== ""){
            	ac.visible = true;
            	
            }else{
            	ac.visible = false;
            	
            }if(c !==""){
            	ad.visible = true;
            	
            }else{
            	ad.visible = false;
            	
            }if(d !== ""){
            	ae.visible = true;
            	
            }else{
            	ae.visible = false;
            } */
           
            if(a !== "" && b !=="" && c !=="" && d !==""){
            	
            	
            	
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/return_repair',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_return_repair").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
            }else{
            	alert('Please Fill Missing Filds');
            }
        });
    
		
		
		</script>
</body>
</html>