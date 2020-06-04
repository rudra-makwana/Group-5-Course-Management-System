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

    Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @RequestMapping("/course-page")
    public String openCoursePage(@RequestParam(name = "user_role", required=false, defaultValue="1") Integer role , Model model) {
        model.addAttribute("userList", SpringConfig.getObject().getCoursePageService().fetchUserList());
        return "course-page";
    }

    @RequestMapping(value = "/assign-TA", method = RequestMethod.POST)
    public String assignTa(@RequestParam(name = "assignedTA", required=false) Object student, Model model){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        MailUtil mailUtil = new MailUtil();
        try {
            mailUtil.sendmail("krutin@dal.ca", "test", "<h1>test</h1> <b>yey</b> <strong>works!!</strong>");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("bannerID", student);
        return "Ta-assign-success";
    }

    @RequestMapping("/course-page/assign-TA/TA-assign-success")
    public String assignTaSuccess(Model model){
        return "TA-assign-success";
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
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "file-upload-status";
    }
}