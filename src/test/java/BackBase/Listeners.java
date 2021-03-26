package BackBase;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import projectResources.Base;
import projectResources.ExtentReporter;


public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		
		String currentTest = result.getMethod().getMethodName();
		extentTest.set(test);
		
		System.out.println("Test " + currentTest +" has Started.");
			
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		String currentTest = result.getMethod().getMethodName();
		System.out.println("Test " + currentTest +" has Passed.");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		String currentTest = result.getMethod().getMethodName();
		System.out.println("Test " + currentTest +" has Failed.");
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
