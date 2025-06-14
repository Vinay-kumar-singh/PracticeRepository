package TestScripts;
import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import POMClasses.ButtonClass;
import Reuse.BaseClass;

public class Button extends BaseClass{
	WebDriver driver=BaseClass.getDriver();
	ButtonClass b1=new ButtonClass(driver);
@Test
	public void gotohomebutton()
	{
	b1.getGotoHomeButton();
	String match=driver.findElement(By.xpath("//h1[normalize-space()='Button']")).getText();
		Assert.assertEquals(match, "Button");
	}
@Test
public void getPosition()
{
	String pos=b1.getPositionButton();
		System.out.println("X & Y Coordinates"+pos);
}
@Test
public void getcolour()
{
		String color=b1.getColorButton();
		System.out.println("Colour is"+" "+color);
}
@Test
public void getdimension()
{
		String dim=b1.getPropertyButton();
		System.out.println(dim);
}
@Test
		public void buttonstatus()
		{boolean status=b1.isDisabledButton();
	if(status==false)
		{
			System.out.println("Button is disabled");
		}
		}
@Test
public void holdButton()
{
b1.holdButton();	

}
}
