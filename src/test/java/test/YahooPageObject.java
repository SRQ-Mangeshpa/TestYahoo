package test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooPageObject {

	private WebDriver driver;
	@FindBy(how=How.XPATH, xpath="//*[@id='login-username']")
	WebElement emailField;
	
	@FindBy(how=How.XPATH, xpath="//*[@id='login-passwd']")
	WebElement passwordField;
	
	@FindBy(how=How.ID, id="header-mail-button")
	WebElement profileLogo;
	
	@FindBy(how=How.XPATH, xpath="//span[@class='en_N o_h G_e J_x']")
	List<WebElement> emailThreads;

	
	
	
	public YahooPageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterEmail(String emailID)
	{
		waitForVisible(driver, emailField);
		Actions actions=new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");	
	}
	
	public void enterPassword(String password)
	{
		waitForVisible(driver, passwordField);
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		System.out.println("Password entered");
	}

	
	
	
	public void clickEmail(String emailSubject)
	{
		waitForVisible(driver, profileLogo);
	

		for (int i = 0; i < emailThreads.size(); i++) {
			
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email clicked");
				break;
			}
		}
	}
	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(500);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
			driver.findElement(By.id("header-mail-button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}