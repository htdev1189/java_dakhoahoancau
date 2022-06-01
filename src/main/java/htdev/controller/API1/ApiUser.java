package htdev.controller.API1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import htdev.dao.UserDao;
import htdev.model.ModelPost;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@WebServlet("/backend/api_user")
public class ApiUser extends HttpServlet {
    private UserDao qly_user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_user = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            List<ModelUser> all_users = qly_user.getUserFromAPI("http://localhost:8080/demo/API");
            request.setAttribute("all_users",all_users);
            request.getRequestDispatcher("/views/api/user/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
