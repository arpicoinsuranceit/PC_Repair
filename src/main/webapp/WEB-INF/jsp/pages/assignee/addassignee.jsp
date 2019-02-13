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
    <link rel="stylesheet" href="${path}/bower_components/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${path}/dist/css/skins/skin-blue.css">
    <link rel="stylesheet" href="${path}/dist/css/animate.css">

    <style type="text/css">
    	
    	.error{
    		color:red;
    		display: none;
    	}
    	
    	#cancel:hover{
		
		background-color: red;

	}

        #cancel a:hover{
            font-weight: bold;
            color: white;
        }

   	 </style>
    <title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <jsp:include page="../../core/navigation.jsp"></jsp:include>

    <div class="content-wrapper ">
        <section class="content-header">
            <h1>
                ASSIGNEE
                <small>ADD ASSIGNEE</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_assignees"><i class="fa fa-dashboard"></i> ASSIGNEE</a></li>
                <li class="active">ADD ASSIGNEE</li>
            </ol>
        </section>

        <section class="content container-fluid animated fadeInLeft">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD ASSIGNEE</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_assignee">
                        <div class="form-group">
                            <label>Assignee Id</label>
                            <input type="text" class="form-control" name="assigneeId" id="AssigneeId" placeholder="Enter Assignee Id" required oninvalid="this.setCustomValidity('Pleace Input Assignee ID')" onkeyup="Prosees(this) & req(this)" />
                           	<span class="error" id="spnAssigneeId">Assignee Is Required</span>
                        </div>

                        <div class="form-group">
                            <label>Assignee Name</label>
                            <input type="text" class="form-control" name="assigneeName"
                                   placeholder="Enter Assignee Name" id="AssigneeName" required oninvalid="this.setCustomValidity('')" />
                                   <span class="error" id="spnAssigneeName">Assignee Name Is Required</span>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default" id="cancel"><a href="${path}/home">Cancel</a></button>
                            <button type="button" id="button-addassignee" disabled="true" class="btn btn-info pull-right"  ><i class="fa fa-plus"></i>&nbsp;Add Assignee

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
	<script src="${path}/dist/js/notify.min.js"></script>
        <script src="${path}/dist/js/sweetalert.min.js"></script>

    <script type="application/javascript">

	function req(color) {
		
		if ($('#AssigneeId').val() == '') {
		    $('#AssigneeId').css('border-color', 'red');
		}
		else {
		    $('#AssigneeId').css('border-color', '');
		}
		
	}
    
  
    function Prosees(txt) {
		
		var xd = document.getElementById('button-addassignee');
		
		if(txt.value !=''){
			
			xd.disabled = false;
		}else{
			xd.disabled = true;
		}
		
	}
    
    
    
        $("#button-addassignee").click(function () {


        	var name = document.forms["form_add_assignee"]["AssigneeName"];
        	var a = $('#AssigneeName');

            var data = "{";
            $("#form_add_assignee .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            
            if(name.value == ""){
            	a.focus();
            	a.css('border-color','red');
            	a.addClass('animated shake');
            	 $("#AssigneeName").notify("Assignee Name Is Required!", { position:"bottom center" });
            	/* alert('OOPS! Assignee Name Is Required!'); */
                /* swal("OOPS!", " Assignee Name Is Required!", "error"); */

            }else{
                var jsonString = data.substring(0, data.length - 1);
                jsonString += "}";

                $.ajax({
                    type: 'POST',
                    url: '${path}/assignee',
                    data: jsonString,
                    contentType: "application/json",
                    success: function (resp) {
                    	
                        $("#modal-success").modal("show");
                        /* swal("Assignee!", "Succsess Fully Added!", "success"); */
                        $("#form_add_assignee").trigger("reset");
                    },
                    error: function () {
                        /* swal("OOPS!", " Error Occurd Try Again!", "error"); */
                        alert('OOPS Error Occurd Try Again');
                    }
                });

                a.removeClass('animated shake');
                a.css('border-color','');
            }
        });
    </script>
</body>
</html>