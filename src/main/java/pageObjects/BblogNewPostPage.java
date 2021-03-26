package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogNewPostPage{
	
	public BblogNewPostPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath = "//input[@type = 'text']")
	WebElement txt_article_title;
	
	private @FindBy (xpath = "(//input[@type = 'text'])[2]")
	WebElement txt_article_description;
	
	private @FindBy (xpath = "//textarea[@rows = '5']")
	WebElement txt_article_body;
	
	private @FindBy (xpath = "(//input[@type = 'text'])[3]")
	WebElement txt_enter_tags;
	
	private @FindBy (xpath = "//button[@type = 'button']")
	WebElement btn_pubish_article;
	
	public WebElement txt_article_title() {
		return txt_article_title;
	}
	public WebElement txt_article_description() {
		return txt_article_description;
	}
	public WebElement txt_enter_tags() {
		return txt_enter_tags;
	}
	public WebElement txt_article_body() {
		return txt_article_body;
	}
	public WebElement btn_pubish_article() {
		return btn_pubish_article;
	}
}


