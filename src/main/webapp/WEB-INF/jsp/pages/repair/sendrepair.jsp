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
<link rel="stylesheet"
	href="${path}/bower_components/select2/dist/css/select2.min.css">
	 <link rel="stylesheet" href="${path}/dist/css/animate.css">

<title>${title}</title>
<style type="text/css">
	
	.error{
		display:none;
		color:red;
		margin-left: 10px;	
	}
	
	#cancel:hover{
		
		background-color: red;
	}

	#cancel a:hover{
		font-weight: bold;
		color: white;
	}

</style>
</head>

<body class="hold-transition skin-blue sidebar-mini" onload="setSelectedData('${branch}')">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper ">
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

			<section class="content container-fluid animated fadeInLeft">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">SEND REPAIR</h3>
				</div>

				<div class="box-body">
					<form id="form_send_repair" name="sendRepair" onsubmit = "return(validate());">
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
								name="reason" placeholder="Enter Reason" id="reasons"  title="Reason Is Required" onKeyup="manage(this) & req(this)" required/>
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
										<option value="${location.value}" >${location.name}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							<label>Sending Method</label> <input type="text" id="sendingMethord" 
							
								class="form-control" name="sendingMethod"
								placeholder="Enter Sending Method" title="Sending Methord Is Required" required oninvalid="this.setCustomValidity('Sending Methord Is Required')"/>
								<span class="error" >Sending Method is Requird</span>
						</div>

						<div class="form-group">
							<label>Courire Id</label> <input type="text" id="courireId" class="form-control" onclick="click"
								name="courierId" placeholder="Enter Courire Id" title="CourireId Is Required" required oninvalid="this.setCustomValidity('CourireID Is Required')" />
								<span class="error" >Courire id is Requird</span>
						</div>

						<div class="form-group">
							<label>Remark</label> <input type="text" class="form-control" id="remark"
								name="remark" placeholder="Enter Remark" required oninvalid="this.setCustomValidity('Remark Is Required')" />

						</div>

						<div class="box-footer">
							<button type="button" class="btn btn-default" id="cancel"><a href="${path}/home">Cancel</a></button>
							
							<div id="contact_submit">
							
							<button type="submit" id="button-addRepair"
								class="btn btn-info pull-right" disabled="true" ><i class="fa fa-paper-plane"></i>&nbsp;Send Repair</button>
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
		<script src="${path}/dist/js/sweetalert.min.js"></script>
		<script src="${path}/dist/js/jquery.validate.min.js"></script>
		<script src="${path}/dist/js/notify.min.js"></script>
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
			

        /* $("#button-addRepair").click(function () { */

        	/*$('#form_send_repair').validate();*/

            /* var res= document.forms["form_send_repair"]["reasons"];
            var sen = document.forms["form_send_repair"]["sendingMethord"];
            var cou = document.forms["form_send_repair"]["courireId"];
            var rem = document.forms["form_send_repair"]["remark"];
 */
        	 var a=$("#reasons");
        	
        	var b=$("#sendingMethord");
        	
        	var c=$("#courireId");
       
        	var d=$("#remark");

        	var main=$("#form_send_repair");

        	
        	/*
        	if (res.value != '' && sen.value != '' && cou.value !='' & rem.value !='') {

                res.focus();
                sen.focus();
                cou.focus();
                rem.focus();


            }else {
                alert('Please Fill Missing Filds');
            }
        });
     */
		
        function validate() {
        	
			$("#form_send_repair .form-control").each(function () {
        		
        		
        		
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
			
			
        	if(document.sendRepair.reason.value == ""){
        		/* window.alert("Reson Is Requierd"); */
        		$("#reasons").notify("Reson Is Requierd!", { position:"bottom right" });
        		document.sendRepair.reason.Focus();
        		document.sendRepair.reason.addClass('animated shake');
        		document.sendRepair.reason.css('border-color','red');
        		return false;
        	}
        	if(document.sendRepair.sendingMethod.value == ""){
        		/* window.alert("Sending Methord Is Requierd"); */
        		$("#sendingMethord").notify("Sending Methord Is Requierd!", { position:"bottom right" });
        		document.sendRepair.sendingMethod.addClass('animated shake');
        		document.sendRepair.sendingMethod.css('border-color','red');
        		document.sendRepair.sendingMethod.focus();
        		return false;
        	}
        	if(document.sendRepair.courierId.value == ""){
        		/* window.alert("CourierID is Requierd"); */
        		$("#courireId").notify("CourierID is Requierd!", { position:"bottom right" });
        		document.sendRepair.courierId.addClass('animated shake');
        		document.sendRepair.courierId.css('border-color','red');
        		document.sendRepair.courierId.focus();
        		return false;
        	}
        	if(document.sendRepair.remark.value == ""){
        		/* window.alert('Remark Is Requierd'); */
        		$("#remark").notify("Remark Is Requierd!", { position:"bottom right" });
        		document.sendRepair.remark.addClass('animated shake');
        		document.sendRepair.remark.css('border-color','red');
        		document.sendRepair.remark.focus();
        		return false;
        		
        	}else{
        		
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
                        $("#modal-success").modal("show");
                        $("#form_send_repair").trigger("reset");
                    },
                    error: function () {
                        alert('Opps Error Occerd Try Again');
                    }
                });
                
                alert('Repair Send Succsess');
        		
        		
        	}
        	
		}
        
		
		</script>
</body>
</html>