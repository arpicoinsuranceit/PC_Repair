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
                PARTS
                <small>ADD PARTS</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_parts"><i class="fa fa-dashboard"></i> PARTS</a></li>
                <li class="active">ADD PARTS</li>
            </ol>
        </section>

        <section class="content container-fluid">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD PARTS</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_part">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Supplier</label>
                                    <select class="form-control select2" style="width: 100%;" name="supplier">
                                        <c:if test="${not empty suppliers}">
                                            <c:forEach items="${suppliers}" var="supplier">
                                                <option value="${supplier.value}">${supplier.name}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Serial No</label>
                                    <input type="text" class="form-control" id="serialNo" name="serialId" placeholder="Enter Serial No" onkeyup="process(this) & req(this)" required />
                                </div>
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="row">
                                <!-- <div class="col-md-6 col-xs-6">
                                    <label>Part Id</label>
                                    <input type="text" class="form-control" name="partId" placeholder="Enter Part Id">
                                </div> -->
                                <div class="col-md-12 col-xs-12">
                                    <label>Name</label>
                                    <input type="text" class="form-control" id="name" name="partName" placeholder="Enter Part Name" required />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Part Value</label>
                                    <input type="number" class="form-control" id="partValue" name="value" placeholder="Enter Value" required />
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Purchase Date</label>
                                    <input type="date" class="form-control" id="purchaseDate" name="purchaseDate" placeholder="Enter Purchase Date" required />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Remark</label>
                                    <input type="text" class="form-control" id="remark" name="remark" placeholder="Enter Remark" required />
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Details</label>
                                    <input type="text" class="form-control" id="warrantyDe" name="warrentyPeriod" placeholder="Enter Warrenty Details" required />
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Expired</label>
                                    <input type="date" class="form-control" id="warrantyEx" name="warrentyExp" placeholder="Enter Warrenty Exp Date" required />
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" id="cancel" class="btn btn-default">Cancel</button>
                            <button type="submit button" id="button-addAsset" class="btn btn-info pull-right"  disabled="true"><i class="fa fa-plus"></i>&nbsp;Add Part
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
    
    function process(txt) {
		
    	var xd= document.getElementById('button-addAsset');
    	
    	if(txt.value !=''){
    		xd.disabled = false;
    	}else{
    		xd.disabled = true;
    	}
	}
    
    
    
        $('.select2').select2();

        $("#button-addAsset").click(function () {

        	
        	var a=$('#name').val();
        	var b=$('#partValue').val();
        	var c=$('#remark').val();
        	var d=$('#warrantyDe').val();
        	
            var data = "{";
            $("#form_add_part .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            if(a !=="" && b !=="" && c !=="" && d !==""){
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/parts',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_add_part").trigger("reset");
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