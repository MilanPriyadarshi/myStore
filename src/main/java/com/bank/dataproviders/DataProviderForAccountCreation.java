package com.bank.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderForAccountCreation {
	@DataProvider(name="AccountDetails")
	public Object[][] getAccount() throws IOException
	{
		File file=new File("./resource/TestData/LogIn.xlsx");
		FileInputStream fileInputStream=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet=workbook.getSheet("AccountCreation");
		int rowCount=sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowCount-1][colCount];
		for (int i = 0; i < rowCount-1; i++) {
			for (int j = 0; j < colCount; j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));

			}
		}
		fileInputStream.close();
		workbook.close();
		return data;
	}

}
