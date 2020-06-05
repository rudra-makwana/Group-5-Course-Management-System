package com.example.group5.controller;

import com.example.group5.config.SpringConfig;
import com.example.group5.service.AssignInstructorService;
import com.example.group5.service.CourseService;
import com.example.group5.utility.CheckExistenceInDatabase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class AssignInstructorController {
    public AssignInstructorService assignInstructorService = SpringConfig.getObject().getAssignInstructorService();
    public CourseService courseService = SpringConfig.getObject().getCourseService();
    public CheckExistenceInDatabase assignInstructorCheckUser = SpringConfig.getObject().getCheckExistenceInDatabase();

    @GetMapping("/admincoursepage")
    public ModelAndView openAdminCoursePage(@RequestParam(name="cid") String courseId,ModelAndView modelAndView) {
        modelAndView = modelAndView.addObject("Users", assignInstructorService.getAllUsers());
        String courseName = courseService.getCourseName(courseId);
        modelAndView = modelAndView.addObject("CourseName",courseName);
        modelAndView = modelAndView.addObject("CourseID", courseId);
        modelAndView.setViewName("AdminCoursePage");
        return modelAndView;
    }

    @PostMapping("/admin/assigninstructor")
    public ModelAndView assignInstructor(@RequestParam(name = "instructorList") String bannerId, @RequestParam(name = "courseID") String courseID, ModelAndView modelAndView){
        int i = assignInstructorCheckUser.checkForExistingInstructor(bannerId, courseID);
        if(i == 1) {
            assignInstructorService.assignAsInstructor(bannerId, courseID);
            modelAndView.setViewName("SuccessPage");
            return modelAndView;
        }else{
            modelAndView.setViewName("ErrorPage");
            return modelAndView;
        }
    }

    @GetMapping("/users/fectchusers")
    public ModelAndView getUserList(ModelAndView modelAndView){
        modelAndView = modelAndView.addObject("usersText", "assignInstructorService.getAllUsers()");
        modelAndView.setViewName("AdminCoursePage");
        return modelAndView;
    }
}
