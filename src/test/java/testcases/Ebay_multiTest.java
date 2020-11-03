package testcases;

import java.io.IOException;
import java.util.Arrays;

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
public class Ebay_multiTest extends BaseClass {

    String testUrl = "https://ebay.com.au";
    String specFilePath = "gspec_resources/ebay_multi.gspec";
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
        objSingleGalenTest = GalenTestInfo.fromString("Ebay:Home Page | multiTest");
    }
    
    @Test
    public void homePageMultiLarge() throws IOException {
        driver.get(testUrl);
        driver.manage().window().setSize(new Dimension(browserSizeLargeW, browserSizeLargeH));

        LayoutReport objLayoutReport =
                Galen.checkLayout(driver, specFilePath, Arrays.asList("Desktop_Large"));

        objSingleGalenTest.getReport().layout(objLayoutReport, "Ebay: Homepage | Desktop");
    }
    
    
    @Test
    public void homePageMultiSmall() throws IOException {
        driver.get(testUrl);
        driver.manage().window().setSize(new Dimension(browserSizeSmallW, browserSizeSmallH));

        LayoutReport objLayoutReport =
                Galen.checkLayout(driver, specFilePath, Arrays.asList("Desktop_Small"));

        objSingleGalenTest.getReport().layout(objLayoutReport, "Ebay: Homepage | Android Mobile");
    }
    
	@AfterClass
	public void addGalenReportObject() {
		objGalentestsList.add(objSingleGalenTest);
	}
}