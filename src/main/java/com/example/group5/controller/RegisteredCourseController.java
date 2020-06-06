package com.example.group5.controller;

import com.example.group5.config.SpringConfig;
import com.example.group5.model.Course;
import com.example.group5.model.RegisteredCourses;
import com.example.group5.service.CourseService;
import com.example.group5.service.RegisteredCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class RegisteredCourseController {

    RegisteredCourseService registeredCourseService = SpringConfig.getObject().getRegisteredCourseService();
    CourseService courseService = SpringConfig.getObject().getCourseService();

    @GetMapping("/userdashboard")
    public ModelAndView getRegisteredCourses(@RequestParam(name = "bannerid") String bannerId, ModelAndView modelAndView){
        List<RegisteredCourses> registeredCourses = registeredCourseService.getRegisteredCourse(bannerId);

        if(registeredCourses.isEmpty()){
            modelAndView = modelAndView.addObject("Courses", courseService.selectAllCourses());
            modelAndView.setViewName("GuestUserLandingPage");
            return modelAndView;
        }
        modelAndView = modelAndView.addObject("Courses", registeredCourses);
        modelAndView.setViewName("RegisteredUserLandingPage");
        return modelAndView;
    }
}
