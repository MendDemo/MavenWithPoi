package data.reader;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.JXLException;
import jxl.Workbook;
import lib.selenium.PreAndPost;


public class WriteExcel extends PreAndPost {
	@BeforeTest
	public void setvalue() {
		author="Nandha";
		testCaseName="CreateLead";
		description="Creating a Lead";
		category="smoke";
		nodeName="Lead";
		excelName="CreateLead";
		
	}
	
@Test(dataProvider="Test")
		
	public int writeExcel() throws JXLException, IOException{
		
		File WritableExcel=new File("./data/CreateLead.xlsx");
		Workbook workbook = Workbook.getWorkbook(WritableExcel);
		
		return workbook.getNumberOfSheets();

		//		return null;


	


}	
}