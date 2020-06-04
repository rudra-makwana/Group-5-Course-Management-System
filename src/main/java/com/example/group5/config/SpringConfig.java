package com.example.group5.config;

import com.example.group5.repository.DBConnection;
import com.example.group5.service.CoursePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;

import java.sql.DriverManager;

public class SpringConfig {
    private static SpringConfig springConfig = null;
    private DBConnection dbConnection = null;

    private CoursePageService coursePageService = null;

    private Logger logger = null;

    public SpringConfig() {
        this.dbConnection = new DBConnection(
                (0 < -1) ? System.getenv("DATABASE_URL") : "jdbc:mysql://db-5308.cs.dal.ca:3306?serverTimezone=UTC&useSSL=false",
                (0 < -1) ? System.getenv("DATABASE_USER") : "CSCI5308_5_TEST_USER",
                (0 < -1) ? System.getenv("DATABASE_PASSWORD") : "CSCI5308_5_TEST_5570"
        );
        this.coursePageService = new CoursePageService();
        this.logger = LoggerFactory.getLogger(String.valueOf(this));
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