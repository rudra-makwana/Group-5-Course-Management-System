package com.example.group5.utils;

import java.util.HashMap;

/**
 * This Class does not serve any purpose in the CODE.
 * This was created to provide abstraction to the SQL Queries of the project.
 * But it is dropped.
 */
public class SqlQueries {

    private static HashMap<String, String> sqlQueries = new HashMap<String, String>(){
        {
            putIfAbsent("Use Database", "use CSCI_5308_5_TEST");
            putIfAbsent("Fetch all courses", "Select * from courses");
        }
    };

    public static HashMap<String, String> getSqlQueries() {
        return sqlQueries;
    }
}