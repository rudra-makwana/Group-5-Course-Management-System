package com.example.group5.controller;


import com.example.group5.config.SpringConfig;
import com.example.group5.model.Course;
import com.example.group5.service.CourseService;
import com.example.group5.utility.CheckExistenceInDatabase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    private CourseService courseService = SpringConfig.getObject().getCourseService();
    private CheckExistenceInDatabase checkExistenceInDatabase = SpringConfig.getObject().getCheckExistenceInDatabase();

    @GetMapping("/admindashboard")
    public ModelAndView openAdminDashboard(ModelAndView modelAndView) {
        modelAndView = modelAndView.addObject("Courses", courseService.selectAllCourses());
        modelAndView.setViewName("AdminDashboard");
        return modelAndView;
    }

    @GetMapping("/coursecreation")
    public ModelAndView openCourseAdditionPage(ModelAndView modelAndView){
        modelAndView.setViewName("CourseCreation");
        return modelAndView;
    }

    @PostMapping("course/addcourse")
    public ModelAndView addCourse(@RequestParam(value = "CourseID") String courseID,
                                  @RequestParam(value = "CourseName") String courseName,
                                  ModelAndView modelAndView) {
        //ModelAndView modelAndView = new ModelAndView();
        Course course = new Course(courseID, courseName);
        int checkCourse = checkExistenceInDatabase.checkForExistingCourse(courseID);
        if (checkCourse == 1) {
            courseService.insertCourse(course);
            modelAndView.setViewName("SuccessPage");
        }
        else {
            modelAndView.setViewName("ErrorPage");
        }
        return modelAndView;
    }

    @GetMapping("courses/deletecourse")
    public ModelAndView deleteCourse(@RequestParam(value = "cid") String courseID, ModelAndView modelAndView){
        int check = checkExistenceInDatabase.checkForExistingCourse(courseID);
        if(check == 0) {
            courseService.deleteCourse(courseID);
            modelAndView.setViewName("SuccessPage");
        }else {
            modelAndView.setViewName("ErrorPage");
        }
        return modelAndView;
    }
}
