package com.clusters.generic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;

public class DataHandlers {
	static public String getDataFromProperties(String filename, String key)
	{
		String value=null;
		try
		{
			File f=new File("./config-data/"+filename+".properties");
			FileInputStream fis=new FileInputStream(f);
			Properties prop=new Properties();
			prop.load(fis);
			value=(String) prop.get(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	static public void storeDataToProperties(String filename, String key,String value, String comment)
	{
		try
		{
			File f=new File("./config-data/"+filename+".properties");
			FileInputStream fis=new FileInputStream(f);
			Properties prop=new Properties();
			prop.load(fis);
			prop.setProperty(key,value);
			FileOutputStream fos=new FileOutputStream(f);
			prop.store(fos, comment);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	static public String getDataFromExcel(String filename, String SheetName, int rowIndex, int cellIndex)
	{
		String data=null;
		try
		{
			File f=new File("./test-data/"+filename+".xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(SheetName);
			Row r=st.getRow(rowIndex);
			Cell c=r.getCell(cellIndex);
			
			 data=c.toString(); 	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

	static public void storeDataToExcel(String filename, String SheetName, int rowIndex, int cellIndex, String value)
	{
		try
		{
			File f=new File("./test-data/"+filename+".xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(SheetName);
			Row r=st.getRow(rowIndex);
			Cell c=r.getCell(cellIndex);
			
			c.setCellValue(value);
			
			FileOutputStream fos=new FileOutputStream(f);
			wb.write(fos);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
