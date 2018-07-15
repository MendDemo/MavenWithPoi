package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PoiTests.MyHomePage;
import lib.selenium.PreAndPost;

public class CreateLead extends PreAndPost{
	
	

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
public void createLead(String companyName,String fName,String lName,String eMail,String mobile) {

		
		
		
	 new MyHomePage(driver, createNode, createNode)
		.clickLeads()
		.clickCreateLeads().typeCompanyName(companyName).typeLastName(lName).typeFirstName(fName).click().verifyId();
		/*
		WebElement eleCompanyName = locateElement("id", "createLeadForm_companyName");
		type(eleCompanyName, companyName);
		
		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, fName);
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, lName);
		
		WebElement eledropdown = locateElement("id", "createLeadForm_marketingCampaignId");
		selectDropDownUsingIndex(eledropdown, 3);
		
		WebElement elename = locateElement("name", "submitButton");
		click(elename);
		
		WebElement eleleadId = locateElement("xpath","//span[@id='viewLead_companyName_sp']");
		String output = getText(eleleadId);
		output.replaceAll("[a-zA-z()]", "");
		System.out.println("Created Lead ID is "+output.trim());
		String leadId=output.trim();*/
		//return leadId;
		//closeActiveBrowser();
		
		
	}



	
}




