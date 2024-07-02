package com.bank.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="logInData")
	public String[][] getData() throws IOException
	{
		File file=new File("./resource/TestData/LogIn.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRow=sheet.getPhysicalNumberOfRows();
		int noOfCol=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[noOfRow-1][noOfCol];
		for (int i = 0; i < noOfCol-1; i++) {
			for (int j = 0; j < noOfCol; j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fileInputStream.close();
		return data;
	}}
