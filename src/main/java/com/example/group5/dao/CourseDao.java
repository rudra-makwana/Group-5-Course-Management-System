package com.example.group5.dao;

import com.example.group5.model.Course;

import java.util.List;

public interface CourseDao {

    void insertCourse(Course course);

    void deleteCourse(Course course);

    String getCourseName(String courseId);

    List<Course> getRegisteredCourses(String bannerId);

    List<Course> selectAllCourses();
}
