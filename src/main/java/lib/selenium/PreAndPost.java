package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.reader.ReadExcel;
import lib.listeners.TestngListener;
//TestngListener extends webdriverServiceImpl
public class PreAndPost extends TestngListener{
	public String methodName;
	public String author;
	public String nodeName;
	public String testCaseName;
	public String description;
	public String category;
	public String excelName;
	@Parameters({"url","usename","password"})
	@BeforeMethod

	public void beforeMethod(String url,String username,String pwd) {
		System.out.println("Before Method");

		creatNode(nodeName);

		createNode.assignAuthor(author);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		//driver.get("https://www.flipkart.com/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, username);

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, pwd);
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
	}

	@AfterMethod//(groups= {"smoke","sanity"})
	public void afterMethod() {
		System.out.println("After Method");
		closeActiveBrowser();
	}

	@BeforeClass//(groups= {"smoke","sanity"})
	public void beforeClass() {
		System.out.println("Before class");

		creatTestcase(testCaseName, description,author,category);	
	}

	@AfterClass//(groups= {"smoke","sanity"})
	public void afterClass() {
		System.out.println("after class");
	}

	@BeforeTest//(groups= {"smoke","sanity"})
	public void beforeTest() {
		System.out.println("Before Test");


	}

	@AfterTest//(groups= {"smoke","sanity"})
	public void afterTest() {
		System.out.println("after test");
	}

	@BeforeSuite//(groups= {"smoke","sanity"})
	public void beforeSuite() {
		System.out.println("Before Suite");
		reportInitialise();
	}

	@AfterSuite//(groups= {"smoke","sanity"})
	public void afterSuite() {
		System.out.println("after Suite");
		endReport();
	}
	
	@DataProvider(name="Test")
	public Object[][] set1() throws IOException{
		ReadExcel obj=new ReadExcel();
		String[][] data = obj.readExcel(excelName);
		
		
		return data;
	}
	
	
	
	

}
