package MyTestNGPractice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class AnnotationRealExample {
	
	WebDriver driver;
	
	@Test
	public void assertionMethod() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);

	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		
		// Initialize WebDriver
		driver = WebDriverManager.chromedriver().create();

		driver.get("https://www.saucedemo.com/");
		
	}
	
	

	@AfterSuite
	public void afterSuite() {
		
		// Quit Browser
		driver.quit();
		
	}

}
