package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogSettingsPage{
	
	public BblogSettingsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath  = "//button[contains(.,'Or click here to logout.')]")
	WebElement btn_logout;
	
	public WebElement btn_logout() {
		return btn_logout;
	}
}



