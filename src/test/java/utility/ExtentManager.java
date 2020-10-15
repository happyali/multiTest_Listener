package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports report;

	public static ExtentReports createInstance(String fileName) {
		
		ExtentSparkReporter extent= new ExtentSparkReporter(fileName);
        report = new ExtentReports();
        report.attachReporter(extent);

        extent.config().setDocumentTitle("DocumentTitle");
        extent.config().setTheme(Theme.DARK);
        extent.config().setReportName("ReportName");
		
//		report.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
		report.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		report.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		return report;
	}

}
