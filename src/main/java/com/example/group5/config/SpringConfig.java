package com.example.group5.config;

import com.example.group5.controller.CoursePageController;
import com.example.group5.repository.DBConnection;
import com.example.group5.service.CoursePageService;
import com.example.group5.service.CourseService;
import com.example.group5.utils.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringConfig {
    private static SpringConfig springConfig = null;

    // DATABASE
    private DBConnection dbConnection = null;

    // SERVICES
    private CoursePageService coursePageService = null;
    private CourseService courseService = null;

    // CONTROLLER
    private CoursePageController coursePageController = null;

    // UTILS
    private MailUtil mailUtil = null;
    private Logger logger = null;

    public SpringConfig() {
        // DATABASE
        this.dbConnection = new DBConnection(
                (0 < -1) ? System.getenv("DATABASE_URL") : "jdbc:mysql://db-5308.cs.dal.ca:3306?serverTimezone=UTC&useSSL=false",
                (0 < -1) ? System.getenv("DATABASE_USER") : "CSCI5308_5_TEST_USER",
                (0 < -1) ? System.getenv("DATABASE_PASSWORD") : "CSCI5308_5_TEST_5570"
        );

        // SERVICES
        this.coursePageService = new CoursePageService();
        this.courseService = new CourseService();

        // CONTROLLER
        this.coursePageController = new CoursePageController();

        // UTILS
        this.mailUtil = new MailUtil();
        this.logger = LoggerFactory.getLogger(String.valueOf(this));
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public CoursePageController getCoursePageController() {
        return coursePageController;
    }

    public void setCoursePageController(CoursePageController coursePageController) {
        this.coursePageController = coursePageController;
    }

    public MailUtil getMailUtil() {
        return mailUtil;
    }

    public void setMailUtil(MailUtil mailUtil) {
        this.mailUtil = mailUtil;
    }

    public CoursePageService getCoursePageService() {
        return coursePageService;
    }

    public void setCoursePageService(CoursePageService coursePageService) {
        this.coursePageService = coursePageService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public static SpringConfig getObject(){
        if (springConfig == null){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}