package lib.selenium;  

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{
	boolean displayed;
	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": 	  return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "name" : return driver.findElement(By.name(locValue));

			case "xpath": return driver.findElement(By.xpath(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			reportSteps("Unable to locate an element","fail");//report steps will take snapshot and attach in the node
			throw new RuntimeException();
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportSteps("Data entered successfully, "+data,"pass");
		} catch (Exception e) {
			reportSteps("Data entered successfully, "+data,"fail");
		}		
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			reportSteps("Link "+ele+"has been clicked successfully","pass");
		} catch (Exception e) {
			reportSteps("Link "+ele+"has been clicked successfully","fail");
		}		
	}
	public void clear(WebElement ele) {
		driver.unregister(this);
		ele.clear();
		driver.register(this);
	}
	public String getText(WebElement ele) {

		try {

			String output=ele.getText();
			//output.replaceAll("[a-zA-z()]", "");
			int indexOfbegin = output.indexOf("(");
			int indexOfend = output.indexOf(")");
			String leadID = output.substring(indexOfbegin+1, indexOfend);

			reportSteps("Data "+leadID+" id has been generated", "pass");
			return ele.getText();

		} catch (Exception e) {
			reportSteps("Data "+getAlertText()+"hasn't been received", "fail");
			e.printStackTrace();
		}
		return null;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select dd  =new Select(ele);
			dd.deselectByVisibleText(value);
			reportSteps(value+"has been selected from dropdown", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps(value+"hasn''t been selected from dropdown", "fail");
		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select dd  =new Select(ele);
			dd.selectByValue(value);
			reportSteps(value+"has been selected from dropdown", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps(value+"hasn''t been selected from dropdown", "fail");
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {

		try {
			Select dd  =new Select(ele);
			dd.selectByIndex(index);
			reportSteps(index+"has been selected from dropdown using index", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps(index+"hasn''t been selected from dropdown", "fail");
		}

	}

	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}


	public boolean verifyDisplayed(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": WebElement ele = driver.findElement(By.id(locValue));
			displayed=ele.isDisplayed();
			if (displayed=false)
				reportSteps("Lead id" +locValue+"has been deleted","pass");
			else reportSteps("Lead id"+locValue+" have not deleted and still it's existing","fail");
			case "class": 
				WebElement eleclass = driver.findElement(By.className(locValue));
				displayed=eleclass.isDisplayed();
				if (displayed=false)
					reportSteps("Lead id" +locValue+"has been deleted","pass");
				else reportSteps("Lead id"+locValue+" have not deleted and still it's existing","fail");


			case "link": 
				WebElement ele3 = driver.findElement(By.linkText(locValue));
				displayed=ele3.isDisplayed();
				if (displayed=false)
					reportSteps("Lead id" +locValue+"has been deleted","pass");
				else
					reportSteps("Lead id"+locValue+" have not deleted and still it's existing","fail");


			case "name":

				WebElement ele1 = driver.findElement(By.name(locValue));
				displayed=ele1.isDisplayed();
				if (displayed=false)
					reportSteps("Lead id" +locValue+"has been deleted","pass");
				else
					reportSteps("Lead id"+locValue+" have not deleted and still it's existing","fail");


			case "xpath":  WebElement elexpath = driver.findElement(By.xpath(locValue));

			displayed=elexpath.isDisplayed();
			if (displayed=false)
				reportSteps("Lead id" +locValue+"has been deleted","pass");
			else reportSteps("Lead id"+locValue+" have not deleted and still it's existing","fail");

			default:
				break;
			}
		} catch (Exception e) {
			reportSteps("Lead id" +locValue+"has been deleted","pass");

		}
		return displayed;


	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		Set<String> setobj = driver.getWindowHandles();

		List<String> listObj= new ArrayList<String>();
		listObj.addAll(setobj);

		driver.switchTo().window(listObj.get(index));
	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return driver.switchTo().alert().getText();


	}

	public void closeActiveBrowser() {
		driver.close();


	}

	public void closeAllBrowsers() {
		driver.quit();

	}

	public void moveToelementandClick(WebElement elelocator1,WebElement elelocator2) {

		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elelocator1));

		builder.moveToElement(elelocator1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(elelocator2));
		builder.click(elelocator2).perform();



	}

	public void waituntilClickable(WebElement ele) {


		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}


	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}
public String getCurrentURL(){
	
	return driver.getCurrentUrl();
}

}






















