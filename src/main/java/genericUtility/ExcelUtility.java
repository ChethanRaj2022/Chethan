package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * its used to read data from excel workbook based on below
 * sheetname
 * rownum
 * cellnum
 * String Data
 * @author Manasa
 *
 */



public class ExcelUtility {
	public String getExcelData(String Sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream("./data/excel1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data=cell.getStringCellValue();
		return data;
	}

	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/excel1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/excel1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/excel1.xlsx");
		wb.write(fos);
		wb.close();
		
	}

	
	public String getNumberFromExcel(String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis  = new FileInputStream("./data/excel1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.toString();
		return value;
		
		
	}
}




