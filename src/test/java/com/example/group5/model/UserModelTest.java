package com.example.group5.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.group5.daoMock.UserDaoMock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserModelTest {
    @Test
    public void defaulConstructorTest(){
        User users = new User("B00826991","Rudra","Makwana");
        assertNotNull(users.getBannerID());
        assertNotNull(users.getFirstName());
        assertNotNull(users.getLastName());
    }

    @Test
    public void addInstructorConstructor(){
        User users = new User("B00826991","Rudra", "Makwana");
        UserDaoMock userDaoMock = new UserDaoMock();
        User usersTestCheck = userDaoMock.assignAsInstructor(new User("B00826991","Rudra", "Makwana"));

        assertEquals(users.getBannerID(), usersTestCheck.getBannerID());
        assertEquals(users.getFirstName(),usersTestCheck.getFirstName());
        assertEquals(users.getLastName(),usersTestCheck.getLastName());
    }

}
