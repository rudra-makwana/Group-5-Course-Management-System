package com.example.group5.model;

public class InstructorUser {
    private String bannerID;
    private String firstName;
    private String lastName;
    private String emailID;
    private String password;

    public InstructorUser(String bannerID, String firstName, String lastName, String emailID, String password) {
        this.bannerID = bannerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
    }

    public InstructorUser(String bannerID, String firstName, String lastName) {
        this.bannerID = bannerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
