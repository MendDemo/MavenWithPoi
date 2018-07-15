package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FindPage extends PreAndPost {
	
	
	
	public FindPage(EventFiringWebDriver driver,ExtentTest createTest, ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;
		this.createNode=createNode;
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	@FindBy(xpath="//input[@name='id']")
	WebElement eleEnterId;
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement elefindid;

	
	/*@FindBy(linkText="abc")//how can we locate the element using the argument of findandEdit() ie.String leadId, whereas leadId is passing from excel.
	WebElement expectedId;//have to click this id to edit this.(searching id using lead Id)
	WebElement eleleadidLink;*/
	
	
	public FindPage findleadbyId(String leadId) {
		
		click(eleFindLeads);
		type(eleEnterId, leadId);
		click(elefindid);
		return this;
		
	}
	public  ViewLeadPage clickOnId(String leadId) {
		WebElement elefindid = locateElement("link", leadId);
		click(elefindid);
		return new ViewLeadPage(driver,createTest,createNode);
		
	}
	  
	public FindPage checkIdAvailablity(String leadId) {
		//WebElement elefindid = locateElement("link", leadId);
		verifyDisplayed("link", leadId);
		
		return this;
		
	}


}
