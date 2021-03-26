package BackBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BblogArticlePage;
import pageObjects.BblogHomePage;
import pageObjects.BblogLoginPage;
import pageObjects.BblogNewPostPage;
import pageObjects.BblogSettingsPage;
import pageObjects.BblogUserProfilePage;
import projectResources.Base;

public class BblogTest extends Base{	
	@BeforeTest
	public void setDriver() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void applicationLogin() throws Exception {
		BblogLoginPage bblogLogin = new BblogLoginPage(driver);
		
		String bblogURL = property.getProperty("URL");
		String bblogUsername = property.getProperty("username");
		String bblogPassword = property.getProperty("password");
		
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		boolean flag = true;
		
		while(flag){
			driver.get(bblogURL);			
			flag = false;
		}
		
		wait.until(ExpectedConditions.elementToBeClickable( bblogLogin.btn_navigation_signin()));
		
		bblogLogin.btn_navigation_signin().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogLogin.txt_username()));
	        
	    bblogLogin.txt_username().sendKeys(bblogUsername);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(bblogLogin.txt_password()));
	 		
	 	bblogLogin.txt_password().sendKeys(bblogPassword);
	 	
	 	wait.until(ExpectedConditions.elementToBeClickable(bblogLogin.btn_signin()));
	 		
	 	bblogLogin.btn_signin().click();
	}
	
	@Test (priority = 0)
	public void TestPublishArticle() throws IOException, InterruptedException, Exception {
		
		String bblogTitle = property.getProperty("title");
		String newArticleTitle = property.getProperty("articleTitle");
		String newArticleDescription = property.getProperty("articleDescription");
		String newArticleBody = property.getProperty("articleBody");
		String newArticleTags = property.getProperty("articleTags");
		
		BblogHomePage bblogHome = new BblogHomePage(driver);
		BblogNewPostPage bblogNewPost = new BblogNewPostPage(driver);
		BblogArticlePage bblogArticle = new BblogArticlePage(driver);
 		
 		Assert.assertEquals(driver.getTitle(), bblogTitle);
 		
 		bblogHome.btn_new_post().click();
 		
 		bblogNewPost.txt_article_title().sendKeys(newArticleTitle);
 		
 		bblogNewPost.txt_article_description().sendKeys(newArticleDescription);
 		
 		bblogNewPost.txt_article_body().sendKeys(newArticleBody);
 		
 		bblogNewPost.txt_enter_tags().sendKeys(newArticleTags);
 		
 		bblogNewPost.btn_pubish_article().click();

 		Assert.assertEquals(bblogArticle.lbl_validate_article_title().getText(), newArticleTitle);
	}

	@Test (priority = 2)
	public void TestUpdateArticleMyArticleFavouritedArticle() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		String editTitle = property.getProperty("editTitle");
		String editDescription = property.getProperty("editDescription");
		String editArticleBody = property.getProperty("editArticleBody");
		String editTag = property.getProperty("editTag");
		String validateAshish = property.getProperty("validateAshish");
		
		BblogHomePage bblogHome = new BblogHomePage(driver);
		BblogNewPostPage bblogNewPost = new BblogNewPostPage(driver);
		BblogArticlePage bblogArticle = new BblogArticlePage(driver);
		BblogUserProfilePage bblogUserProfile = new BblogUserProfilePage(driver);
	 	
	 	wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_user()));
		
		bblogHome.btn_user().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogUserProfile.btn_favourites()));
		
		bblogUserProfile.lbl_article_preview().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogArticle.btn_edit_article()));
		
		bblogArticle.btn_edit_article().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogNewPost.txt_article_title()));
		
		bblogNewPost.txt_article_title().sendKeys(editTitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogNewPost.txt_article_description()));
 		
 		bblogNewPost.txt_article_description().sendKeys(editDescription);
 		
 		wait.until(ExpectedConditions.elementToBeClickable(bblogNewPost.txt_article_body()));
 		
 		bblogNewPost.txt_article_body().sendKeys(editArticleBody);
 		
 		wait.until(ExpectedConditions.elementToBeClickable(bblogNewPost.txt_enter_tags()));
 		
 		bblogNewPost.txt_enter_tags().sendKeys(editTag);
 		
 		bblogNewPost.btn_pubish_article().click();
 		
 		wait.until(ExpectedConditions.elementToBeClickable(bblogArticle.lbl_validate_author()));
		
		Assert.assertEquals(bblogArticle.lbl_validate_author().getText(), validateAshish);	
	}
	
	@Test (priority = 3)
	public void TestDeleteMyArticlesFavouritedArticles() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		BblogHomePage bblogHome = new BblogHomePage(driver);
		BblogArticlePage bblogArticle = new BblogArticlePage(driver);
		BblogUserProfilePage bblogUserProfile = new BblogUserProfilePage(driver);
	 	
	 	wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_user()));
		
		bblogHome.btn_user().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogUserProfile.btn_favourites()));
		
		bblogUserProfile.lbl_article_preview().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogArticle.btn_delete_article()));
		
		bblogArticle.btn_delete_article().click();
		
		Assert.assertTrue(bblogHome.btn_global_feed().isDisplayed());
	}
	
	@Test (priority = 1)
	public void TestReadArticleYourFeedGlobalFeedPopularTags() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		String validateAshish = property.getProperty("validateAshish");
		String validateDiveBig = property.getProperty("validateDiveBig");
		
		BblogHomePage bblogHome = new BblogHomePage(driver);
		BblogArticlePage bblogArticle = new BblogArticlePage(driver);
 		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_your_feed()));
		
 		bblogHome.btn_your_feed().click();
 		
 		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.lbl_article_preview()));
		
		bblogHome.lbl_article_preview().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_home()));
		
		Assert.assertEquals(bblogArticle.lbl_validate_author().getText(),validateDiveBig);
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_home()));
		
		bblogHome.btn_home().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.lbl_article_preview()));
		
		bblogHome.btn_global_feed().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.lbl_article_preview()));
		
		bblogHome.lbl_article_preview().click();
		
		driver.navigate().refresh();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_home()));
		
		Assert.assertEquals(bblogArticle.lbl_validate_author().getText(), validateAshish);
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_home()));
		
		bblogHome.btn_home().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.lbl_article_preview()));
		
		bblogHome.lbl_taglist().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.lbl_article_preview()));
		
		bblogHome.lbl_article_preview().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogArticle.lbl_validate_author()));
		
		Assert.assertEquals(bblogArticle.lbl_validate_author().getText(), validateAshish);
	}
	
	@AfterMethod
	public void applicationLogout() {
		BblogHomePage bblogHome = new BblogHomePage(driver);
		BblogSettingsPage bblogSettings = new BblogSettingsPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_settings()));
		
 		bblogHome.btn_settings().click();
 		
 		wait.until(ExpectedConditions.elementToBeClickable(bblogHome.btn_settings()));
 		
 		bblogSettings.btn_logout().click();	
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
