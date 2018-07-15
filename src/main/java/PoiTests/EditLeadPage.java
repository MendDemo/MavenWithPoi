package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class EditLeadPage extends PreAndPost {
	
	
	
	public EditLeadPage(EventFiringWebDriver driver,ExtentTest createTest, ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;
		this.createNode=createNode;
		
		PageFactory.initElements(driver, this);
	}



@FindBy(xpath="//select[@name='ownershipEnumId']")
WebElement eleDropdown;
@FindBy(xpath="//input[@value='Update']")
WebElement eleUpdate;
@FindBy(xpath="viewLead_ownershipEnumId_sp")
WebElement eleverify;

public EditLeadPage edit(String item) {
	
	selectDropDownUsingValue(eleDropdown, item);
	click(eleUpdate);
	return this;
	//return new ViewLeadPage(driver, createTest, createNode);
	
}


}
