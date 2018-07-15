package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PoiTests.FindPage;
import PoiTests.MyHomePage;
import lib.selenium.PreAndPost;

public class DeleteLead extends PreAndPost   {
	@BeforeTest
	public void setvalue() {
		author="Nandha";
		testCaseName="Delete Lead";
		description="Deleting the existing lead";
		category="sanity";
		nodeName="Delete Lead";
		excelName="DeleteLead";
	}

	@Test(dataProvider="Test")
	public void deleteLead(String leadID)
	{
		new MyHomePage(driver, createTest, createNode).clickLeads();
		new FindPage(driver, createTest, createNode).findleadbyId(leadID).clickOnId(leadID)
		.clickDelete().findleadbyId(leadID).checkIdAvailablity(leadID);
	}
}
