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
                                    <input type="text" class="form-control" name="serialId" placeholder="Enter Serial No">
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
                                    <input type="text" class="form-control" name="partName" placeholder="Enter Part Name">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Part Value</label>
                                    <input type="number" class="form-control" name="value" placeholder="Enter Value">
                                </div>
                                <div class="col-md-6 col-xs-6">
                                    <label>Purchase Date</label>
                                    <input type="date" class="form-control" name="purchaseDate" placeholder="Enter Purchase Date">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 col-xs-6">
                                    <label>Remark</label>
                                    <input type="text" class="form-control" name="remark" placeholder="Enter Remark">
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Details</label>
                                    <input type="text" class="form-control" name="warrentyPeriod" placeholder="Enter Warrenty Details">
                                </div>
                                <div class="col-md-3 col-xs-6">
                                    <label>Warranty Expired</label>
                                    <input type="date" class="form-control" name="warrentyExp" placeholder="Enter Warrenty Exp Date">
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default">Cancel</button>
                            <button type="button" id="button-addAsset" class="btn btn-info pull-right">Add Part
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
        $('.select2').select2();

        $("#button-addAsset").click(function () {

            var data = "{";
            $("#form_add_part .form-control").each(function () {
                data += "\"" + $(this).attr("name") + "\" : \"" + $(this).val() + "\",";
            });
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
        });
    </script>
</body>
</html>