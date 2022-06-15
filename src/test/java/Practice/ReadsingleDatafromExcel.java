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

public class ReadsingleDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/excel1.xlsx");
		//open the workbook
		Workbook book=WorkbookFactory.create(fis);
		//control of sheet
		Sheet sheet = book.getSheet("Sheet1");
		//control of row
		Row row = sheet.getRow(0);
		//control of cell
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		System.out.println(value);
		//close the workbook
		book.close();
		

	}

}
