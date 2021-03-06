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
                ASSIGNEE
                <small>ADD ASSIGNEE</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/all_assignees"><i class="fa fa-dashboard"></i> ASSIGNEE</a></li>
                <li class="active">ADD ASSIGNEE</li>
            </ol>
        </section>

        <section class="content container-fluid">

            <div class="box box-primary">

                <div class="box-header with-border">
                    <h3 class="box-title">ADD ASSIGNEE</h3>
                </div>

                <div class="box-body">
                    <form id="form_add_assignee">
                        <div class="form-group">
                            <label>Assignee Id</label>
                            <input type="text" class="form-control" name="assigneeId" placeholder="Enter Assignee Id">
                        </div>

                        <div class="form-group">
                            <label>Assignee Name</label>
                            <input type="text" class="form-control" name="assigneeName"
                                   placeholder="Enter Assignee Name">
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default">Cancel</button>
                            <button type="button" id="button-addassignee" class="btn btn-info pull-right">Add Assignee
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

        $("#button-addassignee").click(function () {

            var data = "{";
            $("#form_add_assignee .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
            var jsonString = data.substring(0, data.length - 1);
            jsonString += "}";

            $.ajax({
                type: 'POST',
                url: '${path}/assignee',
                data: jsonString,
                contentType: "application/json",
                success: function (resp) {
                    $("#modal-success").modal("show");
                    $("#form_add_assignee").trigger("reset");
                },
                error: function () {
                    alert('Error');
                }
            });
        });
    </script>
</body>
</html>