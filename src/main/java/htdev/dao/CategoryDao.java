package htdev.dao;

import htdev.model.ModelCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends Connect {
    public CategoryDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    //update category by idCat
    public boolean updateCategory(ModelCategory modelCategory){
        boolean kq = false;
        String sql = "update categories set name = ?, slug = ?, parent = ? where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,modelCategory.getName());
            preparedStatement.setString(2,modelCategory.getSlug());
            preparedStatement.setInt(3,modelCategory.getParent());
            preparedStatement.setInt(4,modelCategory.getId());
            if (preparedStatement.executeUpdate()>0){
                kq = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kq;
    }

    //get category by idCat
    public ModelCategory getCategoryByID(int idCat) {
        ModelCategory category = null;
        String sql = "select * from categories where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCat);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String slug = resultSet.getString("slug");
                int id = resultSet.getInt("id");
                int parent = resultSet.getInt("parent");
                category = new ModelCategory(id, name, slug, parent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    //delete
    public boolean delete(int idCat) {
        boolean kq = false;
        String sql = "delete from categories where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCat);
            if (preparedStatement.executeUpdate() > 0) {
                kq = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    //list all categories 
    public List<ModelCategory> getAll() {
        List<ModelCategory> categories = new ArrayList<ModelCategory>();
        String sql = "select * from categories";
        Connection connection = getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
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
            preparedStatement.setString(1, "%" + slug + "%");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("Name");
                String slug1 = result.getString("slug");
                int parent = result.getInt("parent");
                category = new ModelCategory(id, name, slug1, parent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    //add
    public boolean add(ModelCategory category) {
        boolean kq = false;
        String sql = "insert into categories(name,slug,parent) values(?,?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getSlug());
            preparedStatement.setInt(3, category.getParent());
            if (preparedStatement.executeUpdate() > 0) {
                kq = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
