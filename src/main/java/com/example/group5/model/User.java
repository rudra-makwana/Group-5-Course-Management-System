package com.example.group5.model;

import com.example.group5.DAO.ICsvFileDao;
import com.example.group5.DAO.IUserDao;
import com.example.group5.config.SpringConfig;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class User {
    private String bannerID;
    private String firstName;
    private String lastName;
    private String emailID;
    private String password;

    public User(String bannerID, String firstName, String lastName, String emailID, String password) {
        this.bannerID = bannerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
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
