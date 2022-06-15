package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SpecificDatainExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		String in="hi";
		FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		for(int i=0;i<2;i++)
		{
			Cell cell = row.getCell(i);
			String val = cell.getStringCellValue();
			if(val.equals(in))
			{
				Row row1 = sheet.getRow(1);
				Cell cell1 = row1.getCell(i+1);
				String val1 = cell1.getStringCellValue();
				System.out.println(val1);
			}
			
			
		}
		

	}

}
