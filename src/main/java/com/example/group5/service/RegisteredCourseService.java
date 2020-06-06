package com.example.group5.service;

import com.example.group5.DAO.RegisteredCourseDao;
import com.example.group5.config.SpringConfig;
import com.example.group5.model.RegisteredCourses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisteredCourseService implements RegisteredCourseDao {

    String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String courseRegistrationTable = "CSCI5308_5_TEST.courseRegistration";
    String username="CSCI5308_5_TEST_USER";
    String password="CSCI5308_5_TEST_5570";

    @Override
    public List<RegisteredCourses> getRegisteredCourse(String bannerID) {
        String getRegisteredCourseQuery = "SELECT courseId,roleId FROM "+courseRegistrationTable+" WHERE userId=\""+bannerID+"\"" ;
        List<RegisteredCourses> registeredCoursesList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getRegisteredCourseQuery);
            while (resultSet.next()){
                String roleType = null;
                String courseId = resultSet.getString("courseId");
                int roleId = resultSet.getInt("roleId");
                if(roleId == 1){
                    roleType = "Instructor";
                }else if(roleId == 2){
                    roleType = "TA";
                }else{
                    roleType = "Student";
                }
                CourseService courseService = SpringConfig.getObject().getCourseService();
                String courseName = courseService.getCourseName(courseId);
                registeredCoursesList.add(new RegisteredCourses(courseId, bannerID, roleId, roleType, courseName));
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return registeredCoursesList;
    }
}