package Basic;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcel {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");
        Row row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("UserName");
        row1.createCell(1).setCellValue("Password");


        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("mngr432063");
        row2.createCell(1).setCellValue("eqUjyry");

        Row row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("WrongUserName");
        row3.createCell(1).setCellValue("Wrongpassword");


        workbook.write(new FileOutputStream("ExcelSample.xlsx"));
        System.out.println("Excel file created successfully");
    }
}
