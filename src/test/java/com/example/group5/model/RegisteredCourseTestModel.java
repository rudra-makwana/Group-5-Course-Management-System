package com.example.group5.model;

public class RegisteredCourseTestModel {
    private String courseId;
    private String bannerId;
    private int role;

    public RegisteredCourseTestModel(String courseId, String bannerId, int role) {
        this.courseId = courseId;
        this.bannerId = bannerId;
        this.role = role;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
