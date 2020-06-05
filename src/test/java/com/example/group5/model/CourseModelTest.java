package com.example.group5.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CourseModelTest {

    @Test
    public void courseConstructorTest(){
        Course course = new Course("CSCI-5308","Advanced SDC");
        assertNotNull(course.getCourseId());
        assertNotNull(course.getCourseName());
    }
}
