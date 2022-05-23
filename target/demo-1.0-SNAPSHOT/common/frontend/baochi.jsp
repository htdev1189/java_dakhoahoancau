<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="baochi" class="p-5">
    <div class="container">
        <h2 class="text-center text-uppercase text-dark">báo chí nói về chúng tôi</h2>
        <div class="row">
            <% for (int i = 0; i<6; i++) {%>
            <div class="mt-4 col-md-6">
                <a href="" class="d-flex ">
                    <img class="mr-2" src="${pageContext.request.contextPath}/assets/frontend/images/24h.jpg" style="object-fit: contain;height: 100%;width: 100%;">
                    <div>
                        <h5 class="text-dark"><i class="text-capitalize">phòng khám đa khoa hoàn cầu</i> trao sức khỏe - vạn niềm tin</h5>
                        <p class="text-dark baochi-p">
                            Phòng Khám Đa Khoa Hoàn Cầu hoạt động vì mục tiêu nâng cao sức khỏe cộng đồng, chuyên  mục tiêu nâng cao sức khỏe cộng đồng, chuyên
                        </p>
                    </div>
                </a>
            </div>
            <% } %>
        </div>
    </div>
</div>
