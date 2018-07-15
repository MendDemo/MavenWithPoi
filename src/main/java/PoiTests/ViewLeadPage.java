package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ViewLeadPage extends PreAndPost {
	
	
	public ViewLeadPage(EventFiringWebDriver driver,ExtentTest createTest, ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;
		this.createNode=createNode;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@id='viewLead_companyName_sp']")
	WebElement eleleadId;
	@FindBy(linkText="Edit")
	WebElement eleEdit;
	@FindBy(linkText="Duplicate Lead")
	WebElement eleDuplicate;
	@FindBy(xpath="//span[@id='viewLead_companyName_sp']")
	WebElement eleduplicate;
	@FindBy(linkText="Delete")
	WebElement eleDelete;
	public ViewLeadPage verifyId() {
		String output = getText(eleleadId);
		output.replaceAll("[a-zA-z()]", "");
		
		String leadId=output.trim();
		
		return this;
	}
public EditLeadPage clickEdit() {
	click(eleEdit);
	return new EditLeadPage(driver,createTest,createNode);
}

public DuplicateLeadPage clickDuplicate() {
	click(eleDuplicate);
	return new DuplicateLeadPage(driver, createTest, createNode);
}
public ViewLeadPage getDuplicateId() {
	getText(eleduplicate);
	return this;
}

public FindPage clickDelete() {
	click(eleDelete);
	return new FindPage(driver, createTest, createNode);
}
}
