package com.example.group5.service;

import com.example.group5.DaoMock.UserDaoMock;
import com.example.group5.model.RegisteredCourseTestModel;
import com.example.group5.model.InstructorUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class usersTestService {


    @Test
    public void assignInstructor(){
        UserDaoMock userDaoMock = new UserDaoMock();
        String bannerId = "B00826991";
        String courseId = "CSCI-5308";
        userDaoMock.assignAsInstructor(bannerId,courseId);
        List<RegisteredCourseTestModel> assignedUsers = userDaoMock.getAssignedUser();
        assertNotNull(assignedUsers);
    }

    @Test
    public void fetchUsers(){
        UserDaoMock userDaoMock = new UserDaoMock();
        List<InstructorUser> userList = userDaoMock.getAllUsers();
        assertNull(userList);
    }
}
