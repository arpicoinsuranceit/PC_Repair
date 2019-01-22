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
<title>${title}</title>
<style type="text/css">
	
	.error{
		display:none;
		color:red;
		margin-left: 10px;	
	}
	
	#cancel:hover{
		
		background-color: red;
		color: white;
		font: bold;
	}
	
	/* #sendingMethord{
		
		border-color: red;
	} */
</style>
</head>

<body class="hold-transition skin-blue sidebar-mini" onload="setSelectedData('${branch}')">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				REPAIR <small>SEND REPAIR</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${path}/all_repair"><i class="fa fa-dashboard"></i>
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
								name="reason" placeholder="Enter Reason" id="reasons" onKeyup="manage(this) & req(this)" required/>
						</div>

						<div class="form-group">
							<label>From Location</label> <select class="form-control select2" id="fromLocation" onChange="Location"
								style="width: 100%;" name="fromLocation" required />
								<c:if test="${not empty locations}">
									<c:forEach items="${locations}" var="location">
										<option value="${location.value}" >${location.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>To Location</label> <select class="form-control select2"
								style="width: 100%;" name="toLocation" id="toLocation" onchange="toLocation" required>
								<c:if test="${not empty locations}" >
									<c:forEach items="${locations}" var="location">
										<option value="${location.value}" id="toLocation">${location.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>Sending Method</label> <input type="text" id="sendingMethord" 
							
								class="form-control" name="sendingMethod"
								placeholder="Enter Sending Method" required oninvalid="this.setCustomValidity('Pleace Input Sending Methord')"/>
								<span class="error" >Sending Method is Requird</span>
						</div>

						<div class="form-group">
							<label>Courire Id</label> <input type="text" id="courireId" class="form-control" onclick="click"
								name="courierId" placeholder="Enter Courire Id" required oninvalid="this.setCustomValidity('Pleace Input Courire ID')" />
								<span class="error" >Courire id is Requird</span>
						</div>

						<div class="form-group">
							<label>Remark</label> <input type="text" class="form-control" id="remark" 
								name="remark" placeholder="Enter Remark" required oninvalid="this.setCustomValidity('Pleace Input Remark')"/>
								<span class="error">Remark is Requird</span>
						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default" id="cancel">Cancel</button>
							
							<div id="contact_submit">
							
							<button type="submit" id="button-addRepair"
								class="btn btn-info pull-right" disabled="true" onclick="ok()"><i class="fa fa-paper-plane"></i>&nbsp;Send Repair</button>
								</div>
							
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
			
			if ($('#reasons').val() == '') {
			    $('#reasons').css('border-color', 'red');
			}
			else {
			    $('#reasons').css('border-color', '');
			}
			
		}
		
		function  setSelectedData(data) {
			
			console.log('dsgshfhd');
			 if(data == 'HO'){
					
					var dt = document.getElementById('toLocation');
				
					if(dt.value == 'Head Office'){
						dt.attr('selected', 'selected');
					}else{
						dt.removeAttr('selected');
					}

				
				}else{
					

			}	
			
		}
		
		
		/* $("#contact_submit button").click(function(event) {
			var form_data=$("#contact").serializeArray();
			var error_free=true;
			
			for(var input in form_data){
				var elemen=$("#contact"+form_data[input]['sendingMethod']);
				var valid=element.hasClass("valid");
				var error_element=$("span",element.parent());
				if(!valid){error_element.removeClass("error").addClass("error_show");error_free=false;}
				
				else{error_element.removeClass("error").addClasss("error_show");error_free=false;}
			}
			if(!error_free){
				event.preventDefault();
			}else{
				alert('No errors: Form will be submitted');
			}
		}); */
		
		
		function manage(txt) {
			var bt = document.getElementById('button-addRepair');
			if(txt.value !=''){
				bt.disabled  = false;
			}else{
				bt.disabled = true;
			}
		}
		
		
		/* function ok() {
			var a = document.getElementById("sendingMethord").required;
			var b = document.getElementById("courireId").required;
			var c = document.getElementById("remark").required;
		} */
		
		
		/* 
		$("#fromLocation").click(function () {
			var x=document.getElementById("remark")
			x.disabled=false
		}); */
		
		
		
		
			/* var loacatio=document.getElementById('toLocation').value
			alert(location);
			if(loacatio!=null){
				console.log(location);
			} */
		
		
		
		$('.select2').select2();
			

        $("#button-addRepair").click(function () {

        	var a=$("#reasons").val();
        	
        	var b=$("#sendingMethord").val();
        	
        	var c=$("#courireId").val();
       
        	var d=$("#remark").val();
        	
        	$("#form_send_repair .form-control").each(function () {
        		
        		
        		
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
        	
        	if(a !== "" && b !=="" && c !=="" && d !==""){

            var data = "{";
            $("#form_send_repair .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/send_repair',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                	alert('Send Repair Added Succsess');
                    $("#modal-success").modal("show");
                    $("#form_send_repair").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        	}else{
        		alert("Pleace Fill Missing Filds");
        	}
        });
    
		
		
		</script>
</body>
</html>