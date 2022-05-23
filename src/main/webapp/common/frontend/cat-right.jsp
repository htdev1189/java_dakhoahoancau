<div id="cat-right">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Library</a></li>
            <li class="breadcrumb-item active" aria-current="page">Data</li>
        </ol>
    </nav>


        <div class="row">
        <c:forEach items="${posts}" var="post">
            <div class="col-6 mb-4">
            <div class="card">
                <img class="card-img-top" src="${pageContext.request.contextPath}/assets/frontend/images/thumb.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${post.name}</h5>
                    <p class="card-text">${post.content}</p>
                    <a href="${pageContext.request.contextPath}/post?slug=${post.slug}" class="btn btn-primary">More</a>
                </div>
            </div>
            </div>
        </c:forEach>
        </div>
</div>