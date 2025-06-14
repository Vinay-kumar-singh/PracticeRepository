package POMClasses;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ButtonClass {
@FindBy(xpath = "//a[contains(text(),' Click ')]")
private WebElement buttonClick;
@FindBy(xpath = "//button[contains(text(),'Goto Home')]")
private WebElement gotoHomeButton;
@FindBy(id = "position")
private WebElement positionButton;
@FindBy(id = "color")
private WebElement colorButton;	
@FindBy(id = "property")
private WebElement propertyButton;
@FindBy(xpath = "//button[@title='Disabled button']")
private WebElement disabledButton;
@FindBy(xpath= "//button[@id='isDisabled']/div/h2")
private WebElement holdButton;
WebDriver driver;
Actions act=new Actions(driver);

public ButtonClass(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	buttonClick.click();
}
public void getGotoHomeButton() {
	gotoHomeButton.click();
	driver.navigate().back();
	}
		public String getPositionButton() {
			Point point=positionButton.getLocation();
			int xcord=point.getX();
			int ycord=point.getY();
			return point.toString();
		}
public String getColorButton() {
			String color=colorButton.getCssValue("color");
			return color;
		}
		public String getPropertyButton() {
			return propertyButton.getSize().toString();
		}
		public boolean isDisabledButton() {
			return disabledButton.isEnabled();
		}
		public void holdButton() {
			act.clickAndHold(holdButton).pause(java.time.Duration.ofSeconds(3)).release().perform();
		}
}