package com.example.group5.controller;

import com.example.group5.config.SpringConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CoursePageController {

    @RequestMapping("/course-page")
    public String openCoursePage(@RequestParam(name = "c_id") String course_id,
                                 @RequestParam(name = "bannerId") String bannerID,
                                 @RequestParam(name = "roleId", defaultValue="3") Integer roleID, Model model) {

        model.addAttribute("Error", false);
        model.addAttribute("c_id", course_id);
        switch (roleID){
            case 1:
                model.addAttribute("Instructor", true);
                model.addAttribute("TA", false);
                model.addAttribute("Student", false);
                model.addAttribute("userList", SpringConfig.getObject().getCoursePageService().fetchUserList());
                break;
            case 2:
                model.addAttribute("Instructor", false);
                model.addAttribute("TA", true);
                model.addAttribute("Student", false);
                break;
            case 3:
                model.addAttribute("Instructor", false);
                model.addAttribute("TA", false);
                model.addAttribute("Student", true);
                model.addAttribute("courseID", course_id);
                model.addAttribute("courseName", SpringConfig.getObject().getCourseService().getCourseName(course_id));
                break;
            default:
                model.addAttribute("Instructor", false);
                model.addAttribute("TA", false);
                model.addAttribute("Student", false);
                model.addAttribute("Error", true);
        }
        return "course-page";
    }

    @RequestMapping(value = "/assign-TA", method = RequestMethod.POST)
    public String assignTa(@RequestParam(name = "assignedTA") Object studentID, @RequestParam(name = "c_id") String courseID, Model model){
        if(SpringConfig.getObject().getCoursePageService().makeStudentTA(courseID, (String) studentID)){
            model.addAttribute("error", false);
        } else {
            model.addAttribute("error",false);
        }
        return "Ta-assign-success";
    }

    @GetMapping("/file-upload-status")
    public String openStatusPage(Model model) {
        return "file-upload-status";
    }

    @PostMapping("/course-page/fetchCSV")
    public String fetchCSVForm(@RequestParam(name = "c_id") String course_id,
                               @RequestParam("file") MultipartFile file, Model model) {
        if(SpringConfig.getObject().getCoursePageService().registerStudents(course_id, file)){
            model.addAttribute("status", true);
        } else{
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }
        return "file-upload-status";
    }
}