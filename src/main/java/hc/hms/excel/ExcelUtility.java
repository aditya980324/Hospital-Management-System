package hc.hms.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ExcelUtility {
    public static final String path = "./src/main/resources/testData/HMS Test Data.xlsx";
    public String getExcelData(String sheetName,int rowNum,int cellNum) {
        String data="";
        try(FileInputStream fis = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(fis);
            data= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
        } catch (IOException e) {
            e.getMessage();
        }
        return data;
    }
    public void setExcelData(String sheetName,int rowNum,int cellNum,String inputData) {
        try(FileInputStream fis = new FileInputStream(path)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(sheetName);
            Row row = sh.getRow(rowNum);
            Cell cell = row.createCell(cellNum, CellType.STRING);
            cell.setCellValue(inputData);
            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}














