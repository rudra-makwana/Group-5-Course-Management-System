package com.example.group5.dao;

import com.example.group5.model.Course;

import java.util.List;

public interface CourseDao {

    void insertCourse(Course course);

    List<Course> selectAllCourses();
}
