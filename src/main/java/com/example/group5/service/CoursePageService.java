package com.example.group5.service;

import com.example.group5.DAO.IUserDao;
import com.example.group5.config.SpringConfig;
import com.example.group5.model.User;
import com.example.group5.repository.DBConnection;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursePageService implements IUserDao {

    @Override
    public List<User> fetchUserList() {
        ArrayList<User> userList = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = SpringConfig.getObject().getDbConnection().executeQuery("select u.bannerId, u.firstName, u.lastName, u.emailID, u.password from Users as u " +
                    "join courseRegistration as c " +
                    "where u.bannerId = c.userId " +
                    "GROUP BY u.bannerId;");
        } catch (SQLException e) {
            e.printStackTrace();
            SpringConfig.getObject().getLogger().debug("Query processing ERROR..!");
        }
        try{
            if (resultSet != null) {
                while (resultSet.next()){
                    userList.add(new User(
                            resultSet.getString("bannerID"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("emailID"),
                            resultSet.getString("password")
                    ));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            SpringConfig.getObject().getLogger().debug("DATABASE Connection ERROR..!");
        }
        return userList;
    }

    // Instructor
    public boolean registerStudents(String courseID, MultipartFile file) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                try {
                    ResultSet resultSet = SpringConfig.getObject().getDbConnection().executeQuery("select u.* from Users as u " +
                            "join courseRegistration as c " +
                            "where u.bannerId = c.userId and " +
                            "u.bannerId = '" + nextRecord[0] + "' and " +
                            "c.userId = '" + courseID + "';");
                    while (resultSet.next()){
                        if(!(resultSet.getRow() > 0)){
                            ResultSet rs = SpringConfig.getObject().getDbConnection().executeQuery("select * from Users where bannerId = '" + nextRecord[0] + "'");
                            while(rs.next()){
                                if(rs.getString("bannerId").length() > 0){
                                    SpringConfig.getObject().getDbConnection().executeQuery("update courseRegistration " +
                                            "set roleId = 1 " +
                                            "where userId = '" + nextRecord[0] + "'");
                                    SpringConfig.getObject().getMailUtil().sendmail(nextRecord[3],   courseID + " Registration", "<h3> hurray..! you have been added to this course </h3>");
                                } else {
                                    SpringConfig.getObject().getDbConnection().executeQuery("insert into Users value('"+ nextRecord[0] + "', '" + nextRecord[2] + "', '" + nextRecord[1] + "', '" + nextRecord[3] +  "', '" + nextRecord[0] + "', 'N');");
                                    SpringConfig.getObject().getDbConnection().executeQuery("insert into courseRegistration value('" + courseID +"', '" + nextRecord[0] + "', '" + 3 + "');");
                                    try {
                                        SpringConfig.getObject().getMailUtil().sendmail(nextRecord[3],   " User Created", "<h3> hurray..! your password is: " + nextRecord[0] +  " </h3>");
                                        SpringConfig.getObject().getMailUtil().sendmail(nextRecord[3],   courseID + " Registration", "<h3> hurray..! you have been added to this course </h3>");
                                    } catch (MessagingException e) {
                                        e.printStackTrace();
                                        return false;
                                    }
                                }
                            }
                        } else {
                            try {
                                // only mail
                                SpringConfig.getObject().getMailUtil().sendmail(nextRecord[3],   courseID + " Registration", "<h3> hurray..! you have been added to this course </h3>");
                            } catch (MessagingException e) {
                                e.printStackTrace();
                                return false;
                            }
                        }
                    }
                } catch (SQLException | MessagingException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // TA
    public boolean makeStudentTA(String courseID, String studentID) {
        ResultSet resultSet = null;

        try {
            if(!SpringConfig.getObject().getDbConnection().executeQuery("select * from Users as u " +
                    "join courseRegistration as c " +
                    "where u.bannerId = c.userId and c.roleId = 2 and c.courseId = '" + courseID + "' and u.bannerId = '" + studentID + "';").isBeforeFirst()){
                return false;
            } else {
                if(!SpringConfig.getObject().getDbConnection().executeQuery("select * from Users as u " +
                        "join courseRegistration as c " +
                        "where u.bannerId = c.userId and c.roleId = 3 and c.courseId = '" + courseID + "' and u.bannerId = '" + studentID + "';").isBeforeFirst()){

                    SpringConfig.getObject().getDbConnection().executeQuery("update courseRegistration " +
                            "set roleId = 2 " +
                            "where userId =  '" + studentID + "';");
                    return true;
                } else {
                    SpringConfig.getObject().getDbConnection().executeQuery("insert into courseRegistration " +
                            "value('"+ courseID +"', '" + studentID + "', '2');");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
