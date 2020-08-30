package com.myStore.common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DataHelper {
    private static String sheet = "default1";
    private static String sheet1 = "test/resources/testData/default.xls";
    private static Map<String, String> map = new HashMap<>();


    public String get(String testCaseName, String columnName) throws IOException {
        FileInputStream fileInputStream;
        int k = 0;
        try {
            fileInputStream = new FileInputStream(sheet1);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet(sheet);
            int rows = worksheet.getPhysicalNumberOfRows();

            for (int i = 0; i < rows; i++) {
                int columns = worksheet.getRow(0).getPhysicalNumberOfCells();
                for (int j = 0; j < columns; j++) {
                    if (worksheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(columnName)) {
                        k = j;
                    }
                    map.put(worksheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""), columnName);

                    worksheet.getRow(i).getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map.get(testCaseName);
    }


}


