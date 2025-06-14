package TestScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Reuse.BaseClass;
public class inputfields extends BaseClass{
@Test
	public void input()
	{
		WebElement ele=getDriver().findElement(By.xpath("//*[contains(text(),' Edit ')]"));
		wait(ele);
		ele.click();
		getDriver().findElement(By.id("fullName")).click();
		getDriver().findElement(By.id("fullName")).sendKeys("First Middle Last");
		getDriver().findElement(By.id("join")).click();
	    act=new Actions(getDriver());
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		getDriver().findElement(By.id("join")).sendKeys("Great");
		String text=getDriver().findElement(By.id("getMe")).getAttribute("value");
		System.out.println(text);
		getDriver().findElement(By.id("getMe")).click();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		WebElement edit=getDriver().findElement(By.id("noEdit"));
		if(!edit.isEnabled())
		{
			System.out.println("It is Disabled");
		}
		String readonly=getDriver().findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(readonly);
		
		
		
		
	}
}
