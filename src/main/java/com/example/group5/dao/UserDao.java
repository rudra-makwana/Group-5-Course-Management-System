package com.example.group5.dao;

import com.example.group5.model.User;

import java.util.List;

public interface UserDao {

    void assignAsInstructor(User user, String courseID);

    List<User> getAllUsers();
}
