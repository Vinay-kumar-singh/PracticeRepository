package Reuse;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ReportingClass {
	private static ExtentReports extent;
	private static ExtentSparkReporter reporter;
	private static ExtentTest test;
public static ExtentReports report()
{
	if(extent==null)
		extent=new ExtentReports();
	reporter = new ExtentSparkReporter("C:\\Users\\VI20203655\\eclipse-workspace\\PracticeRepository\\src\\test\\resources\\OutputExtentReport.html");
	reporter.config().setReportName("Automation Testing Report");
	reporter.config().setDocumentTitle("Automation Testing");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Vinay Kumar Singh");
	extent.setSystemInfo("Environment", "Test Environment");
	return extent;
}
public static void createTest(String TestName)
{
	test=report().createTest(TestName);
}
public static ExtentTest getTest()
{
	return test;
}
}
