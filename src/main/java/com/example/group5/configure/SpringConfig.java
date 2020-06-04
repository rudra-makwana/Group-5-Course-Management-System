package com.example.group5.configure;

import com.example.group5.model.Course;
import com.example.group5.service.AssignInstructorService;
import com.example.group5.service.CourseService;
import com.example.group5.utility.CheckExistenceInDatabase;

public class SpringConfig {


    private static SpringConfig springConfig = null;
    private CourseService courseService;
    private AssignInstructorService assignInstructorService;
    private CheckExistenceInDatabase checkExistenceInDatabase;

    public SpringConfig(){
        assignInstructorService = new AssignInstructorService();
        checkExistenceInDatabase = new CheckExistenceInDatabase();
        courseService = new CourseService();
    }

    public CheckExistenceInDatabase getCheckExistenceInDatabase() {
        return checkExistenceInDatabase;
    }

    public void setCheckExistenceInDatabase(CheckExistenceInDatabase checkExistenceInDatabase) {
        this.checkExistenceInDatabase = checkExistenceInDatabase;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public AssignInstructorService getAssignInstructorService() {
        return assignInstructorService;
    }

    public void setAssignInstructorService(AssignInstructorService assignInstructorService) {
        this.assignInstructorService = assignInstructorService;
    }

    public static SpringConfig getObject(){
        if(springConfig == null ){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}