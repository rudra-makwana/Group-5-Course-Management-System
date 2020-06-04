package com.example.group5.controller;

import com.example.group5.config.SpringConfig;
import com.example.group5.utils.MailUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.*;
import java.util.Properties;

@Controller
public class CoursePageController {

    @RequestMapping("/course-page")
    public String openCoursePage(@RequestParam(name = "c_id") String course_id,
                                 @RequestParam(name = "bannerId") String bannerID,
                                 @RequestParam(name = "roleId", defaultValue="3") Integer roleID, Model model) {

        model.addAttribute("Error", false);
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
    public String assignTa(@RequestParam(name = "assignedTA") Object studentID, @RequestParam(name = "C_ID") String courseID, Model model){
        if(SpringConfig.getObject().getCoursePageService().makeStudentTA(courseID, studentID)){
            model.addAttribute("error", false);
        } else {
            model.addAttribute("error",true);
        }
        return "Ta-assign";
    }

    @GetMapping("/file-upload-status")
    public String openStatusPage(Model model) {
        return "file-upload-status";
    }

    @PostMapping("/course-page/fetchCSV")
    public String fetchCSVForm(@RequestParam("file") MultipartFile file, Model model) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            CSVReader csvReader = new CSVReader(reader);
            System.out.println(reader);

            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Course : " + nextRecord[1]);
                System.out.println("Email : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("==========================");
            }
//            model.addAttribute("users", users);
            model.addAttribute("status", true);
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }
        return "file-upload-status";
    }
}