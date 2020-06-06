package com.example.group5.service;

import com.example.group5.DAO.IUserDao;
import com.example.group5.DaoMock.UserDaoMock;
import com.example.group5.config.SpringConfig;
import com.example.group5.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoursePageServiceTest {

    @Test
    void fetchUserList() {
        IUserDao iUserDao = new UserMock();
        assertNotNull(iUserDao.fetchUserList());
    }

    @Test
    void registerStudents() {
        // cannot test with a csv file
    }

    @Test
    void makeStudentTA() {
        // cannot test
        //assertFalse(SpringConfig.getObject().getCoursePageService().makeStudentTA("CSCI-5308", "boo843516"));
    }
}