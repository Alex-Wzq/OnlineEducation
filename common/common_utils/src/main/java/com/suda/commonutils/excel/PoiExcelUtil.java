package com.suda.commonutils.excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class PoiExcelUtil {

    public static List<List<String>> readXlsx(String filename) throws Exception{
        InputStream inputStream = new FileInputStream(filename);
        return readXlsx(inputStream, 0, -1, 0);
    }

    public static List<List<String>> readXlsx(InputStream inputStream, int startRows, int endRows, int sheetIndex) throws Exception{
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        if (endRows < 0){
            // sheet.getLastRowNum() ：最后一行的行数
            endRows = sheet.getLastRowNum() + 1;
        }

        List<List<String>> result = new ArrayList<>();
        for (int rowIndex = startRows; rowIndex < endRows; rowIndex++){
            Row row = sheet.getRow(rowIndex);
            ArrayList<String> colList = new ArrayList<>();
            // row.getLastCellNum(); 最后一行的列数 + 1
            int lastCellNum = row.getLastCellNum();

            for (int colIndex = 0; colIndex < lastCellNum; colIndex++){
                Cell cell = row.getCell(colIndex);
                colList.add(cell.getStringCellValue());
            }
            result.add(colList);
        }

        inputStream.close();
        return result;
    }

    public static void printList(List<List<String>> list){
        Formatter formatter = new Formatter(System.out);

        int col = list.get(0).size();
        for (int i = 0; i < col + 1; i++) {
            formatter.format("%10d", i);
        }

        col = 1;
        list.forEach(l -> {
            System.out.println();
            formatter.format("%10d", list.indexOf(l) + 1);
            l.forEach(val -> formatter.format("%10s", val));
        });
    }
}
