package com.example.group5.model;

import com.example.group5.DAO.ICsvFileDao;

import java.io.File;

public class CsvFile {
    private File CsvFile;

    public CsvFile() {
        CsvFile = null;
    }

    public CsvFile(String Path, ICsvFileDao iCsvFileDao){
        //Data load from database
        iCsvFileDao.loadCsvFileFromURL(Path, this);
    }

    public File getCsvFile() {
        return CsvFile;
    }

    public void setCsvFile(File csvFile) {
        CsvFile = csvFile;
    }
}