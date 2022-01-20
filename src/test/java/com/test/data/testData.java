package com.test.data;
import org.testng.annotations.DataProvider;

public class testData {
    @DataProvider(name = "TingcheData")
    public static Object[][] getTestData(){
        String excelPath    = "E:\\MyJava\\workspace\\mytest\\src\\main\\java\\com\\test\\com.test.data\\testData.xlsx";
        String excelSheet   = "test1";
        return getDataUitlClass.getDataUtil(excelPath,excelSheet);

    }
//    public static void main(String argv[]){
//        String excelPath    = "E:\\MyJava\\workspace\\mytest\\src\\main\\java\\com\\test\\com.test.data\\testData.xlsx";
//        String excelSheet   = "test1";
//        Object[][]  object=getDataUitlClass.getDataUtil(excelPath,excelSheet);
//        System.out.println(object[0][1]);
//
//    }

}
