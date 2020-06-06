package com.example.group5.model;

import com.example.group5.DAO.ICsvFileDao;
import com.example.group5.model.CsvFile;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

// This mock will get One CSV file for the path
public class CsvFileMock implements ICsvFileDao {
    @Override
    public void loadCsvFileFromURL(String Path, CsvFile csvFile) {
        if (Path.equals("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv")){
            csvFile.setCsvFile(new File(Path));
        }
    }
}