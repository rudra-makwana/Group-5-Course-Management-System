package com.example.group5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * This is class for establishing and closing database connection
 * @author Japnoor Kaur
 *
 */
public class DBConnection implements IDBConnection{
	private Connection connect = null;     

	/**
	 * This is method for establishing database connection
	 * @author Japnoor Kaur
	 *
	 */
	public Connection openConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect= DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306?serverTimezone=UTC&useSSL=false", "CSCI5308_5_TEST_USER", "CSCI5308_5_TEST_5570");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("couldn't connect!");
		}
		return connect;
	}
	/**
	 * This is class for closing database connection
	 * @param st This is a statement type variable
	 * @param con This is a connection type variable
	 * @author Japnoor Kaur
	 *
	 */
	public void closeConnection(Statement st, Connection con){
		try {

			if (st != null) {
				st.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}


