package com.example.group5.configure;

import com.example.group5.service.AssignInstructorService;
import com.example.group5.service.CourseService;

public class SpringConfig {


    private static SpringConfig springConfig = null;
    private CourseService courseService;
    private AssignInstructorService assignInstructorService;

    public SpringConfig(){
        assignInstructorService = new AssignInstructorService();
        courseService = new CourseService();
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