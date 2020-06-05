package com.example.group5.service;

import com.example.group5.DaoMock.RegisteredCourseDaoTest;
import com.example.group5.model.RegisteredCourses;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RegistredCourseServiceTest {

    RegisteredCourseDaoTest registeredCourseDaoTest = new RegisteredCourseDaoTest();

    @Test
    public void getRegisteredCourse(){
        List<RegisteredCourses> registeredCourses = new ArrayList<>();
        registeredCourses = registeredCourseDaoTest.getRegisteredCourse("B00826991");
        assertNotNull(registeredCourses);
    }

}
