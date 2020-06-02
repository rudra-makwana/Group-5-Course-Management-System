package com.example.group5.injector;

import com.example.group5.model.Course;

import java.util.List;

public interface courseServiceInjector {

    void addCourse(Course course);

    List<Course> getAllCourses();

}
