package com.example.group5.config;

public class SystemConfig {

    private static SystemConfig systemConfig = null;
    private String DATABASE_URL;
    private String DATABASE_USERNAME;
    private String DATABASE_Password;

    public SystemConfig(String DATABASE_URL, String DATABASE_USERNAME, String DATABASE_Password) {
        this.DATABASE_URL = DATABASE_URL;
        this.DATABASE_USERNAME = DATABASE_USERNAME;
        this.DATABASE_Password = DATABASE_Password;
    }

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public void setDATABASE_URL(String DATABASE_URL) {
        this.DATABASE_URL = DATABASE_URL;
    }

    public String getDATABASE_USERNAME() {
        return DATABASE_USERNAME;
    }

    public void setDATABASE_USERNAME(String DATABASE_USERNAME) {
        this.DATABASE_USERNAME = DATABASE_USERNAME;
    }

    public String getDATABASE_Password() {
        return DATABASE_Password;
    }

    public void setDATABASE_Password(String DATABASE_Password) {
        this.DATABASE_Password = DATABASE_Password;
    }

    public static SystemConfig getInstance(){
        if (systemConfig == null){
            systemConfig = new SystemConfig(
                    (0 < System.getenv("DATABASE_URL").length()) ? System.getenv("DATABASE_URL") : "db-5308.cs.dal.ca",
                    (0 < System.getenv("DATABASE_USER").length()) ? System.getenv("DATABASE_USER") : "CSCI5308_5_TEST_USER",
                    (0 < System.getenv("DATABASE_PASSWORD").length()) ? System.getenv("DATABASE_PASSWORD") : "CSCI5308_5_TEST_5570");
        }
        return SystemConfig.systemConfig;
    }

}