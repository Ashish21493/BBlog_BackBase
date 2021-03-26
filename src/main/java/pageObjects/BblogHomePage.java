package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogHomePage{
	
	public BblogHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath = "//i[@class = 'ion-compose']")  
	WebElement btn_new_post;
	
	private @FindBy (xpath = "//a[@class = 'navbar-brand']")  
	WebElement btn_home;
	
	private @FindBy (xpath = "//span[@class = 'date']")  
	WebElement lbl_date;
	
	private @FindBy (xpath = "//a[@href = '#/profile/ashishpandit']")
	WebElement btn_user;
	
	private @FindBy (xpath = "//i[@class = 'ion-gear-a']")
	WebElement btn_settings;
	
	private @FindBy (xpath  = "//span[contains(.,'Read more...')]")
	WebElement lbl_article_preview;
	
	private @FindBy (xpath  = "//a[contains(.,'Global Feed')]")
	WebElement btn_global_feed;
	
	private @FindBy (xpath  = "//a[contains(.,'Your Feed')]")
	WebElement btn_your_feed;
	
	private @FindBy (xpath  = "//a[contains(.,'microchip')]")
	WebElement lbl_taglist;
	
	private @FindBy (xpath  = "//h1[contains(.,'BBlog')]")
	WebElement lbl_bbloglogo;
	
	private @FindBy (xpath  = "//a[contains(.,'ashishpandit')]")
	WebElement lbl_update;
	
	public WebElement btn_new_post() {
		return btn_new_post;
	}
	public WebElement btn_home() {
		return btn_home;
	}
	public WebElement lbl_date() {
		return lbl_date;
	}
	public WebElement btn_user() {
		return btn_user;
	}
	public WebElement btn_settings() {
		return btn_settings;
	}
	public WebElement lbl_article_preview() {
		return lbl_article_preview;
	}
	public WebElement btn_global_feed() {
		return btn_global_feed;
	}
	public WebElement btn_your_feed() {
		return btn_your_feed;
	}
	public WebElement lbl_taglist() {
		return lbl_taglist;
	}
	public WebElement lbl_update() {
		return lbl_update;
	}
	public WebElement lbl_bbloglogo() {
		return lbl_bbloglogo;
	}
}

