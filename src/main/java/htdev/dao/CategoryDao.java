package htdev.dao;

import htdev.model.ModelCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends Connect{
    public CategoryDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    //list all categories 
    public List<ModelCategory> getAll(){
        List<ModelCategory> categories = new ArrayList<ModelCategory>();
        String sql = "select * from categories";
        Connection connection = getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                int parent = result.getInt("parent");
                String name = result.getString("name");
                String slug = result.getString("slug");
                //add to list
                categories.add(new ModelCategory(id, name, slug, parent));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return categories;
    }

    //get category by slug
    public ModelCategory selectCat(String slug) {
        ModelCategory category = null;
        String sql = "select * from categories where slug like ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+slug+"%");
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("Name");
                String slug1= result.getString("slug");
                int parent = result.getInt("parent");
                category = new ModelCategory(id,name,slug1,parent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    //add
    public boolean add(ModelCategory category){
        boolean kq = false;
        String sql = "insert into catories(name,slug,parent) values(?,?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(3,category.getId());
            preparedStatement.setString(2,category.getSlug());
            int add = preparedStatement.executeUpdate();
            if (add>0){
                kq=true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kq;
    }
}
