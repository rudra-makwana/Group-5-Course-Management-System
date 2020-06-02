package com.example.group5.dao;

import com.example.group5.configure.SpringConfig;
import com.example.group5.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImplementation implements CourseDao{

    @Override
    public void insertCourse(Course course) {
        try {
            String insertStatement = "INSERT INTO "+SpringConfig.getObject().getCourseTableName()+" VALUES ("+course.getCourseId()+","+course.getCourseName()+")";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(SpringConfig.getObject().getUrl(),SpringConfig.getObject().getUsername(), SpringConfig.getObject().getPassword());
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
            String courseSelectStatement="SELECT * FROM "+SpringConfig.getObject().getCourseTableName();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(SpringConfig.getObject().getUrl(),SpringConfig.getObject().getUsername(), SpringConfig.getObject().getPassword());
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
