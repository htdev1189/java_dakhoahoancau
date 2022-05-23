<%@ include file="/common/backend/header.jsp" %>
<div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake" src="<c:url value='/assets/backend/img/AdminLTELogo.png' />" alt="AdminLTELogo"
             height="60" width="60">
    </div>

    <%@ include file="/common/backend/navbar.jsp" %>

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
            <img src="<c:url value='/assets/backend/img/AdminLTELogo.png'/>" alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <%@ include file="/common/backend/sidebar.jsp" %>

    </aside>
    <dec:body/>
</div>
<%@ include file="/common/backend/footer.jsp" %>