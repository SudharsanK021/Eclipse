package dataProviderPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabExcelTestCase {

	private WebDriver driver;

	@Test(dataProvider = "swagLabLoginTestData" , dataProviderClass = ExcelDataProvider.class)
	public void validateLogin(String browserURL, String browserType, String username, String password) throws Exception {

		System.out.println("\nEXECUTION STARTED......");



		////////////////////////////
		// Browser Driver Initialization
		////////////////////////////


		switch (browserType.toLowerCase()) {

		case "chrome" :{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	break;
		}
		case "edge" :{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	break;
		}
		default:{
			System.err.println("The Driver TYpe is Invalid");
			break;

		}
		}

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
		
		driver.close();


	}
	
	
//	@AfterTest
//	public void afterTest() {
//		System.out.println("Quit Browser.......");
//		driver.quit();
//	}
	

}
