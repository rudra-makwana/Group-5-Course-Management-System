package com.example.group5.model;

public class RegisteredCourses {
    private String courseID;
    private String bannerID;
    private int roleID;
    private String roleType;
    private String courseName;

    public RegisteredCourses(String courseID, String bannerID, int roleID ,String roleType, String courseName) {
        this.courseID = courseID;
        this.bannerID = bannerID;
        this.roleID = roleID;
        this.roleType = roleType;
        this.courseName = courseName;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
