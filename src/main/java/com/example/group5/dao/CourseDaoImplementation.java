package com.example.group5.dao;

import com.example.group5.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImplementation implements CourseDao{

    private String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST";
    private String username="CSCI5308_5_TEST_USER";
    private String password="CSCI5308_5_TEST_5570";
    private String selectStatement = "SELECT * FROM CSCI5308_5_TEST.courses";

    @Override
    public void insertCourse(Course course) {
        try {
            String insertStatement = "INSERT INTO CSCI5308_5_TEST.courses (courseName) VALUES ("+course.getCourseId()+","+course.getCourseName()+")";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertStatement);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> selectAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);
            while (resultSet.next()){
                String courseId = resultSet.getString("idCourses");
                String courseName = resultSet.getString("courseName");
                courses.add(new Course(courseId,courseName));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
