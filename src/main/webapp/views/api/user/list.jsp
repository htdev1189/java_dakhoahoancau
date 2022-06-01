<%@ page import="htdev.dao.CategoryDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--goi class--%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List User By API</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value='/assets/backend/plugins/fontawesome-free/css/all.min.css'/>">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="<c:url value='/assets/backend/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/assets/backend/plugins/datatables-responsive/css/responsive.bootstrap4.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/assets/backend/plugins/datatables-buttons/css/buttons.bootstrap4.min.css'/>">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value='/assets/backend/css/adminlte.min.css'/>">
</head>
<body>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2 justify-content-between">
                <div class="col-sm-6">
                    <h1>List User By API</h1>
                </div>
                <div class="col-sm-1">
                    <a href="${pageContext.request.contextPath}/backend/user?action=add"
                       class="btn btn-primary btn-block">Add</a>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Image</th>
                                    <th>Name</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${all_users}" var="c">
                                    <tr>
                                        <td>${c.id}</td>
                                        <td>
                                            <img src="<c:url value='/upload/avatar/${c.image}'/>" class="img-fluid" style="width: 115px;height: 115px;">
                                        </td>
                                        <td>${c.name}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/backend/user?action=edit&id=${c.id}"><i
                                                    class="far fa-edit"></i></a>
                                            <a onclick="return confirm('are you sure?');"
                                               href="${pageContext.request.contextPath}/backend/user?action=delete&id=${c.id}"><i
                                                    class="far fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
<script src="<c:url value='/assets/backend/plugins/jquery/jquery.min.js' />"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value='/assets/backend/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<!-- DataTables  & Plugins -->
<script src="<c:url value='/assets/backend/plugins/datatables/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-responsive/js/dataTables.responsive.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-responsive/js/responsive.bootstrap4.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-buttons/js/dataTables.buttons.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-buttons/js/buttons.bootstrap4.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/jszip/jszip.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/pdfmake/pdfmake.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/pdfmake/vfs_fonts.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-buttons/js/buttons.html5.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-buttons/js/buttons.print.min.js'/>"></script>
<script src="<c:url value='/assets/backend/plugins/datatables-buttons/js/buttons.colVis.min.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/assets/backend/js/adminlte.min.js'/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value='/assets/backend/js/demo.js'/>"></script>
<!-- Page specific script -->
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
</body>
</html>