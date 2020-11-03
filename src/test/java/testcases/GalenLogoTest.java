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
public class GalenLogoTest extends BaseClass {
	
    String testUrl = "http://www.swtestacademy.com/";
    String specFilePath = "gspec_resources/logoTest.gspec";
    int browserSizeLargeW = 1500;
    int browserSizeLargeH = 1200;
    int browserSizeMediumW = 1152;
    int browserSizeMediumH = 864;
    int browserSizeSmallW = 950;
    int browserSizeSmallH = 600;

    @BeforeClass
    public void setTestObject(){
        objSingleGalenTest = GalenTestInfo.fromString("SWT Logo");
    }

    @Test
    public void homePageLogoTest() throws IOException {
//    	test=extent.createTest("SWT Homepage | Desktop");
    	driver.get(testUrl);
        driver.manage().window().setSize(new Dimension(browserSizeLargeW, browserSizeLargeH));

        LayoutReport objLayoutReport = 
        		Galen.checkLayout(driver, specFilePath, Arrays.asList("desktop"));

		objSingleGalenTest.getReport().layout(objLayoutReport, "SWT: Logo | Desktop");

//        if (objLayoutReport.errors() > 0)
//        {
//        	Reporter.log("Layout test failed for ebay size test small",true);
//            Assert.fail();
//        }
//        Reporter.log("Layout test PASSED for ebay size test small",true);
    }
    
	@AfterClass
	public void addGalenReportObject() {
		objGalentestsList.add(objSingleGalenTest);
	}
}
