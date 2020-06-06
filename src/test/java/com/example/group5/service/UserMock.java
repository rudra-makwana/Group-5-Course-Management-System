package com.example.group5.service;

import com.example.group5.DAO.ICsvFileDao;
import com.example.group5.DAO.IUserDao;
import com.example.group5.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMock implements IUserDao {
    @Override
    public List<User> fetchUserList() {
        List<User> arrayList = new ArrayList<>();
        arrayList.add(new User("xyz", "krutin", "trivedi", "krutin@dal.ca", "krutin"));
        return arrayList;
    }

}
