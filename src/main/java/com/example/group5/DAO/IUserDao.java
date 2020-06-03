package com.example.group5.DAO;

import com.example.group5.model.User;

import java.util.List;

public interface IUserDao {
    List<User> fetchUserList();
}