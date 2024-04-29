package com.demoshop.dataprovider;

import org.testng.annotations.DataProvider;

import com.demoshop.utilities.ExcelLibrary;

public class DataProviders {
	String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
	String credentialSheet = "Credentials";
	String createAccountSheet = "CreateAccount";
	String productSheet = "Products";
	ExcelLibrary xlUtility = new ExcelLibrary(path);
	
	@DataProvider(name="credentials")
	public String[][] getCredentialsFromExcelData() throws Exception{
		
		int totalRows = xlUtility.getRowCount(credentialSheet);
		int totalCells = xlUtility.getCellCount(credentialSheet, totalRows);
		
		String[][] data = new String[totalRows][totalCells];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCells;j++) {
				data[i-1][j]=xlUtility.getCellData(credentialSheet, i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="createaccount")
	public String[][] createAccountFromExcelData() throws Exception{
		int totalRows = xlUtility.getRowCount(createAccountSheet);
		int totalCells = xlUtility.getCellCount(createAccountSheet, totalRows);
		
		String data[][]=new String[totalRows][totalCells];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCells;j++) {
				data[i-1][j] = xlUtility.getCellData(createAccountSheet, i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="products")
	public String[][] getProductsFromExcelData() throws Exception {
		int totalRows = xlUtility.getRowCount(productSheet);
		int totalCells = xlUtility.getCellCount(productSheet, totalRows);
		
		String data[][] = new String[totalRows][totalCells];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCells;j++) {
				data[i-1][j] = xlUtility.getCellData(productSheet, i, j);
			}
		}
		return data;
	}
}
