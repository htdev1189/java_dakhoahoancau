<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="chuyenkhoa">
    <div class="container">
        <h2 class="text-center text-uppercase text-dark">chuyên khoa</h2>
        <div class="row mt-4">
            <c:forEach items="${categories}" var="category">
                <div class="col-md-4">
                    <a href="" class="ck-item d-flex flex-column align-items-center justify-content-center">
                        <img class="w-25" src="${pageContext.request.contextPath}/assets/frontend/images/ck-noi-khoa.svg" alt="">
                        <span class="text-uppercase text-dark font-weight-bold"><c:out value="${category.name}"></c:out></span>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
