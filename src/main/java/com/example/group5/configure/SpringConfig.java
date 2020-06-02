package com.example.group5.configure;

import com.example.group5.dao.CourseDaoImplementation;

public class SpringConfig {


    private static SpringConfig springConfig = null;
    private CourseDaoImplementation courseDataAccessService;

    public SpringConfig(){

        courseDataAccessService = new CourseDaoImplementation();
    }

    public CourseDaoImplementation getCourseDataAccessService() {
        return courseDataAccessService;
    }

    public void setCourseDataAccessService(CourseDaoImplementation courseDataAccessService) {
        this.courseDataAccessService = courseDataAccessService;
    }

    public static SpringConfig getObject(){
        if(springConfig == null ){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}