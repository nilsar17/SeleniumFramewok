package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		
		try {
			File src = new File("./TestData/Data.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File" + e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex, int row, int coloumn) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(coloumn).getStringCellValue();
	}
	public String getStringData(String sheetName, int row, int coloumn) {
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue();
	}
	
	public double getNumberData(String sheetName, int row, int coloumn) {
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getNumericCellValue();
	}
}
