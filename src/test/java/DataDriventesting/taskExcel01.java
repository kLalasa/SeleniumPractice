package DataDriventesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class taskExcel01 {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Data");
        Object data1[][]={{"LogInId","EmailID","Password"},
                { 1,"test@gmail.com","123@Test"},
                {2,"abc@gmail.com","345@abc"}


        };
        int rows= data1.length;
        int cols= data1[0].length;

        System.out.println(rows);
        System.out.println(cols);

        for(int r=0;r<rows;r++){

            XSSFRow row= sheet.createRow(r);
            for (int c=0;c<cols;c++){
                XSSFCell cell= row.createCell(c);

                Object value= data1[r][c];
                if(value instanceof String)
                    cell.setCellValue((String)value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer)value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean)value);
            }
        }

        FileOutputStream outputStream=new FileOutputStream(new File("CTD.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }

}
