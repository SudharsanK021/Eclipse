package dataProviderPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleLoginClass { 


	@Test(dataProvider = "dataProviderContainer1" , dataProviderClass = DataProviderTestDataClassEx.class)
	public void validateLogin(String username, String password, String browserURL) throws Exception {
		
		System.out.println("\nEXECUTION STARTED......");
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.get(browserURL);
		
		

		////////////////////////////
		// Login Functionality
		////////////////////////////


		Thread.sleep(3000);

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		driver.quit();


	}
	
}
