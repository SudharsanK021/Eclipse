package MyTestNGPractice;

import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNG {

	
	@Test
	public void myTest() throws Exception{
		
			WebDriver driver = WebDriverManager.chromedriver().create();
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(5000);
			
			// Assert if the Page is Launched or Not
		
			assertEquals(driver.findElement(By.xpath("//div[@class=\"login_logo\"]")).getText(), "Swag Labs", "The Browser Title is Present");
			
			
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user", Keys.ENTER);
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			Thread.sleep(5000);
			
			
			
			/*
			 Alert passwordAlert = driver.switchTo().alert(); passwordAlert.accept();
			 passwordAlert.accept();
			*/
			
			driver.quit();
			
			
	}
}
