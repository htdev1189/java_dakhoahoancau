<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
            <img style="height: 40px;width: 40px;" src="<c:url value='/upload/avatar/${session_user.image}'/>"
                 class="img-circle elevation-2"
                 alt="User Image">
        </div>
        <div class="info">
            <a href="${pageContext.request.contextPath}/backend" class="d-block">${session_user.name}</a>
        </div>
    </div>

    <!-- Sidebar Menu -->
    <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
                 with font-awesome or any other icon font library -->
            <li class="nav-item">
                <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-chart-pie"></i>
                    <p>
                        Category
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/cat?action=add" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Add</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/cat?action=list" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>List</p>
                        </a>
                    </li>

                </ul>
            </li>

            <%--user--%>
            <li class="nav-item">
                <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-chart-pie"></i>
                    <p>
                        User
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/user?action=add" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Add</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/user?action=list" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>List</p>
                        </a>
                    </li>

                </ul>
            </li>

            <%--post--%>
            <li class="nav-item">
                <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-chart-pie"></i>
                    <p>
                        Post
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/post?action=add" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Add</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/post?action=list" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>List</p>
                        </a>
                    </li>

                </ul>
            </li>


            <%--            api user --%>
            <li class="nav-item">
                <a href="#" class="nav-link">
                    <i class="nav-icon fas fa-chart-pie"></i>
                    <p>
                        API User
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/backend/api_user" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>List</p>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </nav>
    <!-- /.sidebar-menu -->
</div>
<!-- /.sidebar -->