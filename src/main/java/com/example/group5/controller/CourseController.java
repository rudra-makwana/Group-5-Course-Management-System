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
    public void addCorse(@RequestBody Course courseName) {
        courseService.addCourse(courseName);
    }

    @GetMapping("course/getallcourses")
    public List<Course> selectAllCourses() {
        return courseService.getAllCourses();
    }
}
