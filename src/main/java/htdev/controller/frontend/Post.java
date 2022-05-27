package htdev.controller.frontend;

import htdev.dao.CategoryDao;
import htdev.dao.PostDao;
import htdev.model.ModelCategory;
import htdev.model.ModelPost;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/baiviet/*")
public class Post extends HttpServlet {
    private CategoryDao qly_categories;
    private PostDao qly_post;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_categories = new CategoryDao();
        qly_post = new PostDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ModelCategory> categories = qly_categories.getAll();
        request.setAttribute("categories",categories);
        String slug = request.getParameter("slug");
        ModelPost post = qly_post.selectPost(slug);
        request.setAttribute("post",post);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/frontend/post.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
