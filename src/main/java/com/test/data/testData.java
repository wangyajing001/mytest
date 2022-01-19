package com.test.data;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import com.test.data.getDataUitlClass;


public class testData {
    @DataProvider(name = "TingcheData")
    public static Object[][] getTestData() throws IOException, InvalidFormatException {
        String excelPath    = "E:\\testData.xlsx";
        String excelSheet   = "test1";
        return getDataUitlClass.getDataUtil(excelPath,excelSheet);

    }

}
