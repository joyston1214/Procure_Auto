package com.scm.procure.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	
	}
	
	/**
	 * This method is used to get the total row count
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	
	
	}
	/**
	 * This method is used to write the data into Excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
		
		
	}
	
	public HashMap<String,String> readMultipleDataKeyAndValue(String sheetName,WebDriver driver) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <=count; i++) {
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
		
		
	}
	
	public String[] readMultipleCellData(String sheetName,int cell,WebDriver driver) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getPhysicalNumberOfRows();
		String[] s = new String[count];
		for (int i = 0; i < s.length; i++) {
			s[i]= sh.getRow(i).getCell(cell).getStringCellValue();
		}
		
		return s;
		
	}
	
	public Object[][] getdataProviderExcelSheet(String sheet) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getPhysicalNumberOfRows();
		short cellCount = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount][cellCount];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		return obj;
		
		
	
	}
	
	
	
	

}
