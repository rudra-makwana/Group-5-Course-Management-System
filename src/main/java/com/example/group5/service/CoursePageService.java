package com.example.group5.service;

import com.example.group5.DAO.IUserDao;
import com.example.group5.config.SpringConfig;
import com.example.group5.model.User;

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
            resultSet = SpringConfig.getObject().getDbConnection().executeQuery("Select * from Users");
        } catch (SQLException e) {
            e.printStackTrace();
            SpringConfig.getObject().getLogger().debug("DATABASE Connection ERROR..!");
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
}
