package htdev.fillter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoggerFillter")
public class LoggerFillter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter start");
        //khai bao http request
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession();
        //kiem tra session co ton tai khong
        Object obj = httpSession.getAttribute("id");
        if (obj != null){
            chain.doFilter(request, response);
        }
        else {
            httpServletResponse.sendRedirect("http://localhost:8080/demo/login");
        }

    }
}
