package htdev.controller.backend;

import javax.servlet.*;
import javax.servlet.http.*;

import htdev.dao.CategoryDao;
import htdev.model.ModelCategory;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/backend/cat")
public class AdminCat extends HttpServlet {
    private CategoryDao qly_category;

    @Override
    public void init(ServletConfig config) throws ServletException {
        qly_category = new CategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<ModelCategory> categories = qly_category.getAll();
        request.setAttribute("categories", categories);
        switch (action) {
            case "list":
                request.getRequestDispatcher("/views/backend/category/list.jsp").forward(request,response);
                break;
            case "add":
                request.getRequestDispatcher("/views/backend/category/add.jsp").forward(request,response);
                break;
            default:
                System.out.println("list");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                String name = request.getParameter("name");
                int parent = Integer.parseInt(request.getParameter("parent"));
                String str = qly_category.removeAccent(name);
                String rs = str.replaceAll("\\s+", "-");
                if (!name.isEmpty()){
                    ModelCategory category = new ModelCategory(name,rs,parent);
                    boolean add = qly_category.add(category);
                    if (add) {
                        response.sendRedirect("http://localhost:8080/demo/backend/cat?action=list");
                    }
                }
                break;
            default:
                break;
        }
    }
}
