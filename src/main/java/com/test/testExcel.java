package com.test;

import com.google.gson.Gson;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.io.IOException;
public class testExcel {
    public static void main(String[] args) throws Exception {
//        System.out.println( "Hello World!" );
        String path = "E:\\";
        List dataList = readExcelOfList(path, "testData.xlsx", "test1");
        //List<Map> dataList= readExcelOfList(path);
        System.out.println("list:" + dataList);
    }

    public static <T> List readExcelOfList(String filePath, String fileName, String sheetName) throws IOException, InvalidFormatException {
        List<String> resultMapList = new ArrayList<>();
        File file = new File(filePath + File.separator + fileName);
        System.out.println(file);
        FileInputStream inputStream = new FileInputStream(file);

        // 使用工厂模式 根据文件扩展名 创建对应的Workbook
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Gson gson = new Gson();
        Map<String, Object> resultMap;
        for (int i = 1; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            resultMap = new HashMap<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                String title = sheet.getRow(0).getCell(j).toString();
                if (row.getCell(j).getCellType() == CellType.STRING.getCode()) {
                    if(title.equals("params")){
                        String content = row.getCell(j).getStringCellValue();
                        Map m = gson.fromJson(content, Map.class);
                        resultMap.put(title, m);
                        continue;
                    }
                    resultMap.put(title, row.getCell(j).getStringCellValue());
                }
            }
            String json = gson.toJson(resultMap);
            resultMapList.add(json);
        }
        inputStream.close();
        return resultMapList;

    }

}

