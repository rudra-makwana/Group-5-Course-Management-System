package com.example.group5.service;

import com.example.group5.DaoMock.CourseDaoMock;
import com.example.group5.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseServiceTest {
    CourseDaoMock courseDaoMock = new CourseDaoMock();

    @Test
    public void assignAndFetchService(){
        Course course = new Course("CSCI-5308","ASDC");
        courseDaoMock.insertCourse(course);
        List<Course> courseList = new ArrayList<>();
        courseList = courseDaoMock.selectAllCourses();
        assertNotNull(courseList);
    }
}
