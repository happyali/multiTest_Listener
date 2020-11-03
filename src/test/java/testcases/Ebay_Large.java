package testcases;

import java.io.IOException;
import java.util.Arrays;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;

import pages.BaseClass;

@Listeners(utility.CustomListeners.class)
public class Ebay_Large extends BaseClass {

    String testUrl = "https://ebay.com.au";
    String specFilePath = "gspec_resources/ebay_homepage.gspec";
    int browserSizeLargeW = 1500;
    int browserSizeLargeH = 1200;
    int browserSizeMediumW = 1152;
    int browserSizeMediumH = 864;
    int browserSizeSmallW = 950;
    int browserSizeSmallH = 600;
    int browserSizeiPHxW = 375; 
    int browserSizeiPHxH = 812;

    @BeforeClass
    public void setTestObject(){
        objSingleGalenTest = GalenTestInfo.fromString("Ebay:Home Page | large");
    }
    
    @Test
    public void homePageLarge() throws IOException {
        driver.get(testUrl);
        driver.manage().window().setSize(new Dimension(browserSizeiPHxW, browserSizeiPHxH));

        LayoutReport objLayoutReport =
                Galen.checkLayout(driver, specFilePath, Arrays.asList("Desktop_Large"));

        objSingleGalenTest.getReport().layout(objLayoutReport, "Ebay: Homepage | Android Tab");
    }
    
	@AfterClass
	public void addGalenReportObject() {
		objGalentestsList.add(objSingleGalenTest);
	}
	
}