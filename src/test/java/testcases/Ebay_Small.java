package testcases;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;

import pages.BaseClass;

@Listeners(utility.CustomListeners.class)
public class Ebay_Small extends BaseClass {

    String testUrl = "https://ebay.com.au";
    String specFilePath = "gspec_resources/ebay_homepage.gspec";
    int browserSizeLargeW = 1500; int browserSizeLargeH = 1200;
    int browserSizeMediumW = 1152; int browserSizeMediumH = 864;
    int browserSizeSmallW = 950; int browserSizeSmallH = 600;
    int browserSizeiPHxW = 375; int browserSizeiPHxH = 812;

    @BeforeClass
    public void setTestObject(){
        objSingleGalenTest = GalenTestInfo.fromString("Ebay:Home Page | small");
    }
    
    @Test
    public void homePageSmall() throws IOException {
        driver.get(testUrl);
        driver.manage().window().setSize(new Dimension(browserSizeSmallW, browserSizeSmallH));

        LayoutReport objLayoutReport =
                Galen.checkLayout(driver, specFilePath, Arrays.asList("Desktop_Small"));

        objSingleGalenTest.getReport().layout(objLayoutReport, "Ebay: Homepage | iPhone Mobile");
    }
    
	@AfterClass
	public void addGalenReportObject() {
		objGalentestsList.add(objSingleGalenTest);
	}
}