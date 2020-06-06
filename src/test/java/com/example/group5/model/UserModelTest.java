package com.example.group5.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.group5.DaoMock.UserDaoMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserModelTest {
    @Test
    public void defaulConstructorTest(){
        InstructorUser users = new InstructorUser("B00826991","Rudra","Makwana");
        assertNotNull(users.getBannerID());
        assertNotNull(users.getFirstName());
        assertNotNull(users.getLastName());
    }

    @Test
    public void addInstructorConstructor(){
        InstructorUser users = new InstructorUser("B00826991","Rudra", "Makwana");
        UserDaoMock userDaoMock = new UserDaoMock();
        userDaoMock.assignAsInstructor("B00826991", "CSCI-5308");
    }

}
