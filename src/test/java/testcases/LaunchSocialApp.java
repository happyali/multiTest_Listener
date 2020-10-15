package testcases;
 
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BaseClass;	
 
@Listeners(utility.CustomListeners.class)
public class LaunchSocialApp extends BaseClass  {
	
    @Test
    public void LaunchFacebook() {  	
    	driver.get("https://www.facebook.com/help");
		Reporter.log("Facebook Title :"+driver.getTitle(), true);
    }
    
    @Test
    public void LaunchLinkedIn() {      	
//  This will initialize all element locator of the class and return the class as an Object
//    	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
//    	loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
    	
    	driver.get("https://www.linkedin.com");
		Reporter.log("LinkedIn Title :"+driver.getTitle(), true);
    }
}