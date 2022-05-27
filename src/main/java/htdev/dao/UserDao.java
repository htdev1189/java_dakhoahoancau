package htdev.dao;

import htdev.model.ModelCategory;
import htdev.model.ModelUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Connect {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private boolean kq;
    private String sql;
    public UserDao() {
        super();
        connection = getConnection();
    }

    public boolean delete(int idUser){
        kq = false;
        sql = "delete from users where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idUser);
            if (preparedStatement.executeUpdate()>0){
                kq = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kq;
    }
    //update
    public boolean updateUser(ModelUser modelUser) {
        boolean kq = false;
        String sql = "update users set name = ?, email = ?, country = ?, pass = ?, user = ?, image = ? where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, modelUser.getName());
            preparedStatement.setString(2, modelUser.getEmail());
            preparedStatement.setString(3, modelUser.getCountry());
            preparedStatement.setString(4, modelUser.getPass());
            preparedStatement.setString(5, modelUser.getUser());
            preparedStatement.setString(6, modelUser.getImage());
            preparedStatement.setInt(7, modelUser.getId());
            if (preparedStatement.executeUpdate() > 0) {
                kq = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    //get user by idUser
    public ModelUser getUserByID(int idUser) {
        ModelUser modelUser = null;
        String sql = "select * from users where id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String pass = resultSet.getString("pass");
                String user = resultSet.getString("user");
                int id = resultSet.getInt("id");
                String image = resultSet.getString("image");
                modelUser = new ModelUser(id, name, email, country, pass, user, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelUser;
    }


    //add
    public boolean add(ModelUser user) {
        boolean kq = false;
        String sql = "insert into users(name,email,country,pass,user,image) values(?,?,?,?,?,?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setString(5, user.getUser());
            preparedStatement.setString(6, user.getImage());
            if (preparedStatement.executeUpdate() > 0) {
                kq = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }


    //login
    public ModelUser login(String str_user, String str_pass) {
        ModelUser modelUser = null;
        String sql = "select * from users where user = ? and pass = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, str_user);
            preparedStatement.setString(2, str_pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String user = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String image = resultSet.getString("image");
                modelUser = new ModelUser(id, name, email, country, pass, user, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelUser;
    }

    //get all user
    public List<ModelUser> getAllUser() {
        List<ModelUser> list = new ArrayList<>();
        String sql = "select * from users";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String user = resultSet.getString("user");
                String country = resultSet.getString("country");
                String pass = resultSet.getString("pass");
                String image = resultSet.getString("image");
                //add to list
                list.add(new ModelUser(id, name, email, country, pass, user, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
