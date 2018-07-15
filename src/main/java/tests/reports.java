package tests;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class reports {
	
	public static void main(String[]args) throws IOException {
		ExtentHtmlReporter html=new ExtentHtmlReporter("./result.html");//non editable html
		html.setAppendExisting(true);
		//change it to editable
		ExtentReports extend= new ExtentReports();
		extend.attachReporter(html);
		ExtentTest createTest = extend.createTest("TC001_Create Lead", "Creating a Lead");
		createTest.assignAuthor("Nandha");
		createTest.assignCategory("smoke");
	
		createTest.pass("The data is entered username",MediaEntityBuilder.createScreenCaptureFromPath("./snaps/snap1.jpg").build());
		extend.flush();
	}

}
