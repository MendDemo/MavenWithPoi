package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PoiTests.*;
import lib.selenium.PreAndPost;

public class FindandEditLead extends PreAndPost {
	@BeforeTest
	public void setvalue() {
		author="Nandhakumar";
		testCaseName="EditLead";
		description="Search a lead and edit the same";
		category="unit";
		nodeName="Lead";
		excelName="EditLead";
	}
	@Test (dataProvider="Test")
	
	public void findLead(String leadID,String changingItem) {
		
		new MyHomePage(driver, createTest, createNode).clickLeads();
		new FindPage(driver, createTest, createNode).findleadbyId(leadID).clickOnId(leadID).clickEdit().edit(changingItem);
		
		





	}

}
