package htdev.controller;

import com.google.gson.Gson;
import htdev.dao.CategoryDao;
import htdev.dao.PostDao;
import htdev.dao.UserDao;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/API")
public class API extends HttpServlet {
    private UserDao qly_user;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_user = new UserDao();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        //all user
        List<ModelUser> allUser = qly_user.getAllUser();
        //ModelUser user = new ModelUser("name","email","vietnam","password","user","image");
        printWriter.println(gson.toJson(allUser));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
