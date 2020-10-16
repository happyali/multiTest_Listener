package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BaseClass;

@Listeners(utility.CustomListeners.class)
public class LaunchSearchApp extends BaseClass {
	
	@Test
	
	public void LaunchGoogle() {
		//logger=report.createTest("Google");
    	//logger.info("Login Successful");
    	
    	driver.get("https://www.google.com");
		//logger.pass("TEST PASSED");
		Reporter.log("Google Title :"+driver.getTitle(), true);
		if(BrowserName.equalsIgnoreCase("chrome")) {
			Assert.assertEquals(12, 12);
		} else {
			Assert.assertEquals(12, 13);
		}
	}

}
