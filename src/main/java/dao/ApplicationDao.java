package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class ApplicationDao {
    public User getProfileDetails(String username) {
        User user = null;
        try {
            // get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get profile details
            String sql = "select * from users where username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new User();
                user.setUserId(set.getInt("user_id"));
                user.setUsername(set.getString("username"));
                user.setFirstName(set.getString("first_name"));
                user.setLastName(set.getString("last_name"));
                user.setAge(set.getInt("age"));
                user.setRegisterDate(set.getDate("register_date"));
                user.setActivity(set.getString("activity"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }
}
