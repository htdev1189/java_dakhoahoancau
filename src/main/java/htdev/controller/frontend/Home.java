package htdev.controller.frontend;

import htdev.dao.CategoryDao;
import htdev.model.ModelCategory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/frontend")
public class Home extends HttpServlet {
    private CategoryDao qly_categories;
    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_categories = new CategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ModelCategory> categories = qly_categories.getAll();
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/frontend/home.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
