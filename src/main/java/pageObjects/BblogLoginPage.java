package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogLoginPage{
	
	public BblogLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath  = "//a[contains(.,'Sign in')]")
	WebElement btn_navigation_signin;
		
	private @FindBy (xpath = "//input[@placeholder = 'Username']")
	WebElement txt_username;
	
	private @FindBy (xpath = "//input[@placeholder = 'Password']")
	WebElement txt_password;
	
	private @FindBy (xpath = "//button[@type = 'submit']")
	WebElement btn_signin;
	
	public WebElement btn_navigation_signin() {
		return btn_navigation_signin;
	}
	public WebElement txt_username() {
		return txt_username;
	}
	public WebElement txt_password() {
		return txt_password;
	}
	public WebElement btn_signin() {
		return btn_signin;
	}
}



