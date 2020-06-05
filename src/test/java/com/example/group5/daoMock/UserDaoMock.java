package com.example.group5.DaoMock;

import com.example.group5.DAO.UserDao;
import com.example.group5.model.RegisteredCourseTestModel;
import com.example.group5.model.InstructorUser;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMock implements UserDao {
    public static List<RegisteredCourseTestModel>  assignedUser = new ArrayList<>();

    @Override
    public void assignAsInstructor(String bannerId, String courseID) {
        assignedUser.add(new RegisteredCourseTestModel(bannerId, courseID, 1));
    }

    public List<RegisteredCourseTestModel> getAssignedUser(){
        return assignedUser;
    }

    @Override
    public List<InstructorUser> getAllUsers() {
        List<InstructorUser> userList = null;
        return userList;
    }

}
