<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="pt-lg-5 pb-lg-5">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="">
                    <a href="" class="d-block mb-3"><img src="${pageContext.request.contextPath}/assets/frontend/images/footer-logo.svg"></a>
                    <ul class="p-0">
                        <li class="d-flex align-items-center mb-3">
                            <img class="ft-1-img mr-2" src="${pageContext.request.contextPath}/assets/frontend/images/footer-hotline.svg">
                            <span class="text-white">Hotline ${initParam['SDT']}</span>
                        </li>
                        <li class="d-flex align-items-center mb-3">
                            <img class="ft-1-img mr-2" src="${pageContext.request.contextPath}/assets/frontend/images/footer-giokham.svg">
                            <span class="text-white">Thời gian làm việc : 8h-20h</span>
                        </li>
                        <li class="d-flex align-items-center mb-3">
                            <img class="ft-1-img mr-2" src="${pageContext.request.contextPath}/assets/frontend/images/footer-diachi.svg">
                            <span class="text-white">80-82 châu văn liêm, p11, q5, TP.HCM</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="ft-3">
                    <h3 class="position-relative font-weight-bold text-white text-uppercase mb-3 pb-2">đăng ký tư vấn</h3>
                    <form action="" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="ho ten">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="so dien thoai">
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </form>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="ft-3">
                    <h3 class="position-relative font-weight-bold text-white text-uppercase mb-3 pb-2">chỉ dẫn đường đi</h3>
                    <a href=""><img class="w-100" src="${pageContext.request.contextPath}/assets/frontend/images/maps.jpg" alt=""></a>
                </div>
            </div>
        </div>
    </div>
</footer>