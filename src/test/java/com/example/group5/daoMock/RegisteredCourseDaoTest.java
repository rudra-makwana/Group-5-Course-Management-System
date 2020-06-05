package com.example.group5.DaoMock;

import com.example.group5.DAO.RegisteredCourseDao;
import com.example.group5.model.RegisteredCourses;

import java.util.ArrayList;
import java.util.List;

public class RegisteredCourseDaoTest implements RegisteredCourseDao {
    List<RegisteredCourses> registeredCoursesList = new ArrayList<>();

    @Override
    public List<RegisteredCourses> getRegisteredCourse(String bannerID) {
        registeredCoursesList.add(new RegisteredCourses("CSCI-5308",bannerID,1,"TA","ASDC"));
        return registeredCoursesList;
    }
}
