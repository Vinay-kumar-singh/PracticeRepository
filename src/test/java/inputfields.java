import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class inputfields extends BaseClass{
@Test
	public void input()
	{
	 login();
		WebElement ele=driver.findElement(By.xpath("//*[contains(text(),' Edit ')]"));
		wait(ele);
		ele.click();
		driver.findElement(By.id("fullName")).click();
		driver.findElement(By.id("fullName")).sendKeys("First Middle Last");
		driver.findElement(By.id("join")).click();
	    act=new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		driver.findElement(By.id("join")).sendKeys("Great");
		String text=driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(text);
		driver.findElement(By.id("getMe")).click();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		WebElement edit=driver.findElement(By.id("noEdit"));
		if(!edit.isEnabled())
		{
			System.out.println("It is Disabled");
		}
		String readonly=driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(readonly);
		flush();
		
		
		
		
	}
}
