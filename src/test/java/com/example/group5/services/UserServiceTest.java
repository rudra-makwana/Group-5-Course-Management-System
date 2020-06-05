package com.example.group5.services;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.example.group5.DBConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * This is a Test class for UserService class.
 *@author Japnoor Kaur
 */
@TestInstance(Lifecycle.PER_CLASS)
class UserServiceTest {
	Statement statement=null;
	Connection connect=null;
	int resultSet ;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	ResultSet resultSet4 = null;
	ResultSet resultSet5 = null;


	UserService userService;
	DBConnection dbcon;

	@BeforeAll
	void setUp() {

		userService=new UserService();
		dbcon=new DBConnection();
	}

	/**
	 * This test is used to check whether user with the dummy details can be added in the database. 
	 * Later these details are removed from the database to avoid further processing conflicts.
	 *@author Japnoor Kaur
	 *
	 */
	@Test
	public void addUserTest() {
		String query="insert into CSCI5308_5_TEST.Users (bannerId, firstName, lastName, emailID, password) values('B00838540','Japnoor','Kaur','jp238553@dal.ca','abcd1234')";
		String  queryForCheckingResult="Select bannerId, firstName, lastName, emailID, password from CSCI5308_5_TEST.Users where bannerId='B00838540';" ;
		String  queryForBacktoState="Delete FROM CSCI5308_5_TEST.Users WHERE bannerId='B00838540';" ;
		String bannerId;
		String firstName;
		String lastName;
		String emailID;
		String password;
		try {
			dbcon.closeConnection(statement,connect);
			connect=dbcon.openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			resultSet = statement.executeUpdate(query);
			resultSet5=statement.executeQuery(queryForCheckingResult);

			resultSet5.next();
			bannerId=resultSet5.getString("bannerId");
			firstName=resultSet5.getString("firstName");
			lastName=resultSet5.getString("lastName");
			emailID=resultSet5.getString("emailID");
			password=resultSet5.getString("password");

			assertEquals("B00838540",bannerId);
			assertEquals("Japnoor",firstName);
			assertEquals("Kaur",lastName);
			assertEquals("jp238553@dal.ca",emailID);
			assertEquals("abcd1234",password);
			statement.executeUpdate(queryForBacktoState);
			dbcon.closeConnection(statement,connect);

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
	 * This test is used to validate user input email id for registration.
	 *@author Japnoor Kaur
	 */
	@Test
	public void validateEmailTest() {

		String expected="jp@kau.com";
		String notExpected="@jp.com";
		assertTrue(userService.validateEmail(notExpected));
		assertFalse(userService.validateEmail(expected));
	}
	/**
	 * This test is used to validate user input banner id for registration.
	 *@author Japnoor Kaur
	 */
	@Test
	public void validateBannerIdTest() {
		String expected="B7YU567";
		String notExpected="B09IUHJY8997HFVY";
		assertTrue(userService.validateBannerId(notExpected));
		assertFalse(userService.validateBannerId(expected));
	}
	/**
	 * This test is used to validate user input first name for registration.
	 *@author Japnoor Kaur
	 */
	@Test
	public void validateFirstNameTest() {
		String expected="Annie";
		String notExpected="Annie4563";
		assertTrue(userService.validateFirstName(notExpected));
		assertFalse(userService.validateFirstName(expected));

	}
	/**
	 * This test is used to validate user input last name for registration.
	 *@author Japnoor Kaur
	 */
	@Test
	public void validateLastNameTest() {
		String expected="Kaur";
		String notExpected="Annie63Hb";
		assertTrue(userService.validateLastName(notExpected));
		assertFalse(userService.validateLastName(expected));

	}
	/**
	 * This test is used to validate user input password for registration.
	 *@author Japnoor Kaur
	 */
	@Test
	public void validatePasswordTest() {
		String expected="lkhy567TFGHJK";
		assertFalse(userService.validatePassword(expected));
	}
	/**
	 * This test is used to check whether user with the same banner id already exists in the database by adding dummy values.
	 * Later these values are removed from the database to avoid further processing conflicts.
	 *@author Japnoor Kaur
	 *
	 */
	@Test
	public void bannerIdExistsTest() {
		String query="insert into CSCI5308_5_TEST.Users (bannerId, firstName, lastName, emailID, password) values('B00838699','Annie','Rangar','jp@dal.ca','abcd1234')";
		String  queryForFindingBannerId="Select bannerId from CSCI5308_5_TEST.Users where bannerId='B00838699';" ;
		String  queryForBacktoState="Delete FROM CSCI5308_5_TEST.Users WHERE bannerId='B00838699';" ;

		try {
			dbcon.closeConnection(statement,connect);
			connect=dbcon.openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			statement.executeUpdate(query);

			ResultSet resultSet2 = statement.executeQuery(queryForFindingBannerId);
			assertTrue(resultSet2!=null);
			statement.executeUpdate(queryForBacktoState);
			dbcon.closeConnection(statement, connect);
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
	 * This test is used to check whether user with the same email id already exists in the database by adding dummy values.
	 * Later these values are removed from the database to avoid further processing conflicts.
	 *@author Japnoor Kaur
	 *
	 */
	@Test
	public void userExistsTest() {
		String query="insert into CSCI5308_5_TEST.Users (bannerId, firstName, lastName, emailID, password) values('B0099994','Isha','Kaur','ish@dal.ca','abcd1234')";
		String  queryForFindingEmailId="Select emailID from CSCI5308_5_TEST.Users where emailID='ish@dal.ca';" ;
		String  queryForBacktoState="Delete FROM CSCI5308_5_TEST.Users WHERE bannerId='B0099994';" ;

		try {
			dbcon.closeConnection(statement,connect);
			connect=dbcon.openConnection();
			statement = connect.createStatement();
			statement.executeQuery("use CSCI5308_5_TEST;");
			statement.executeUpdate(query);

			ResultSet resultSet4 = statement.executeQuery(queryForFindingEmailId);
			assertTrue(resultSet4!=null);
			statement.executeUpdate(queryForBacktoState);
			dbcon.closeConnection(statement, connect);
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

}

