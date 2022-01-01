package com.crm.genericutilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getData(String sheet,int row,int cell)//This method is used to import
	{
		String val="";
		try
		{
			FileInputStream fis=new FileInputStream("./TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell ce=wb.getSheet(sheet).getRow(row).getCell(cell);
		val=ce.getStringCellValue();
		
		}catch(Exception e) {
			System.out.println("unable to fetch the data");
			
		}
		return val;
	}
	public void createData(String sheet,int row,int cell,String val)
	{
		try {
			FileInputStream fis=new FileInputStream("./TestData.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			Cell ce=wb.getSheet(sheet).getRow(row).createCell(cell);
			ce.setCellValue(val);
			FileOutputStream fos=new FileOutputStream("./TestData.xlsx");
			wb.write(fos);
			System.out.println("data is written");
		}catch(Exception e) {
			System.out.println("unable to write the data");
		}
	}
}
