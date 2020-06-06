package com.example.group5.model;

import com.example.group5.DAO.ICsvFileDao;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileTest {

    @Test
    public void defaultConstructorTest(){
        CsvFile csvFile = new CsvFile();
        assertNull(csvFile.getCsvFile());
    }

    @Test
    public void ConstructorTest(){
        ICsvFileDao iCsvFileDao = new CsvFileMock();
        CsvFile csvFile = new CsvFile("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv", iCsvFileDao);
        assertNotNull(csvFile.getCsvFile());
    }


    @Test
    void getCsvFile() {
        CsvFile csvFile = new CsvFile();
        csvFile.setCsvFile(new File("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv"));
        assertEquals(csvFile.getCsvFile(), new File("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv"));
    }

    @Test
    void setCsvFile() {
        CsvFile csvFile = new CsvFile();
        csvFile.setCsvFile(new File("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv"));
        assertEquals(csvFile.getCsvFile(), new File("D:/DAL/Summer_2020/Adv_SDC__CSCI_5308/file5.csv"));
    }
}