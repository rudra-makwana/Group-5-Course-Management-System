package com.example.group5.controller;


import com.example.group5.configure.SpringConfig;
import com.example.group5.model.Course;
import com.example.group5.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    private CourseService courseService = SpringConfig.getObject().getCourseService();

    @GetMapping("/admindashboard")
    public ModelAndView openAdminDashboard(ModelAndView modelAndView) {
        modelAndView = modelAndView.addObject("Courses", courseService.selectAllCourses());
        modelAndView.setViewName("AdminDashboard");
        return modelAndView;
    }

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

    @GetMapping("course/getregisteredcourse")
    public List<Course> getRegisteredCourses(String bannerId){
        return courseService.getRegisteredCourses(bannerId);
    }
}
