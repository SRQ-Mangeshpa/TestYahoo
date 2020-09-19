

package test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import test.YahooPageObject;

public class EmailClick{

	@Test
	public void clickEmail() {


		System.setProperty("webdriver.chrome.driver", "C:/Users/mp/Downloads/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://login.yahoo.com");
		YahooPageObject gp=PageFactory.initElements(driver, YahooPageObject.class);
		gp.enterEmail("rajesh35@yahoo.com");//Replace with your email id
		gp.enterPassword("***");//Replace with your password
		gp.clickEmail("Welcome to Yahoo!");//Replace with email subject you want to click
		driver.close();
		driver.quit();
		
	}

	

	
}