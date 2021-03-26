package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BblogArticlePage{
	
	public BblogArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (xpath = "//div[@class = 'container']/h1")
	WebElement lbl_validate_article_title;
	
	private @FindBy (xpath = "//a[@class = 'author']")
	WebElement lbl_validate_author;
	
	private @FindBy (xpath = "//i[@class = 'ion-edit']")
	WebElement btn_edit_article;
	
	private @FindBy (xpath = "//i[@class = 'ion-trash-a']")
	WebElement btn_delete_article;
	
	private @FindBy (xpath = "//span[@class = 'date']")
	WebElement lbl_date;
	
	public WebElement lbl_validate_article_title() {
		return lbl_validate_article_title;
	}
	public WebElement lbl_validate_author() {
		return lbl_validate_author;
	}
	public WebElement btn_delete_article() {
		return btn_delete_article;
	}
	public WebElement btn_edit_article() {
		return btn_edit_article;
	}
	public WebElement lbl_date() {
		return lbl_date;
	}
}


