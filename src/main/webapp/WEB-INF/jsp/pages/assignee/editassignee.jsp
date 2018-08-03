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
	href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="/dist/css/skins/skin-blue.css">
<title>${title}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<jsp:include page="../../core/navigation.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				ASSIGNEE <small>EDIT ASSIGNEE</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/all_assignees"><i class="fa fa-dashboard"></i>
						ASSIGNEE</a></li>
				<li class="active">EDIT ASSIGNEE</li>
			</ol>
			</section>

			<section class="content container-fluid">

			<div class="box box-primary">

				<div class="box-header with-border">
					<h3 class="box-title">EDIT ASSIGNEE</h3>
				</div>

				<div class="box-body">
					<form id="form_edit_assignee">
						<div class="form-group">
							<label>Assignee Id</label> <input type="text"
								class="form-control" name="assigneeId" value="${id}"
								readonly="readonly" placeholder="Enter Assignee Id">
						</div>
						<div class="form-group">
							<label>Assignee Name</label> <input type="text"
								class="form-control" name="assigneeName" value="${name}"
								placeholder="Enter Assignee Name">
						</div>
						<div class="box-footer">
							<button type="button" class="btn btn-default">Cancel</button>
							<button type="button" id="button-editassignee"
								class="btn btn-info pull-right">Edit Assignee</button>
						</div>
					</form>
				</div>
			</div>


			</section>
		</div>

		<jsp:include page="../../core/footer.jsp"></jsp:include>

		<jsp:include page="../../core/SuccessEdit.jsp"></jsp:include>


		<script src="/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="/dist/js/adminlte.min.js"></script>

		<script type="application/javascript">
			

        $("#button-editassignee").click(function () {

            var data = "{";
            $("#form_edit_assignee .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'PUT',
                url: '/assignee',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_edit_assignee").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        });
    
		</script>
</body>
</html>