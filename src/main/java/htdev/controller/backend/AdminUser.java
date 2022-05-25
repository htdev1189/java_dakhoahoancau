package htdev.controller.backend;

import htdev.dao.UserDao;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//ho tro upload file
@MultipartConfig()
@WebServlet("/backend/user")
public class AdminUser extends HttpServlet {
    private UserDao qly_user;
    private static String action;
    private static ModelUser modelUser;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_user = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        List<ModelUser> all_users = qly_user.getAllUser();
        request.setAttribute("all_users", all_users);
        switch (action) {
            case "list":
                request.getRequestDispatcher("/views/backend/user/list.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("/views/backend/user/add.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        action = request.getParameter("action");
        switch (action) {
            case "add":
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                String country = request.getParameter("country");

                Part part = request.getPart("image");
                String realPath = "D:\\JAVA_EXAMPLE\\demo\\src\\main\\webapp\\upload\\";
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }
                part.write(realPath + "/" + filename);
                modelUser = new ModelUser(name,email,country,pass,user,filename);
                if (qly_user.add(modelUser)){
                    response.sendRedirect("http://localhost:8080/demo/backend/user?action=list");
                }
                break;
            default:
                break;
        }
    }
}
