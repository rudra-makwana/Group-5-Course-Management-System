package com.example.group5.controller;

import com.example.group5.configure.SpringConfig;
import com.example.group5.model.User;
import com.example.group5.service.AssignInstructorService;
import com.example.group5.service.CourseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping
public class AssignInstructorController {
    public AssignInstructorService assignInstructorService = SpringConfig.getObject().getAssignInstructorService();
    public CourseService courseService = SpringConfig.getObject().getCourseService();

    @GetMapping("/admincoursepage")
    public ModelAndView openAdminCoursePage(@RequestParam(name="cid") String courseId,ModelAndView modelAndView) {
        modelAndView = modelAndView.addObject("Users", assignInstructorService.getAllUsers());
        String courseName = courseService.getCourseName(courseId);
        modelAndView = modelAndView.addObject("CourseName",courseName);
        modelAndView.setViewName("AdminCoursePage");
        return modelAndView;
    }

    @PostMapping("/admin/assigninstructor")
    public void assignInstructor(User user, String courseID){
        assignInstructorService.assignAsInstructor(user, courseID);
    }

    @GetMapping("/users/fectchusers")
    public ModelAndView getUserList(ModelAndView modelAndView){
        modelAndView = modelAndView.addObject("usersText", "assignInstructorService.getAllUsers()");
        modelAndView.setViewName("AdminCoursePage");
        return modelAndView;
    }
}
