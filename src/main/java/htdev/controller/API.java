package htdev.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import htdev.dao.CategoryDao;
import htdev.dao.PostDao;
import htdev.dao.UserDao;
import htdev.model.ModelUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/API")
public class API extends HttpServlet {
    private UserDao qly_user;
    private Gson gson;
    private ModelUser user;

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
        response.setContentType("application/json");
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            //read data
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            ModelUser user = gson.fromJson(jb.toString(), ModelUser.class);
            qly_user.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //update

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            //read data
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            ModelUser user = gson.fromJson(jb.toString(), ModelUser.class);
            qly_user.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            //read data
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            // truong hop 1 id
            Map<String, Integer> ids = new HashMap<String, Integer>();
            Type mapType = new TypeToken<Map<String, Integer>>() {
            }.getType();
            ids = gson.fromJson(jb.toString(), mapType);
            qly_user.delete(ids.get("id"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
