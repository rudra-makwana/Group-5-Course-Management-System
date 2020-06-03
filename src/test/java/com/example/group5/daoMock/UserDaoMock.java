package com.example.group5.daoMock;

import com.example.group5.dao.UserDao;
import com.example.group5.model.User;

import java.util.List;

public class UserDaoMock implements UserDao {
    @Override
    public User assignAsInstructor(User users) {
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
