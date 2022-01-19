package com.test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReadExcelMap {
    public static void main( String[] args ) throws Exception {
//        System.out.println( "Hello World!" );
        String path = "E:\\testData.xlsx";
        List<Map> dataList= getExcelData(path);
        System.out.println("list:"+dataList);
    }
    public static List<Map> getExcelData(String path) throws Exception{
        List<Map> dataList = new ArrayList<>();
        InputStream is = new FileInputStream(path);

        XSSFWorkbook excel = new XSSFWorkbook(is);

        //当且仅当我们只用第一个表，即sheet
        Sheet sheet=excel.getSheet("test1");
        //获取最后一行的行数
        int rows = sheet.getLastRowNum();
        for(int rowNo=1;rowNo<=rows;rowNo++){
            //定义一个map 用于接收每一行的数据，当然也可以定义对象接收
            Map<String,String> map = new HashMap<>();
            Row row = sheet.getRow(rowNo);
            //一行有多个列，取最后一个列数，当做一共有多少列
            int cells = row.getLastCellNum();
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println(cells);
            //遍历列的数据
            for(int cellNo = 0;cellNo<cells;cellNo++){
                Cell cell = row.getCell(cellNo);
                String cellContent = cell.getStringCellValue();
                map.put("1",cellContent);
            }
            dataList.add(map);
        }
        is.close();
        return dataList;

    }

}
