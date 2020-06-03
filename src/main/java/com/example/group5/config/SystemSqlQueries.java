package com.example.group5.config;

import com.example.group5.utils.SqlQueries;

import java.util.Map;

public class SystemSqlQueries {

    private static SystemSqlQueries systemSqlQueries = null;

    private Map<String, String> SQLQuery;


    public SystemSqlQueries() {
        SQLQuery = SqlQueries.getSqlQueries();
    }

    public Map<String, String> getSQLQuery() {
        return SQLQuery;
    }

    public void setSQLQuery(Map<String, String> SQLQuery) {
        this.SQLQuery = SQLQuery;
    }

    public static SystemSqlQueries getInstance(){
        if (systemSqlQueries == null){
            systemSqlQueries = new SystemSqlQueries();
        }
        return SystemSqlQueries.systemSqlQueries;
    }
}