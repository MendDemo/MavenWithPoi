package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class DuplicateLeadPage extends PreAndPost {
	
	
	public DuplicateLeadPage(EventFiringWebDriver driver,ExtentTest createTest, ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;
		this.createNode=createNode;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@value='Create Lead']")
	WebElement eleCreateId;
	
	
	
	public ViewLeadPage duplicate() {
		click(eleCreateId);
		return new ViewLeadPage(driver, createTest, createNode);
	}
	
	
}
