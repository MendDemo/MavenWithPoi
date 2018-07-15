package lib.reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
//import com.aventstack.extentreports.reporter.configuration.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Report  {
	public static ExtentHtmlReporter html;
	public static ExtentReports extend;
	public   ExtentTest createTest;
	public  ExtentTest createNode;

	//@before suite
	public void reportInitialise() {
		html= new ExtentHtmlReporter("./output/results.html");
		html.setAppendExisting(false);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		extend=new  ExtentReports();
		extend.attachReporter(html);
		}

	//@before class
	public ExtentTest creatTestcase(String testcaseName,String desc,String author,String category) {

		createTest = extend.createTest(testcaseName, desc);
		createTest.assignAuthor(author);
		createTest.assignCategory(category);
		return createTest;
	}
	public ExtentTest creatNode(String nodeName) {
		createNode = createTest.createNode(nodeName);
		return createNode;
	}
	//@AterSuite
	public void endReport() {
		extend.flush();
	}
	
	// below methods are invoked at WebdriverServiceImpl
	public abstract long takeSnap();

	public void reportSteps(String desc,String status) {

		MediaEntityModelProvider img = null;

		long snapNumber = 1000000L;
		snapNumber = takeSnap();


		try {
			img = MediaEntityBuilder.createScreenCaptureFromPath("./../output/images/"+snapNumber+".png").build();
		} catch (IOException e) {			
		}		

		if(status.equalsIgnoreCase("PASS")) {
			createNode.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			createNode.fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			createNode.warning(desc, img);		
		}else {
			createNode.info(desc);
		}
	}

}
