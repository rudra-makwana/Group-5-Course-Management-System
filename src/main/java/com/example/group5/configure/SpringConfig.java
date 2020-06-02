package com.example.group5.configure;

import com.example.group5.dao.CourseDaoImplementation;

public class SpringConfig {


    private static SpringConfig springConfig = null;
    private CourseDaoImplementation courseDataAccessService;

    private final String url;
    private final String courseTableName;
    private final String username;
    private final String password;

    public SpringConfig(){
        url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_5_TEST";
        courseTableName = "CSCI5308_5_TEST.courses";
        username="CSCI5308_5_TEST_USER";
        password="CSCI5308_5_TEST_5570";
        courseDataAccessService = new CourseDaoImplementation();
    }

    public CourseDaoImplementation getCourseDataAccessService() {
        return courseDataAccessService;
    }

    public void setCourseDataAccessService(CourseDaoImplementation courseDataAccessService) {
        this.courseDataAccessService = courseDataAccessService;
    }

    public String getUrl() {
        return url;
    }

    public String getCourseTableName() {
        return courseTableName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static SpringConfig getObject(){
        if(springConfig == null ){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}