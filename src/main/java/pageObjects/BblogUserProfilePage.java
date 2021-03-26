package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogUserProfilePage{
	
	public BblogUserProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath = "//a[@class = 'preview-link']")
	WebElement lbl_article_preview;
	
	private @FindBy (xpath = "//a[@href = '#/profile/ashishpandit/favorites']")
	WebElement btn_favourites;
	
	private @FindBy (xpath = "//a[@href = '#/profile/ashishpandit']")
	WebElement btn_myarticles;
	
	public WebElement lbl_article_preview() {
		return lbl_article_preview;
	}
	public WebElement btn_favourites() {
		return btn_favourites;
	}
	public WebElement btn_myarticles() {
		return btn_myarticles;
	}
}