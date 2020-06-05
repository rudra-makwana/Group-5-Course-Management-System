package com.example.group5.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.group5.model.User;
import org.springframework.stereotype.Service;

import com.example.group5.DBConnection;
import com.example.group5.model.User;

/*
 Created by Chetanpreet Singh Sachdeva
 */

@Service
public class LoginService  {

	private Connection connect = null;
	private  Statement statement = null;
	public String findUser(User user) {
		String sql ="Select emailID,password,isAdmin from CSCI5308_5_TEST.Users where emailID='"+user.getEmailID()+"' and password='"+user.getPassword()+"';";
		String rs="";
		String adminemail = "";
		String isAdmin = "N";
		
		
		try {
			
			//Establishing DB connection
			DBConnection db =  new DBConnection();
			connect = db.openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			ResultSet resultSet = statement.executeQuery(sql);    //Query executed

			if(resultSet.next())            //Fetching results from resultSET
			{
				if(resultSet.getString("isAdmin").equals("Y"))     //if user is admin
					rs = "admin";
				else
					rs= "noadmin";                     //if user is not admin
			}
			else
				rs = "loginError";                     //if user is not present

			db.closeConnection(statement,connect);      //close db instance
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			// Always close connections, otherwise the MySQL database runs out of them.
			// Close any of the resultSet, statements, and connections that are open and holding resources.
			try {

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return rs;


	}
}