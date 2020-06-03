package com.example.group5.DAO;

import com.example.group5.model.CsvFile;

import java.io.File;

public interface ICsvFileDao {

    public void loadCsvFileFromURL(String Path , CsvFile csvFile);
}
