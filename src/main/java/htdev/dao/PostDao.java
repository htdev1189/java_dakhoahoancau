package htdev.dao;

import htdev.model.ModelPost;

import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends Connect{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private String sql;
    private boolean kq;
    public PostDao() {
        super();
        connection = getConnection();
    }

    //update post by id
    public boolean update(ModelPost modelPost){
        kq = false;
        sql = "update posts set name = ?, slug= ?, category = ?,content = ?,image = ?,des = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,modelPost.getName());
            preparedStatement.setString(2,modelPost.getSlug());
            preparedStatement.setInt(3,modelPost.getCategory());
            preparedStatement.setString(4,modelPost.getContent());
            preparedStatement.setString(5,modelPost.getImage());
            preparedStatement.setString(6,modelPost.getDes());
            preparedStatement.setInt(7,modelPost.getId());
            if (preparedStatement.executeUpdate()>0){
                kq = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kq;
    }

    //get post by idPost
    public ModelPost getPostByID(int idPost){
        ModelPost modelPost = null;
        String sql = "select * from posts where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPost);
            result = preparedStatement.executeQuery();
            while (result.next()){
                modelPost = new ModelPost(result.getString("name"),result.getString("slug"),result.getInt("category"),result.getString("content"),result.getString("image"),result.getString("des"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modelPost;
    }

    //add post
    public boolean add(ModelPost modelPost){
        boolean kq = false;
        Connection connection = getConnection();
        String sql = "insert into posts (name,slug,category,content,image,des) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,modelPost.getName());
            preparedStatement.setString(2,modelPost.getSlug());
            preparedStatement.setInt(3,modelPost.getCategory());
            preparedStatement.setString(4,modelPost.getContent());
            preparedStatement.setString(5,modelPost.getImage());
            preparedStatement.setString(6,modelPost.getDes());
            if (preparedStatement.executeUpdate()>0){
                kq = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //delete id
    public boolean delete(int idPost){
        boolean kq = false;
        String sql = "delete from posts where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPost);
            if (preparedStatement.executeUpdate() > 0){
                kq=true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kq;
    }

    //get all post
    public List<ModelPost> getAllPost(){
        List<ModelPost> allPost = new ArrayList<>();
        String sql = "select * from posts";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String slug = resultSet.getString("slug");
                int category = resultSet.getInt("category");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                String des = resultSet.getString("des");
                allPost.add(new ModelPost(id,name,slug,category,content,image,des));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return allPost;
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
            String image = resultSet.getString("image");
            String des = resultSet.getString("des");

            posts.add(new ModelPost(id,name,slug,category,content,image,des));
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
                String image = result.getString("image");
                String des = result.getString("des");
                post = new ModelPost(id,name,slug1,category,content,image,des);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
}
