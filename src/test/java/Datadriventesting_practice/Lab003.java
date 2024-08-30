package Datadriventesting_practice;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Lab003 {
    public static void main(String[] args) throws IOException {
        FileOutputStream file= new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Test_Data\\DynamicData.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("DynamicData");

        Scanner sc= new Scanner(System.in);

        System.out.println("enter the rows");
        int rows=sc.nextInt();

        System.out.println("Enter the columns");
        int col= sc.nextInt();

        for(int r=0;r<=rows;r++){

            XSSFRow currentRow= sheet.createRow(r);
            for(int c=0;c<=col;c++){

                XSSFCell cell=currentRow.createCell(c);
                cell.setCellValue(sc.next());



            }
        }
        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("File is created");






    }
}
