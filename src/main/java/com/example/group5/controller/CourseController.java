package com.example.group5.controller;


import com.example.group5.model.Course;
import com.example.group5.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    private CourseService courseService = new CourseService();

    @PostMapping("course/addcourse")
    public void addCourse(@RequestBody Course course) {
        courseService.insertCourse(course);
    }

    @DeleteMapping("courses/deletecourse")
    public void deleteCourse(@RequestBody Course course){
        courseService.deleteCourse(course);
    }

    @GetMapping("course/getallcourses")
    public List<Course> selectAllCourses() {
        return courseService.selectAllCourses();
    }
}
