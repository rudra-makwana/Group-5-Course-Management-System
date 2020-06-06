package com.example.group5.service;

import com.example.group5.DAO.CourseDao;
import com.example.group5.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDao {

    String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String courseTableName = "CSCI5308_5_TEST.Courses";
    String courseRegistrationTable = "CSCI5308_5_TEST.courseRegistration";
    String username="CSCI5308_5_TEST_USER";
    String password="CSCI5308_5_TEST_5570";

    @Override
    @SuppressWarnings("deprecation")
    public void insertCourse(Course course) {
        try {
            String insertStatement = "INSERT INTO "+courseTableName+" VALUES (\""+course.getCourseId()+"\",\""+course.getCourseName()+"\")";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertStatement);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void deleteCourse(String courseId) {
        try {
            String deleteStatementFromCourse = "DELETE FROM "+courseTableName+" WHERE idCourses=\""+courseId+"\"";
            String deleteStatementFromRegistration = "DELETE FROM "+courseRegistrationTable+" WHERE courseId=\""+courseId+"\"";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteStatementFromRegistration);
            statement.executeUpdate(deleteStatementFromCourse);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getCourseName(String courseId) {
        String courseName = "There is some unknown error";
        String selectCourseStatement = "select courseName from CSCI5308_5_TEST.Courses where idCourses=\""+courseId+"\"";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectCourseStatement);
            while (resultSet.next()){
                courseName = resultSet.getString("courseName");
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return courseName;
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<Course> getRegisteredCourses(String bannerId) {
        List<Course> courses = new ArrayList<>();
        try {
            String courseSelectStatement="SELECT * FROM "+courseRegistrationTable+"WHERE bannerId = "+bannerId;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(courseSelectStatement);
            while (resultSet.next()){
                String courseId = resultSet.getString("idCourses");
                String courseName = resultSet.getString("courseName");
                courses.add(new Course(courseId,courseName));
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    @SuppressWarnings("deprecation")
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
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}