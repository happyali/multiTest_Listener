package testcases;
 
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BaseClass;	
 
@Listeners(utility.CustomListeners.class)
public class LaunchAirways extends BaseClass  {
	
    @Test
    public void LaunchQantas() {  	
    	driver.get("https://www.qantas.com/");
		Reporter.log("Qantas Title :"+driver.getTitle(), true);
		if(BrowserName.equalsIgnoreCase("chrome")) {
			Assert.assertEquals(12, 12);
		} else {
			Assert.assertEquals(12, 13);
		}
    }
    
    @Test
    public void LaunchFlightCentre() {      	
//  This will initialize all element locator of the class and return the class as an Object
//    	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
//    	loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
    	
    	driver.get("https://www.flightcentre.com.au/");	
		Reporter.log("Qantas Title :"+driver.getTitle(), true);	
    	if(BrowserName.equalsIgnoreCase("chrome")) {
			Assert.assertEquals(12, 12);
		} else {
			Assert.assertEquals(12, 13);
		}
    }
}