package com.example.group5.config;

import com.example.group5.repository.DBConnection;

public class SpringConfig {
    private static SpringConfig springConfig = null;
    private DBConnection dbConnection = null;

    public SpringConfig() {
        this.dbConnection = new DBConnection(
                (0 < System.getenv("DATABASE_URL").length()) ? System.getenv("DATABASE_URL") : "db-5308.cs.dal.ca",
                (0 < System.getenv("DATABASE_USER").length()) ? System.getenv("DATABASE_USER") : "CSCI5308_5_TEST_USER",
                (0 < System.getenv("DATABASE_PASSWORD").length()) ? System.getenv("DATABASE_PASSWORD") : "CSCI5308_5_TEST_5570"
        );
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public static SpringConfig getObject(){
        if (springConfig == null){
            springConfig = new SpringConfig();
        }
        return SpringConfig.springConfig;
    }
}