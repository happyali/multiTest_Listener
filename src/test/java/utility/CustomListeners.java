package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import pages.BaseClass;

public class CustomListeners extends BaseClass implements ITestListener {
	


	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		report.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		report.get().pass("Test Case : " + result.getName().toUpperCase() + " PASSED");
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("In OnTestFailure :", true);
		
		report.get().fail("Test Case : " + result.getName().toUpperCase() + " FAILED");
		report.get().fail(result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		report.get().skip("Test Case : " + result.getName().toUpperCase() + " SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO
	}

	public void onStart(ITestContext context) {
		// TODO 
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

}
