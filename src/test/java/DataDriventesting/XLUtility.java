package DataDriventesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path= null;


    XLUtility(String path){
        this.path=path;
    }
    public  int getRowcount(String sheetName) throws IOException {
        fi= new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int RowCount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return RowCount;


    }


    public int getCellCount(String sheetName , int rownum) throws IOException {
        fi = new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellCount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;


    }
    public  String getCellData(String sheetName,int rownum, int colnum) throws IOException {

        fi=new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);
        DataFormatter formatter=new DataFormatter();
        String data;
        try {


            data = formatter.formatCellValue(cell);
        }catch (Exception e){
            data="";

        }
        workbook.close();;
        fi.close();
        return data;



    }
    public void setCellData(String sheetName, int rownum, int colnum,String data) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row= sheet.getRow(rownum);
        cell= row.createCell(colnum);
        cell.setCellValue(data);

        fo= new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void fillGreenColour(String sheetName, int rownum, int colnum) throws IOException {
        fi=new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);
        style= workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();

    }

    public void fillRedColour(String sheetName, int rownum, int colnum) throws IOException {
        fi=new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);
        style= workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();

    }

    public String[][] getDataFromSheet(String workbookLocation,String WorkSheetName) throws  IOException{

        workbook=new XSSFWorkbook(System.getProperty("user.dir")+"/"+workbookLocation);
        sheet=workbook.getSheet(WorkSheetName);
        int  noOfRows=sheet.getLastRowNum() +1;
        int noOfColumns=sheet.getRow(0).getLastCellNum();
        String[][] dataTable=new String[noOfRows][noOfColumns];

        for(int i=sheet.getLastRowNum();i<sheet.getLastRowNum()+1; i++){

            Row row=sheet.getRow(i);

            for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++){
                Cell cell= row.getCell(j);
                dataTable[i][j]=cell.getStringCellValue();

            }


        }
        workbook.close();
        return dataTable;
    }



}

