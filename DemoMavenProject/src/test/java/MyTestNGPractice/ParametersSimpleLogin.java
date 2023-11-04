package MyTestNGPractice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ParametersSimpleLogin {

	private WebDriver driver;



	@Parameters({"username","password","browserHeader"})	
	@Test
	public void validateLogin(String username, String password, String browserHeader) throws Exception {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		String siteHeader = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
		
		Thread.sleep(3000);
		
		//Assert The "Swag Labs" Title
		assertEquals(siteHeader,browserHeader, "The Site Login is a failure");
		
		System.out.println("Site Login has been successfull");


	}
	
	@Test
	public void validateHomePage() {

		String siteHeader = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();

		String productGroup = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();

		//Assert The "Swag Labs" and "Product" Titles

		assertEquals(siteHeader,"Swag Labs", "The Site Login is a failure");
		assertEquals(productGroup,"Products", "The Site HomePage Load is a failure");



	}
	
	/*
	 * In "beforeTest"method parameter list Iam passing driverType as "chrome" as Optional Parameter
	 */
	

	@Parameters({"driverType","browserURL"})
	@BeforeTest
	public void beforeTest(@Optional("chrome") String driverName, String browserURL) {

		switch (driverName.toLowerCase()) {

		case "chrome" :{
			driver = WebDriverManager.chromedriver().create();	break;
		}
		case "edge" :{
			driver = WebDriverManager.edgedriver().create();	break;
		}
		default:{
			System.err.println("The Driver TYpe is Invalid");
			break;

		}
		}

		driver.get(browserURL);


	}

	@AfterTest
	public void afterTest() {

			driver.quit();

	}

}
