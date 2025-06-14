package Reuse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseClass {
	 private static WebDriver driver;
    public Actions act;
    
    @BeforeClass
	public static WebDriver getDriver()
	{
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\VI20203655\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in");
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Explore Workspace')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)","");
		js.executeScript("arguments[0].click()",element);
		return driver;
		}
	public void wait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	@AfterTest
	public void flush()
	{
		driver.close();
	}
	
	
}
