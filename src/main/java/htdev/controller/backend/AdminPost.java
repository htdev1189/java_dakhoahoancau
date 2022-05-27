package htdev.controller.backend;

import htdev.dao.CategoryDao;
import htdev.dao.PostDao;
import htdev.dao.UserDao;
import htdev.model.ModelCategory;
import htdev.model.ModelPost;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//ho tro upload file
@MultipartConfig()
@WebServlet("/backend/post")
public class AdminPost extends HttpServlet {
    private PostDao qly_post;
    private CategoryDao qly_category;
    private String name;
    private int id;
    private String slug;
    private Part part;
    private String filename;
    private String realPath;
    private String content;
    private String des;
    private ModelPost modelPost;
    private int category;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_post = new PostDao();
        qly_category = new CategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<ModelPost> allPost = qly_post.getAllPost();
        List<ModelCategory> allCategory = qly_category.getAll();
        switch (action) {
            case "list":
                request.setAttribute("allPost", allPost);
                request.getRequestDispatcher("/views/backend/post/list.jsp").forward(request, response);
                break;
            case "add":
                request.setAttribute("allCategory", allCategory);
                request.getRequestDispatcher("/views/backend/post/add.jsp").forward(request, response);
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                Boolean delete = qly_post.delete(id);
                if (delete) {
                    response.sendRedirect("http://localhost:8080/demo/backend/post?action=list");
                }
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                modelPost = qly_post.getPostByID(id);
                request.setAttribute("current_post",modelPost);
                request.setAttribute("allCategory", allCategory);
                request.getRequestDispatcher("/views/backend/post/edit.jsp").forward(request,response);
                break;
            default:
                response.sendRedirect("http://localhost:8080/demo/backend/post?action=list");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String act = req.getParameter("action");
        switch (act) {
            case "add":
                name = req.getParameter("tieude");
                category = Integer.parseInt(req.getParameter("category"));
                slug = qly_category.chuyendoi(name);
                slug = slug.replaceAll("\\s+", "-");
                //upload image
                part = req.getPart("image");
                realPath = "D:\\JAVA_EXAMPLE\\demo\\src\\main\\webapp\\upload\\hinhanhbaiviet\\";
                filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }
                //check file exists
                if (!Files.exists(Paths.get(realPath + "/" + filename))) {
                    part.write(realPath + "/" + filename);
                }
                //content
                content = req.getParameter("content");
                des = req.getParameter("des");

                modelPost = new ModelPost(name, slug, category, content, filename,des);
                if (qly_post.add(modelPost)) {
                    resp.sendRedirect("http://localhost:8080/demo/backend/post?action=list");
                }
                break;
            case "edit":
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("tieude");
                category = Integer.parseInt(req.getParameter("category"));
                slug = qly_category.chuyendoi(name);
                slug = slug.replaceAll("\\s+", "-");
                //upload image
                part = req.getPart("image");
                realPath = "D:\\JAVA_EXAMPLE\\demo\\src\\main\\webapp\\upload\\hinhanhbaiviet\\";
                filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }
                //check file exists
                if (!Files.exists(Paths.get(realPath + "/" + filename))) {
                    part.write(realPath + "/" + filename);
                }
                //content
                content = req.getParameter("content");
                des = req.getParameter("des");

                modelPost = new ModelPost(id,name, slug, category, content, filename,des);
                if (qly_post.update(modelPost)) {
                    resp.sendRedirect("http://localhost:8080/demo/backend/post?action=list");
                }
                break;
            default:
                break;
        }
    }
}
