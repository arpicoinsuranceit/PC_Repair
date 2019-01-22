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
                SUPPLIER
                <small>ADD SUPPLIER</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_supplier"><i class="fa fa-dashboard"></i> SUPPLIER</a></li>
                <li class="active">ADD SUPPLIER</li>
            </ol>
        </section>

        <section class="content container-fluid">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD SUPPLIER</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_supplier">
                        <div class="form-group">
                            <label>Supplier Id</label>
                            <input type="text" class="form-control" id="supplierID" name="supplierId" placeholder="Enter Supplier Id" required onkeyup="Proccess(this) & req(this)" />
                        </div>

                        <div class="form-group">
                            <label>Supplier Name</label>
                            <input type="text" class="form-control" name="supplierName"
                                   placeholder="Enter Supplier Name" id="supplierName" required />
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default" id="cancel">Cancel</button>
                            <button type="submit button" id="button-addsupplier" disabled="true" class="btn btn-info pull-right"><i class="fa fa-plus"></i>&nbsp;Add Supplier
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
    <script src="${path}/dist/js/adminlte.min.js"></script>

    <script type="application/javascript">
    
	function req(color) {
		
		if ($('#supplierID').val() == '') {
		    $('#supplierID').css('border-color', 'red');
		}
		else {
		    $('#supplierID').css('border-color', '');
		}
		
	}
    
    function Proccess(txt) {
		
    	var cx = document.getElementById('button-addsupplier');
    	
    	if(txt.value !=''){
    		 cx.disabled = false;
    	}else{
    		cx.disabled = true;
    	}
	}
    
    
    

        $("#button-addsupplier").click(function () {
        	
        	var a=$("#supplierID").val();
        	var b=$("#supplierName").val();
        	
        		
            var data = "{";
            $("#form_add_supplier .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            
            if(a !=="" & b !==""){
            	
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/supplier',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_add_supplier").trigger("reset");
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