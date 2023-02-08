package utility;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilityClass {

public FileInputStream file;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
public int rowcount;
public int colcount;
public String path = "src/main/java/testData/Eject_Test_Data.xlsx";

public Object[][] dataReader(String sheetName) throws IOException {

    file = new FileInputStream(path);
    workbook = new XSSFWorkbook(file);
    sheet = workbook.getSheet(sheetName);
    rowcount = sheet.getLastRowNum();
    colcount = sheet.getRow(0).getLastCellNum();
    Object[][] data=new Object[rowcount][colcount];
    for(int r=0;r<rowcount;r++){

        row = sheet.getRow(r);
        for (int c=0;c<colcount;c++){
           switch (cell.getCellType()){
               case STRING: data[r][c]=sheet.getRow(r+1).getCell(c).getStringCellValue();
               case NUMERIC: int num= (int) sheet.getRow(r+1).getCell(c).getNumericCellValue();
               String val= Integer.toString(num);
                   data[r][c]=val;
               //case BOOLEAN:data[r][c]=sheet.getRow(r+1).getCell(c).getBooleanCellValue();
           }
        }
    }

    return data;
}


}
