package PoiTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class MyHomePage extends PreAndPost {
	
	
	public MyHomePage(EventFiringWebDriver driver,ExtentTest createTest,ExtentTest createNode){
		this.driver=driver;
		this.createTest=createTest;
		this.createNode=createNode;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Leads")
	WebElement eleLeads;
	public MyLeadsPage clickLeads() {
		
		click(eleLeads);
		return new MyLeadsPage(driver, createTest,createNode);
	}

}
