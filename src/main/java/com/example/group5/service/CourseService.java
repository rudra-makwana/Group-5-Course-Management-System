package com.example.group5.service;

import com.example.group5.configure.SpringConfig;
import com.example.group5.dao.CourseDao;
import com.example.group5.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDao {

    String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST";
    String courseTableName = "CSCI5308_5_TEST.courses";
    String username="CSCI5308_5_TEST_USER";
    String password="CSCI5308_5_TEST_5570";

    @Override
    public void insertCourse(Course course) {
        try {
            String insertStatement = "INSERT INTO "+courseTableName+" VALUES ("+course.getCourseId()+","+course.getCourseName()+")";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertStatement);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Course course) {
        try {
            String deleteStatement = "DELETE FROM "+courseTableName+"WHERE idCourses="+course.getCourseId()+")";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteStatement);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> selectAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            String courseSelectStatement="SELECT * FROM "+courseTableName;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(courseSelectStatement);
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
