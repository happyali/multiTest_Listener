package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.galenframework.reports.GalenTestInfo;

import pages.BaseClass;


public class CustomListeners extends BaseClass implements ITestListener {

	public void onStart(ITestContext result) {
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		extentReport.set(test);

//		objSingleGalenTest = GalenTestInfo.fromString(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extentReport.get().pass("Test Case : " + result.getName().toUpperCase() + " PASSED");
//		objGalentestsList.add(objSingleGalenTest);
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("In OnTestFailure :", true);		
		extentReport.get().fail("Test Case : " + result.getName().toUpperCase() + " FAILED");
		extentReport.get().fail(result.getThrowable());
//		objGalentestsList.add(objSingleGalenTest);
	}
		
	public void onTestSkipped(ITestResult result) {
		extentReport.get().skip("Test Case : " + result.getName().toUpperCase() + " SKIPPED");
//		objGalentestsList.add(objSingleGalenTest);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO
	}

	public void onFinish(ITestContext result) {
		if (extent != null) {
			extent.flush();
		}
	}

}
