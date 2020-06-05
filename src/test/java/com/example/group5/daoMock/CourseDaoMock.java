package com.example.group5.DaoMock;

import com.example.group5.DAO.CourseDao;
import com.example.group5.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoMock implements CourseDao {

    private static List<Course> courseList = new ArrayList<>();

    @Override
    public void insertCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void deleteCourse(String courseID) {

    }

    @Override
    public String getCourseName(String courseId) {
        return "COURSE NAME";
    }

    @Override
    public List<Course> getRegisteredCourses(String bannerId) {
        return null;
    }

    @Override
    public List<Course> selectAllCourses() {
        return courseList;
    }
}