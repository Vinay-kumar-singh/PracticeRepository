package TestScripts;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Reuse.BaseClass;
public class Dropdown extends BaseClass{
@Test	
	public void Drop()
	{
			WebElement ele=getDriver().findElement(By.xpath("//*[contains(text(),' Drop-Down ')]"));
			wait(ele);
			ele.click();
			WebElement web=getDriver().findElement(By.id("fruits"));
			Select drp=new Select(web);
			drp.selectByVisibleText("Apple");
			List<WebElement> drop=getDriver().findElements(By.xpath("//select[@id='superheros']"));
			for(int i=0;i<drop.size();i++)
			{
				String superhero=drop.get(i).getText().trim();
				System.out.println(superhero);
				if(superhero.equalsIgnoreCase("Daredevil"))
				{
					drop.get(i).click();
					
				}
			}
			List<WebElement> lang=getDriver().findElements(By.id("lang"));
			lang.get(lang.size()-1).click();
			WebElement country=getDriver().findElement(By.id("country"));
			Select count=new Select(country);
			count.selectByValue("India");
	}

}
