package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PoiTests.FindPage;
import PoiTests.MyHomePage;
import lib.selenium.PreAndPost;


public class DuplicateLead extends PreAndPost {


	@BeforeTest
	public void setvalue() {
		author="Nandha";
		testCaseName="Duplicate and Merge lead";
		description="Duplicating a lead and Merge to another lead";
		category="smoke";
		nodeName="Lead";
		excelName="Duplicate&MergeLead";}
	@Test(dataProvider="Test")

	public void duplicateAndMergeLead(String inputLeadId,String MergeTo) {

		new MyHomePage(driver, createTest, createNode).clickLeads();
		new FindPage(driver, createTest, createNode).findleadbyId(inputLeadId).clickOnId(inputLeadId)
		.clickDuplicate().duplicate().getDuplicateId();


	}

}


