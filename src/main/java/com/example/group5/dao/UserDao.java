package com.example.group5.DAO;

import com.example.group5.model.InstructorUser;

import java.util.List;

public interface UserDao {

    void assignAsInstructor(String bannerId, String courseID);

    List<InstructorUser> getAllUsers();
}
