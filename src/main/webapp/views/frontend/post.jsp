<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Trang home frontend</title>
    <link rel="stylesheet"	href="${pageContext.request.contextPath}/assets/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/frontend/css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-4 mb-4">
    <div class="row">
        <div class="col-4">
            <%@ include file="/common/frontend/cat-left.jsp" %>
        </div>
        <div class="col-8">
            <%@ include file="/common/frontend/post-right.jsp" %>
        </div>
    </div>
</div>
</body>
</html>
