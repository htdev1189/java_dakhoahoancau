<div class="cat-left">
<%--list category--%>
    <div id="cat-allcat">
        <div class="list-group">

            <c:forEach items="${categories}" var="cat">
                <c:if test="${empty post}">
            <a href="${pageContext.request.contextPath}/category?slug=${cat.slug}" class="list-group-item list-group-item-action ${category.id==cat.id? "active" : ""} text-capitalize">${cat.name}</a>
            </c:if>

                <c:if test="${not empty post}">
                    <a href="${pageContext.request.contextPath}/category?slug=${cat.slug}" class="list-group-item list-group-item-action ${post.category==cat.id? "active" : ""} text-capitalize">${cat.name}</a>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>