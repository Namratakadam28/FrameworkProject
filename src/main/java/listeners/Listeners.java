package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener
{
	public WebDriver driver;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>(); //rn the test cases in safe mode
	@Override
	
	public void onTestStart(ITestResult result) 
	{
		String testName = result.getName();
      extentTest = extentReport.createTest(testName);
      extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String testName = result.getName();
	//	extentTest.log(Status.PASS, testName+"got passed");
		extentTestThread.get().log(Status.PASS, testName+"got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
	  String testMethodName = result.getName();
	 // extentTest.fail(result.getThrowable());
	  extentTestThread.get().fail(result.getThrowable());
		
		//takeScreenshot(testName, driver);
		//String testName = result.getName(); //getting testname
		try
		{
	      driver=(WebDriver)result.getTestClass().
	  getRealClass().getDeclaredField("driver").get(result.getInstance());//will get driver of that particalurtest.driver of the crrently running test
		}
		catch(IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
		{
			 e1.printStackTrace();
		}
		try
		{
		String screenshotFilePath =	takeScreenshot(testMethodName , driver);
	    extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath , testMethodName);//adding screenshot to extent report
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extentReport.flush();//nothing will update to report without flush()s
		
	}
   
	
}
