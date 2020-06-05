package com.example.group5.utility;

import java.sql.*;

public class CheckExistenceInDatabase {

    private String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String courseRegistrationTable = "CSCI5308_5_TEST.courseRegistration";
    private String courseTable = "CSCI5308_5_TEST.Courses";
    private String username="CSCI5308_5_TEST_USER";
    private String password="CSCI5308_5_TEST_5570";

    public int checkForExistingInstructor(String bannerId, String courseId){
        try {
            String courseSelectStatement="SELECT * FROM "+courseRegistrationTable+" WHERE courseId=\""+courseId+"\" AND userId=\""+bannerId+"\"";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(courseSelectStatement);
            if (resultSet.next() == false){
                statement.close();
                resultSet.close();
                connection.close();
                return 1;
            }
            else{
                statement.close();
                resultSet.close();
                connection.close();
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int checkForExistingCourse(String courseId){
        try {
            String courseSelectStatement="SELECT * FROM "+courseTable+" WHERE idCourses=\""+courseId+"\"";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(courseSelectStatement);
            if (resultSet.next() == false){
                statement.close();
                resultSet.close();
                connection.close();
                return 1;
            }
            else{
                statement.close();
                resultSet.close();
                connection.close();
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return 2;
        }
    }
}
