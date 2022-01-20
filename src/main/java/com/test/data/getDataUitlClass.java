package com.test.data;


import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;


public class getDataUitlClass {
    /**
     * 获取excel中的数据公共方法
     */
    public static Object[][] getDataUtil(String excelPath,String excelSheet) {
        int rowIndex = 0;
        int colIndex = 0;
        Sheet naviSheet = getSheet(excelPath, excelSheet);
        int iLastRowIndex = naviSheet.getLastRowNum();
        Row row = naviSheet.getRow(0);
        int lastColIndex = row.getLastCellNum();
        Object excelData[][] = new Object[iLastRowIndex+1][lastColIndex];
        for (rowIndex = 0; rowIndex <= iLastRowIndex; rowIndex++) {
            for (colIndex = 0; colIndex < lastColIndex; colIndex++) {
                Cell cell = getCell(naviSheet, rowIndex, colIndex);
                String paramValue = getCellValue(cell);
                excelData[rowIndex][colIndex] = paramValue;
            }
        }
        return excelData;
    }
    /**
     * @Title: getSheet
     * @Description: Get the sheet from Excel
     * @return: Sheet
     */
    private  static Sheet getSheet(String path, String sheetname){
        FileInputStream fs = null;
        Sheet naviSheet = null;
        try {
            fs = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fs);
            naviSheet = wb.getSheet(sheetname);
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return naviSheet;
    }

    /**
     * @Title: getSheet
     * @Description: Get the Cell from Excel
     * @return: Cell
     */
    private static Cell getCell(Sheet sheet, int rowIndex, int columnIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell((short) columnIndex);
        }
        return cell;
    }

    /**
     * @Title: getCellValue
     * @Description: Get the Cell value from Excel
     * @return: String
     */
    private static String getCellValue(Cell cell) {
        String arg = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case 1:
                arg = (cell == null ? "" : cell.getStringCellValue());
                break;
            case 0:
                Double dvalue = (cell == null ? 0 : cell.getNumericCellValue());
                arg = String.valueOf(dvalue);
                if(arg.matches("\\d+.[0]*"))
                {
                    int endIndex = arg.indexOf(".");
                    arg = arg.substring(0, endIndex);
                }
                if(arg.matches("^((-?\\d+.?\\d*)[Ee]{1}(\\d+))$"))
                {
                    arg = df.format(dvalue);
                }
                break;
            case 4:
                Boolean bool = (cell == null ? false : cell.getBooleanCellValue());
                arg = bool.toString();
                break;
            case 2:
                arg = (cell == null ? "" : cell.getCellFormula());
                break;
            case 5:
                arg =  (cell == null ? "" : Byte.toString(cell.getErrorCellValue()));
                break;
            case 3:
                arg = "";
                break;
        }
        return arg;
    }


}
