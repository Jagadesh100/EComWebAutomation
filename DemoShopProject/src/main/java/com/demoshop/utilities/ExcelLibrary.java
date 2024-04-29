package com.demoshop.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	//public static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	private XSSFCellStyle style = null;
	
	public String path = null;

	public ExcelLibrary(String path) {

		this.path = path;
	}

	public int getRowCount(String sheetName) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount =  sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName,int rownum) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rownum,int colnum) throws Exception {
		fis = new FileInputStream(path);
		workbook =  new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
			System.out.println("Data not read, Exception:"+e.getMessage());
		}
		//String cellData = cell.getStringCellValue();
		workbook.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName,int rownum,int cellnum,String data) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		workbook.close();
		fis.close();
		fileOut.close();
	}
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fis.close();
		fileOut.close();
	}
	public void fillRedColor(String sheetName,int rownum,int colnum) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOut);
		workbook.close();
		fis.close();
		fileOut.close();
	}
}
