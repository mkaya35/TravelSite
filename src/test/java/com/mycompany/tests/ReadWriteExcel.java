package com.mycompany.tests;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		
		
		// SS User Model
		
		//FileInputStream fis = new FileInputStream("D:/drivers/MasterTestDataFile.xlsx");
		FileInputStream fis = new FileInputStream("MasterTestDataFile.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet tds =  wb.getSheet("TestCaseDataSets");
		
		
		System.out.println(tds.getRow(7).getCell(1));
		
		String cellValue1 = tds.getRow(6).getCell(1).toString(); 
		String cellValue2 = tds.getRow(5).getCell(0).toString();
		String cellValue3;
		
		try{
			cellValue3 = tds.getRow(7).getCell(2).toString();
		}
		catch(Exception e)
		{
			cellValue3="Nothing";
		}
				
		System.out.println("Row 7, Col 2: " + cellValue1);
		
		System.out.println("Row 6, Col 1: " + cellValue2);
		
		System.out.println("Row 8, Col 3: " + cellValue3);

/*		******************** Writing to Excel Files ********************************
		FileOutputStream fos = new FileOutputStream("D:/drivers/MasterTestDataFile.xlsx");
		wb.createSheet("Ramazan").createRow(5).createCell(2).setCellValue("Zeliha");
		tds.getRow(5).getCell(0).setCellValue("Welcome");
		wb.write(fos);
		fos.close();
		*/
				
	}

}
