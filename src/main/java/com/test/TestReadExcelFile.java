package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestReadExcelFile {
    public static void readExcelFile(String excelPath){


        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！

                Workbook wb;
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(fis);// 创建excel模板workbook，

                }else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                //Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                Sheet sheet=wb.getSheet("test1");

                //int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int firstRowIndex = sheet.getFirstRowNum()+1;
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.println(cell.toString());
                            }
                        }
                    }
                }
                fis.close();
            } else {
                System.out.println("找不到指定的文件");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void main(String argv[]){
        String excelPath = "E:\\testData.xlsx";
        readExcelFile(excelPath);
    }

}
