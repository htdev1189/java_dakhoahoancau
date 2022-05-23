<%--JSTL--%>

<header id="header" class="p-2">
    <div class="container">
        <div class="d-flex justify-content-between align-items-center header">
            <div class="header-left">
                <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/assets/frontend/images/header-logo.svg"></a>
            </div>
            <div class="header-right">
                <ul class="d-flex p-0 m-0 align-items-center">
                    <li><a href="${pageContext.request.contextPath}"
                           class="d-block p-3 pl-4 pr-4 text-dark text-uppercase">home</a></li>
                    <li><a href="${pageContext.request.contextPath}"
                           class="d-block p-3 pl-4 pr-4 text-dark text-uppercase">about</a></li>
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle text-dark text-uppercase "
                            data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                            aria-expanded="false">Categories</a>
                        <div class="dropdown-menu">
                            <c:forEach var="category" items="${categories}">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/category?slug=<c:out value='${category.slug}'></c:out>"><c:out value="${category.name}"></c:out></a>
                            </c:forEach>
                        </div></li>
                    <li><a href="${pageContext.request.contextPath}"
                           class="d-block p-3 pl-4 pr-4 text-dark text-uppercase">contact</a></li>
                    <li class="header-right-btn"><a href=""
                                                    class="btn btn-danger d-flex align-items-center justify-content-center"><img
                            src="${pageContext.request.contextPath}/assets/frontend/images/icon-hotline.svg">${initParam['SDT']}</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>