package com.example.group5.service;

import com.example.group5.configure.SpringConfig;
import com.example.group5.dao.CourseDaoImplementation;
import com.example.group5.injector.courseServiceInjector;
import com.example.group5.model.Course;

import java.util.List;

public class CourseService implements courseServiceInjector {
    public CourseDaoImplementation courseDataAccessService = SpringConfig.getObject().getCourseDataAccessService();

    @Override
    public void addCourse(Course course) {
        courseDataAccessService.insertCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDataAccessService.selectAllCourses();
    }
}
