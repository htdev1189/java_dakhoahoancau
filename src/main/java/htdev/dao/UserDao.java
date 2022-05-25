package htdev.dao;

import htdev.model.ModelCategory;
import htdev.model.ModelUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Connect{


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
    public ModelUser login(String str_user, String str_pass){
        ModelUser modelUser = null;
        String sql = "select * from users where user = ? and pass = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,str_user);
            preparedStatement.setString(2,str_pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                String user = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String image = resultSet.getString("image");
               modelUser = new ModelUser(id,name,email,country,pass,user,image);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modelUser;
    }

    //get all user
    public List<ModelUser> getAllUser(){
        List<ModelUser> list = new ArrayList<>();
        String sql = "select * from users";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String user = resultSet.getString("user");
                String country = resultSet.getString("country");
                String pass = resultSet.getString("pass");
                String image = resultSet.getString("image");
                //add to list
                list.add(new ModelUser(id,name,email,country,pass,user,image));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
