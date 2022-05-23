package htdev.dao;

import htdev.model.ModelPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends Connect{
    public PostDao() {
        super();
    }
    //list post by category
    public List<ModelPost> listPostByCat(int idCat) throws SQLException {
        List<ModelPost> posts = new ArrayList<>();
        String sql = "select * from posts where category = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,idCat);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String slug = resultSet.getString("slug");
            String content = resultSet.getString("content");
            int category = resultSet.getInt("category");

            posts.add(new ModelPost(id,name,slug,category,content));
        }
        return posts;
    }

    //get info by slug
    public ModelPost selectPost(String slug) {
        ModelPost post = null;
        String sql = "select * from posts where slug like ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+slug+"%");
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String slug1 = result.getString("slug");
                String content = result.getString("content");
                int category = result.getInt("category");
                post = new ModelPost(id,name,slug1,category,content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
}
