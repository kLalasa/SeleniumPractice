package Datadriventesting_practice;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Lab001 {

    //ExcelFile---->Workbook---->Sheets------->Rows-------> Cells
    public static void main(String[] args) {
        FileInputStream file = null;
        XSSFWorkbook workbook = null;

        try {
            file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Test_Data\\TestData.xlsx");
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rows = sheet.getLastRowNum();
            int totalCells = sheet.getRow(0).getLastCellNum(); // Start from row 0 for header

            System.out.println("Total number of rows: " + (rows + 1)); // Add 1 for zero-based index
            System.out.println("Total number of cells: " + totalCells);

            for (int r = 0; r <= rows; r++) { // Start from 0 to include all rows
                XSSFRow currentRow = sheet.getRow(r);
                if (currentRow != null) {
                    for (int c = 0; c < totalCells; c++) { // Start from 0 to include all cells
                        XSSFCell cell = currentRow.getCell(c);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "\t");
                                    break;
                                case NUMERIC:
                                    System.out.print(cell.getNumericCellValue() + "\t");
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue() + "\t");
                                    break;
                                default:
                                    System.out.print("Unknown cell type" + "\t");
                            }
                        } else {
                            System.out.print("Cell is null" + "\t");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (file != null) file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}