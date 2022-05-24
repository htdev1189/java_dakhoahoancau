package htdev.controller.backend;

import javax.servlet.*;
import javax.servlet.http.*;

import htdev.dao.CategoryDao;
import htdev.model.ModelCategory;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Signature;
import java.util.List;

@WebServlet("/backend/cat")
public class AdminCat extends HttpServlet {
    private static ModelCategory category;
    private CategoryDao qly_category;
    private static int id;
    private static String msg;
    private static String slug;
    private static int parent;
    private static String name;

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
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                ModelCategory category_current = qly_category.getCategoryByID(id);
                request.setAttribute("category_current",category_current);
                request.getRequestDispatcher("/views/backend/category/edit.jsp").forward(request,response);
                break;
            case "add":
                request.getRequestDispatcher("/views/backend/category/add.jsp").forward(request,response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                Boolean delete = qly_category.delete(id);
                if (delete) {
                    response.sendRedirect("http://localhost:8080/demo/backend/cat?action=list");
                }
                break;
            default:
                System.out.println("list");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        switch (action){
            case "add":
                name = request.getParameter("name");
                parent = Integer.parseInt(request.getParameter("parent"));
                slug = qly_category.chuyendoi(name);
                slug = slug.replaceAll("\\s+", "-");
                if (!name.isEmpty()){
                    ModelCategory category = new ModelCategory(name,slug,parent);
                    if (qly_category.add(category)) {
                        response.sendRedirect("http://localhost:8080/demo/backend/cat?action=list");
                    }
                }
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                parent = Integer.parseInt(request.getParameter("parent"));
                name = request.getParameter("name");
                slug = qly_category.chuyendoi(name);
                slug = slug.replaceAll("\\s+", "-");
                //get current category
                category = new ModelCategory(id,name,slug,parent);
                if (qly_category.updateCategory(category)){
                    msg = "update success";
                    request.setAttribute("msg",msg);
                    response.sendRedirect("http://localhost:8080/demo/backend/cat?action=list");
                }
                break;
            default:
                break;
        }
    }
}
