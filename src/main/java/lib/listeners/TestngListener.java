package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import lib.selenium.WebDriverServiceImpl;

public class TestngListener extends WebDriverServiceImpl implements IAnnotationTransformer,IRetryAnalyzer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		/*annotation.setRetryAnalyzer(this.getClass());

		if(testMethod.getName().equals("createLead")) {
			annotation.setInvocationCount(1);
		}
		

	} {*/

	}

	@Override
	public boolean retry(ITestResult result) {
		int max=1;
		if(!result.isSuccess()&&max<2) {
			max++;
			return true;

		}

		return false;
	}

	public String methodName(Method testMethod){
		String methodName=testMethod.getName();
		System.out.println("mehod is"+methodName);
		return methodName;



	}
}