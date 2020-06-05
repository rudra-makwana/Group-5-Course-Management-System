package com.example.group5.repository;

import java.sql.*;
/**
 * This is the main database class to provide all the connection and performing sql queries.
 * Due to issues connection to database it is moved to procedure level.
 * which is not a good practice but temporary it will be enough to serve the purpose.
 */
public class DBConnection {

    private Statement statement;
    private Connection connection;

    public DBConnection(String dbURL, String dbUser, String dbPass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        statement.executeQuery("use CSCI5308_5_TEST");
        return statement.executeQuery(query);
    }

    public void closeConnection(){
        try {
            if (null != statement) statement.close();
            if (null != connection) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}