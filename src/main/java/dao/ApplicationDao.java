package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import beans.User;

public class ApplicationDao {
    public User getUser(int userId) {
        User user = null;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from users where user_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = userFromSet(set);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public int getUsersCount() {
        int countUser = 0;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();
            String sql = "SELECT COUNT(*) as countUser FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            set.next();
            countUser = set.getInt("countUser");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return countUser;
    }

    public List<User> getUserList(int start, int count) {
        User user = null;
        List<User> users = new ArrayList<User>();
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from users limit ? offset ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, count);
            statement.setInt(2, start);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = userFromSet(set);
                users.add(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public void createUser(String username, String password, String firstName, String lastName, int age, String activity) {
        User user = null;
        try {
            Date registerDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");

            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "insert into users(username, password, first_name, last_name, age, register_date, activity) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setInt(5, age);
            statement.setString(6, sdf.format(registerDate));
            statement.setString(7, activity);

            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

//            String sql = "insert into users(username, password, first_name, last_name, age, register_date, activity) values (?,?,?,?,?,?,?)";
            String sql = "UPDATE users " +
                    "SET first_name = ?, last_name = ?, age = ?, activity = ? " +
                    "WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getActivity());
            statement.setInt(5, user.getUserId());

            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private User userFromSet(ResultSet set) {
        User user = null;
        try {
            user = new User();
            user.setUserId(set.getInt("user_id"));
            user.setUsername(set.getString("username"));
            user.setFirstName(set.getString("first_name"));
            user.setLastName(set.getString("last_name"));
            user.setAge(set.getInt("age"));
            user.setRegisterDate(set.getDate("register_date"));
            user.setActivity(set.getString("activity"));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }
}
