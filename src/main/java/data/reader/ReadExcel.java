package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public String[][] readExcel(String excelName) throws IOException {
		XSSFWorkbook wbook =new	XSSFWorkbook("./data/"+excelName+".xlsx");	
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();//doesn't include header
		XSSFRow headerRow = sheet.getRow(0);//Referring to header row and get max column count
		
		int colcount = headerRow.getLastCellNum();
		/*
		System.out.println(rowcount);
		System.out.println(colcount);*/
		String[][]data=new String [rowcount][colcount];		

		for(int i=1;i<=rowcount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<colcount;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();

				data[i-1][j]=value;
			}

		}

wbook.close();
return data;


		//		return null;


	}



}
