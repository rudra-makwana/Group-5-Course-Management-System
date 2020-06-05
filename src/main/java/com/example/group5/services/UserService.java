package com.example.group5.services;

import com.example.group5.DBConnection;
import com.example.group5.model.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a Service class for user registration
 * @author Japnoor Kaur
 *
 */
@Service
public class UserService extends DBConnection implements IUserExists, IUserValidate, IUserRegister{

	Connection connect = null;     
	Statement statement=null;   

	private static  int resultSet ;   
	private ResultSet resultSet1 = null; 
	private ResultSet resultSet2 = null; 

	String queryForFindingUser;
	String queryForFindingBannerId;
	public UserService() {
	}


	/**
	 * This method is used to add users, who are registering, in the database.
	 *@author Japnoor Kaur
	 *@param user This is an object of User class
	 *@return nothing
	 *
	 */
	public void addUser(User user) {

		String query="insert into CSCI5308_5_TEST.Users (bannerId, firstName, lastName, emailID, password) values('"+user.getBannerID()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmailID()+"','"+user.getPassword()+"')";
		try {
			closeConnection(statement,connect);
			connect=openConnection();

			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			resultSet = statement.executeUpdate(query);
			closeConnection(statement,connect);

		}
		catch(Exception e) {
			System.out.println(e.getMessage());

		}
		finally {
			// Always close connections, otherwise the MySQL database runs out of them.

			// Close any of the statements, and connections that are open and holding resources.
			try {

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	/**
	 * This method is used to validate user input email id for registration.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if there is some error in validation
	 *
	 */
	public boolean validateEmail(String str) {
		boolean flag=false;

		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);

		if(!matcher.matches()) {
			flag=true;  

		}

		return flag;
	}
	/**
	 * This method is used to validate user input banner id for registration.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if there is some error in validation
	 *
	 */
	public boolean validateBannerId(String str) {
		boolean flag=false;

		if(str==null || str.isEmpty()) {
			flag=true;
		}
		if(str.length()<5||str.length()>9) {	  
			flag=true;
		}

		return flag;
	}
	/**
	 * This method is used to validate user input first name for registration.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if there is some error in validation
	 *
	 */
	public boolean validateFirstName(String str) {
		boolean flag=false;
		for(int i=0;i<str.length();i++) {
			if(!(Character.isLetter(str.charAt(i)))) {
				return true;
			}
		}
		if(str==null || str.isEmpty()) {
			flag=true;
		}
		return flag;

	}
	/**
	 * This method is used to validate user input last name for registration.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if there is some error in validation
	 *
	 */
	public boolean validateLastName(String str) {

		boolean flag=false;
		for(int i=0;i<str.length();i++) {
			if(!(Character.isLetter(str.charAt(i)))) {
				return true;
			}
		}
		if(str==null || str.isEmpty()) {
			flag=true;
		}
		return flag;

	}
	/**
	 * This method is used to validate user input password for registration.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if there is some error in validation
	 *
	 */
	public boolean validatePassword(String str) {
		boolean flag=false;
		if(str==null || str.isEmpty()) {
			flag=true;
		}
		if(str.length()<5||str.length()>15) {	  
			flag=true;
		}

		return flag;
	}

	/**
	 * This method is used to check whether user with same banner id exists in database.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if user with same banner id already exists.
	 *
	 */
	public boolean bannerIdExists(String str) {
		boolean flag1=false;

		queryForFindingBannerId="Select bannerId from CSCI5308_5_TEST.Users where bannerId='"+str+"';" ;
		try {
			closeConnection(statement,connect);
			connect= openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			resultSet2 = statement.executeQuery(queryForFindingBannerId);

			if(resultSet2.next()) {
				flag1=true;
			}
			closeConnection(statement,connect);

		}
		catch(Exception e) {
			System.out.println(e.getMessage());	  
		}
		finally {
			// Always close connections, otherwise the MySQL database runs out of them.

			// Close any of the statements, and connections that are open and holding resources.
			try {

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return flag1;
	}
	
	/**
	 * This method is used to check whether user with same email id exists in database.
	 *@author Japnoor Kaur
	 *@param str This is a string type variable
	 *@return boolean Returns the value of flag as true if user with same banner id already exists.
	 *
	 */
	public boolean userExists(String str) {
		boolean flag1=false;

		queryForFindingUser="Select emailID from CSCI5308_5_TEST.Users where emailID='"+str+"';" ;
		try {
			closeConnection(statement,connect);
			connect= openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			resultSet1 = statement.executeQuery(queryForFindingUser);

			if(resultSet1.next()) {
				flag1=true;
			}
			closeConnection(statement,connect);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());	  
		}
		finally {
			// Always close connections, otherwise the MySQL database runs out of them.

			// Close any of the statements, and connections that are open and holding resources.
			try {

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}



		return flag1;
	}

}
