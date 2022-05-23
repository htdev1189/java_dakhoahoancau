package htdev.controller.frontend;

import htdev.dao.CategoryDao;
import htdev.dao.PostDao;
import htdev.model.ModelCategory;
import htdev.model.ModelPost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/category/*")
public class Category extends HttpServlet {
    private CategoryDao qly_categories;
    private PostDao qly_post;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_categories = new CategoryDao();
        qly_post = new PostDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String slug = request.getParameter("slug");
        ModelCategory category = qly_categories.selectCat(slug);
        List<ModelCategory> categories = qly_categories.getAll();
        List<ModelPost> posts = null;
        try {
            posts = qly_post.listPostByCat(category.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("categories", categories);
        request.setAttribute("category", category);
        request.setAttribute("posts", posts);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/frontend/category.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
