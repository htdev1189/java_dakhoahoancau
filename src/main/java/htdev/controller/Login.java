package htdev.controller;

import htdev.dao.UserDao;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private UserDao qly_user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_user = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String user = request.getParameter("username");
       String pass = request.getParameter("password");

        ModelUser modelUser = qly_user.login(user,pass);
        if (modelUser == null){
            System.out.println("error");
            request.setAttribute("error","vui long kiem tra lai");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }else{
            System.out.println("ok");
            response.sendRedirect("backend");
        }
    }
}
