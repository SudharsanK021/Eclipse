package MyTestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionEx {
	
	@Test
	public void hardAssertionExample() throws Exception{
		
		// Initialize WebDriver
		WebDriver driver = WebDriverManager.chromedriver().create();
		
		// Launch Application in Browser
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
		
		// Perform Login
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user", Keys.ENTER);
		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
//		Thread.sleep(5000);
		
		
		
		// This is Part of Invalid Login credentials
		
		//Assert Invalid Username
		
		String borderColorActual = driver.findElement(By.xpath("//input[@id='user-name']")).getCssValue("border-bottom-color");
		
		String borderColorExpected = "rgb(226, 35, 26)" ; 
		
		assertEquals(borderColorActual,borderColorExpected,"The Username Field Border Color is mismatched");
		
		System.out.println("The Border color is matched");
		
		
		// Assert URL
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String currentURL = driver.getCurrentUrl();
		
		assertNotEquals(currentURL, "https://www.saucedemo.com/inventory.html","User is successfully Logged in");
		
		driver.quit();
		
		
		
		
	}

}
