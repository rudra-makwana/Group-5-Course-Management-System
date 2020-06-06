package com.example.group5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

/**
 * This is test class for DBConnection class
 * @author Japnoor Kaur
 *
 */
public class DBConnectionTest extends DBConnection{
	private Statement st=null;
	private Connection con=null;

	/**
	 * This is test for establishing database connection
	 * @author Japnoor Kaur
	 *
	 */
	@Test
	public void testOpenConnection() {
		DBConnection dbConnection = new DBConnection();
		Connection expected= dbConnection.openConnection();
		assertEquals(expected!=null, true);
	}
	/**
	 * This is test for closing database connection
	 * @author Japnoor Kaur
	 *
	 */
	@Test
	public void testCloseConnection() {
		DBConnection dbConnection = new DBConnection();
		dbConnection.closeConnection(st,con);
		assertEquals(st!=null, false);
		assertEquals(con!=null, false);

	}
}
