package Reuse;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportingClass.getTest().pass("Test Passed");
		ReportingClass.report().flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ReportingClass.getTest().pass("Test Passed");
		Object TestClass=result.getInstance();
		WebDriver driver=((BaseClass)TestClass).getDriver();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\VI20203655\\eclipse-workspace\\PracticeRepository\\src\\test\\resources\\ErrorScreenshot.png");
		try {
			FileUtils.copyFile(src, destination);
			ReportingClass.getTest().addScreenCaptureFromPath("C:\\Users\\VI20203655\\eclipse-workspace\\PracticeRepository\\src\\test\\resources\\ErrorScreenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReportingClass.report().flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All tests finished.");
	}

}
