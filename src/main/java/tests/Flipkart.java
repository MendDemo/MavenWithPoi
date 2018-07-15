package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Flipkart extends WebDriverServiceImpl{
	public String leadId;
	
	
@Test
public void  createLead() throws InterruptedException {
	driver.getKeyboard().sendKeys(Keys.ESCAPE);
	WebElement eleelectronics = locateElement("xpath", "//span[text()='TVs & Appliances']");
	
	WebElement eleTVsamsung = locateElement("xpath", "(//span[text()='Samsung'])[2]");
	
	moveToelementandClick(eleelectronics,eleTVsamsung);
	Thread.sleep(3000);
	WebElement eleMinPrice = locateElement("xpath", "(//select[@class='fPjUPw'])[1]");
	selectDropDownUsingValue(eleMinPrice, "40000");
	WebElement eleMaxPrice = locateElement("xpath", "(//select[@class='fPjUPw'])[2]");
	selectDropDownUsingValue(eleMaxPrice, "60000");
	Thread.sleep(5);
	WebElement elescreenSize = locateElement("xpath", "//div[text()='Screen Size']");
	//waituntilClickable(elescreenSize);
	click(elescreenSize);
	WebElement selectSize = locateElement("xpath", "//div[text()='48 - 55']/preceding-sibling::div");//39 - 43
	click(selectSize);
	Thread.sleep(10);
	WebElement firstPrice = locateElement("xpath", "(//div[@class='_1vC4OE _2rQ-NK'])[1]");
	String PriceinFirstWindow=firstPrice.getText();
	System.out.println("price is "+PriceinFirstWindow);
	//WebElement firstimg = locateElement("xpath", "(//div[@class='col col-7-12']/div[1])[1]");
	WebElement firstimg = locateElement("xpath", "(//div[@class='col col-7-12'])[1]");
	waituntilClickable(firstimg);
	click(firstimg);
	switchToWindow(1);
	System.out.println(driver.getTitle());
	
	String priceinSecondWindow = locateElement("xpath", "//div[@class='_1vC4OE _3qQ9m1']").getText();
	closeActiveBrowser();
	switchToWindow(0);
	locateElement("xpath", "(//span[text()='Add to Compare'])[1]").click();
	locateElement("xpath", "(//span[text()='Add to Compare'])[2]").click();
	locateElement("xpath", "(//span[text()='COMPARE'])").click();
	
		//Verify title
	String sectionTitle = locateElement("xpath", "(//span[text()='Compare'])[1]").getText();
	System.out.println(sectionTitle);
	String costOfItem1 = locateElement("xpath", "(//div[@class='aqcZRL']/div[1])[1]/div[1]").getText().replaceAll("[^0-9]", "");
	String costOfItem2 = locateElement("xpath", "(//div[@class='aqcZRL']/div[1])[2]/div[1]").getText().replaceAll("[^0-9]", "");
	
	int cost1=Integer.valueOf(costOfItem1);int cost2= Integer.valueOf(costOfItem2);
	if(cost1>cost2) 
		System.out.println("Lowest price is Rs:"+cost2);
	else if(cost1<cost2)
		System.out.println("Lowest price is Rs:"+cost1);
	else
		System.out.println("Both price of items are same");
	
	
	
	
	
	
	
			
}}




