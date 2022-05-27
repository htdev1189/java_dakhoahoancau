<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit user</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value='/assets/backend/plugins/fontawesome-free/css/all.min.css'/>">
    <!-- Select2 -->
    <link rel="stylesheet" href="<c:url value='/assets/backend/plugins/select2/css/select2.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/assets/backend/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css'/>">
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
    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">Edit User</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form method="post" enctype="multipart/form-data">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" class="form-control" placeholder="enter name" name="user"
                                   value="${current_user.user}">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="text" class="form-control" placeholder="enter name" name="pass"
                                   value="${current_user.pass}">
                        </div>
                        <div class="form-group">
                            <label>name</label>
                            <input type="text" class="form-control" placeholder="enter name" name="name"
                                   value="${current_user.name}">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" class="form-control" placeholder="enter name" name="email"
                                   value="${current_user.email}">
                        </div>
                        <div class="form-group">
                            <label>Country</label>
                            <input type="text" class="form-control" placeholder="enter name" name="country"
                                   value="${current_user.country}">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <div class="input-group">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="exampleInputFile" name="image">
                                    <label class="custom-file-label"
                                           for="exampleInputFile">${current_user.image}</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Thumbnails</label>
                            <div>
                                <img style="width: 200px;height: 200px;" class="img-thumbnail"
                                     src="<c:url value="/upload/avatar/${current_user.image}"></c:url>">
                            </div>
                        </div>
                    </div>
                    <!-- /.card-body -->

                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script src="<c:url value='/assets/backend/plugins/jquery/jquery.min.js' />"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value='/assets/backend/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<!-- Select2 -->
<script src="<c:url value='/assets/backend/plugins/select2/js/select2.full.min.js'/>"></script>
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
<!-- bs-custom-file-input -->
<script src="<c:url value='/assets/backend/plugins/bs-custom-file-input/bs-custom-file-input.min.js'/>"></script>
<!-- Page specific script -->
<script>
    $(function () {
        bsCustomFileInput.init();
    });
</script>
</body>
</html>