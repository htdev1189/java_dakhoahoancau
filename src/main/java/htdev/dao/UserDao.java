package htdev.dao;

import htdev.model.ModelUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Connect{
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
               modelUser = new ModelUser(id,name,email,country,pass,user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modelUser;
    }
}
