package com.example.group5;

import java.sql.Connection;
import java.sql.Statement;

/**
 * This is an interface for establishing and closing database connection
 * @author Japnoor Kaur
 *
 */
public interface IDBConnection {
	public Connection openConnection();
	public void closeConnection(Statement st, Connection con);
}
