<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${path}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${path}/bower_components/select2/dist/css/select2.min.css">

    <link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">

	<style type="text/css">
		
		#cancel:hover{
		
		background-color: red;
		color: white;
		font: bold;
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
                ASSETS
                <small>ADD ASSET</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_assets"><i class="fa fa-dashboard"></i> ASSETS</a></li>
                <li class="active">ADD ASSET</li>
            </ol>
        </section>

        <section class="content container-fluid">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD ASSET</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_asset">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Supplier</label>
                                    <select class="form-control select2" style="width: 100%;" name="supplier" />
                                        <c:if test="${not empty suppliers}">
                                            <c:forEach items="${suppliers}" var="supplier">
                                                <option value="${supplier.value}">${supplier.name}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Location</label>
                                    <select class="form-control select2" style="width: 100%;" name="location" />
                                        <c:if test="${not empty locations}">
                                            <c:forEach items="${locations}" var="location">
                                                <option value="${location.value}">${location.name}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Asset Id</label>
                                    <input type="text" class="form-control" name="assetId" id="assestId" placeholder="Enter Asset Id" required />
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Serial No</label>
                                    <input type="text" class="form-control" name="serialNo" id="serialNo" placeholder="Enter Serial No" onkeyup="Procces(this) & req(this)" required />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>IP Address</label>
                                    <input type="text" class="form-control" name="ipAddress" id="ipAddress" placeholder="Enter IP Address" />
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Operating System</label>
                                    <select class="form-control select2" style="width: 100%;" name="os">
                                        <c:if test="${not empty osList}">
                                            <c:forEach items="${osList}" var="os">
                                                <option value="${os.value}">${os.name}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Asset Description</label>
                            <textarea class="form-control" rows="3" id="ideiscription" name="description" placeholder="Enter ..." ></textarea>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Asset Value</label>
                                    <input type="number" class="form-control" id="asset-value" name="value" placeholder="Enter Value"  />
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Purchase Date</label>
                                    <input type="date" class="form-control" id="purchaseDate" name="purchaseDate" placeholder="Enter Purchase Date" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Remark</label>
                                    <input type="text" class="form-control" id="remark" name="remark" placeholder="Enter Remark" />
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Period</label>
                                    <input type="text" class="form-control" id="warranty" name="warranty" placeholder="Enter Warrenty" />
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Expired</label>
                                    <input type="date" class="form-control" id="warrantyExp" name="warrantyExp" placeholder="Enter Warrenty"  />
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" id="cancel" class="btn btn-default" >Cancel</button>
                            <button type="submit button" disabled="true" id="button-addAsset" class="btn btn-info pull-right" ><i class="fa fa-plus"></i>&nbsp;Add Asset
                            </button>
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
    <script src="${path}/bower_components/select2/dist/js/select2.full.min.js"></script>
    <script src="${path}/dist/js/adminlte.min.js"></script>


    <script type="application/javascript">
    
    function req(color) {
		
		if ($('#serialNo').val() == '') {
		    $('#serialNo').css('border-color', 'red');
		}
		else {
		    $('#serialNo').css('border-color', '');
		}
		
	}
    
    function Procces(txt) {
    	
		 var dc = document.getElementById('button-addAsset');
		 
		 if(txt.value !=''){
			 
			 dc.disabled = false;
		 }else{
			 dc.disabled = true;
		 }
		 
	}
    
        $('.select2').select2();
        
        
       

        $("#button-addAsset").click(function () {

        	var a=$("#serialNo").val();
            var b=$("#assestId").val();
        	
        		 
            var data = "{";
            $("#form_add_asset .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            
            if(a !=='' && b !==''){ 
            	
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/asset',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_add_asset").trigger("reset");
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