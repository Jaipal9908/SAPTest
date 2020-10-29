 package com.genericLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import config.PropertiesFile;

       public class ExcelLib{
			 
    	   static String path = PropertiesFile.readPropertiesFile("Excelpath");
		   			
	   public static String getExceldata(String shName,int rNum,int cNum) {
			FileInputStream fis = null;
			Workbook wb=null;

			try {
			 fis = new FileInputStream(path);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
			 wb = WorkbookFactory.create(fis);
			}catch (IOException e) {
				e.printStackTrace();
			}
			Sheet sh = wb.getSheet(shName);
			Row row = sh.getRow(rNum);
			String data = row.getCell(cNum).getStringCellValue();
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
	  
	   }
		 }
			
		