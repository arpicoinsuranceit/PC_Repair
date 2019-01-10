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
    <title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <jsp:include page="../../core/navigation.jsp"></jsp:include>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                ERROR
                <small>ADD ERRORS</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_errors"><i class="fa fa-dashboard"></i>ERROR</a></li>
                <li class="active">ADD ERRORS</li>
            </ol>
        </section>

        <section class="content container-fluid">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD ERROR</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_error">
                        <div class="form-group">
                            <label>Error Id</label>
                            <input type="text" class="form-control" name="id" id="errorID" placeholder="Enter Error Id" onkeyup="Procces(this)" required />
                        </div>
                        
                        <div class="form-group">
                            <label>Error Name</label>
                            <input type="text" class="form-control" name="name"
                                   placeholder="Enter Error Name" id="errorName" required oninvalid="this.setCustomValidity('Pleace Input Error Name')"  />
                        </div>

                        <div class="form-group">
                            <label>Error Description</label>
                            <input type="text" class="form-control" name="description"
                                   placeholder="Enter Error Description" id="errorDiscription" required oninvalid="this.setCustomValidity('Pleace Input Error Discription')" />
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default">Cancel</button>
                            <button type="submit" id="button-addError" disabled="true" class="btn btn-info pull-right"><i class="fa fa-plus"></i>&nbsp;Add Error
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

    
    function Procces(txt) {
    	
		 var dc = document.getElementById('button-addError');
		 
		 if(txt.value !=''){
			 
			 dc.disabled = false;
		 }else{
			 dc.disabled = true;
		 }
		 
	}
    
        $("#button-addError").click(function () {
        	
        	var xa =$("#errorID").val();
        	var xb =$("#errorName").val();
        	var xc =$("#errorDiscription").val();
        	
        	

            var data = "{";
            $("#form_add_error .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            if(xa !=='' && xb !=='' && xc !==''){
            	
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/error',
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
            
            }else{
            	alert('Please Fill Missing Filds');
            }
        });
    </script>
</body>
</html>