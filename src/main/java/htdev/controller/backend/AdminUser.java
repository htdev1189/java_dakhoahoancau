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
    private String action;
    private ModelUser modelUser;
    private String name;
    private String email;
    private String country;
    private String pass;
    private String user;
    private String image;
    private int id;
    private String msg;
    private Part part;
    private String realPath;
    private String filename;


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
            case "edit":
                id = Integer.valueOf(request.getParameter("id"));
                modelUser = qly_user.getUserByID(id);
                request.setAttribute("current_user", modelUser);
                request.getRequestDispatcher("/views/backend/user/edit.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("/views/backend/user/add.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.valueOf(request.getParameter("id"));
                if (qly_user.delete(id)){
                    response.sendRedirect("/demo/backend/user?action=list");
                }
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
                name = request.getParameter("name");
                email = request.getParameter("email");
                user = request.getParameter("user");
                pass = request.getParameter("pass");
                country = request.getParameter("country");
                part = request.getPart("image");
                realPath = "D:\\JAVA_EXAMPLE\\demo\\src\\main\\webapp\\upload\\avatar\\";
                filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }
                //check file exists
                if (!Files.exists(Paths.get(realPath+"/"+filename))) {
                    part.write(realPath + "/" + filename);
                }
                modelUser = new ModelUser(name, email, country, pass, user, filename);
                if (qly_user.add(modelUser)) {
                    response.sendRedirect("http://localhost:8080/demo/backend/user?action=list");
                }
                break;
            case "edit":
                id = Integer.valueOf(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                country = request.getParameter("country");
                pass = request.getParameter("pass");
                user = request.getParameter("user");

                part = request.getPart("image");
                realPath = "D:\\JAVA_EXAMPLE\\demo\\src\\main\\webapp\\upload\\avatar\\";
                filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }
                //check file exists
                if (!Files.exists(Paths.get(realPath+"/"+filename))) {
                    part.write(realPath + "/" + filename);
                }
                modelUser = new ModelUser(id,name,email,country,pass,user,filename);
                if (qly_user.updateUser(modelUser)){
                    msg = "update success";
                    request.setAttribute("msg",msg);
                    response.sendRedirect("http://localhost:8080/demo/backend/user?action=list");
                }
                break;
            default:
                break;
        }
    }
}
