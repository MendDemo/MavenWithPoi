package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class CreateLeadPage extends PreAndPost {
	
	
	public CreateLeadPage(EventFiringWebDriver driver,ExtentTest createTest, ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;this.createNode=createNode;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;
	@FindBy(name="submitButton")
	WebElement elelink;
	
	public CreateLeadPage typeCompanyName(String companyName) {
		
	type(eleCompanyName, companyName);
		return this;
	}
	public CreateLeadPage typeLastName(String data) {
		
		type(eleLastName, data);
			return this;
		}
	public CreateLeadPage typeFirstName(String data) {
		
		type(eleFirstName, data);
			return this;
		}
	
	public ViewLeadPage click() {
		click(elelink);
		return new ViewLeadPage(driver, createTest,createNode);//Referring a class with instance or constructor
	}
	
	
	
	
}
