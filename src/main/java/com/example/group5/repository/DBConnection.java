package com.example.group5.repository;

import java.sql.*;
/**
 * This is the main database class to provide all the connection and performing sql queries.
 * Due to issues connection to database it is moved to procedure level.
 * which is not a good practice but temporary it will be enough to serve the purpose.
 */
public class DBConnection {

    private String dbURL;
    private String dbUser;
    private String dbPass;

    public DBConnection(String dbURL, String dbUser, String dbPass) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection(dbURL, dbUser, dbPass);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        statement.close();
        connection.close();
        return resultSet;
    }

    public Connection getConnection(String dbURL, String dbUser, String dbPass) throws SQLException {
        return DriverManager.getConnection(dbURL, dbUser, dbPass);
    }
}