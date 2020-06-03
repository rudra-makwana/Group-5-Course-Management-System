package com.example.group5.service;

import com.example.group5.dao.UserDao;
import com.example.group5.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignInstructorService implements UserDao {

    String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST";
    String courseTableName = "CSCI5308_5_TEST.courses";
    String username="CSCI5308_5_TEST_USER";
    String password="CSCI5308_5_TEST_5570";

    @Override
    public void assignAsInstructor(User user, String courseID) {
        try {
            String assignInstructorQuery = "INSERT INTO "+courseTableName+"VALUES ("+courseID+","+user.getBannerID()+", 1";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String courseSelectStatement="SELECT * FROM "+courseTableName;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(courseSelectStatement);
            while (resultSet.next()){
                String bannerID = resultSet.getString("bannerId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                users.add(new User(bannerID,firstName,lastName));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}