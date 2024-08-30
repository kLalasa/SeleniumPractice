package Datadriventesting_practice;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Lab002 {
    public static void main(String[] args)throws IOException {
        FileOutputStream file =new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Test_Data\\TestData1.xlsx");

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Data");
        XSSFRow row1=sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue("Python");
        row1.createCell(2).setCellValue("Ruby");

        XSSFRow row2= sheet.createRow(1);
        row2.createCell(0).setCellValue("Programmer");
        row2.createCell(1).setCellValue("Manual tester");
        row2.createCell(2).setCellValue("Automation");

        XSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("Frontend");
        row3.createCell(1).setCellValue("Backend");
        row3.createCell(2).setCellValue("Designing");

        workbook.write(file);

    }
}
