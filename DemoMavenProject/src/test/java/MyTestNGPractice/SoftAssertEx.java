package MyTestNGPractice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 
 * This Class is an Example of Soft Assertion,
 * So eventhough when an Assert fails, it won't throw error until, SoftAssert().assertAll() method is invoked
 * 
 * 
 */

public class SoftAssertEx {
	
	@Test
	 public void testMethod_2() {
		  System.out.println("testMethod2");
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		  System.out.println("beforeMethod_2");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod_2");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("beforeClass_2");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("afterClass_2");
	  }
	  
	  
	  
	  

	@Test
	public void hardAssertionExample() throws Exception{

		SoftAssert soft = new SoftAssert();

		// Initialize WebDriver
		WebDriver driver = WebDriverManager.chromedriver().create();

		// Launch Application in Browser
		driver.get("https://www.saucedemo.com/");


		Thread.sleep(5000);

		// Perform Login
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user", Keys.ENTER);
		Thread.sleep(2000);


		// This is Part of Invalid Login credentials

		//Assert Invalid Username

		String borderColorActual = driver.findElement(By.xpath("//input[@id='user-name']")).getCssValue("border-bottom-color");

		String borderColorExpected = "rgb(226, 35, 26)" ; 

		soft.assertEquals(borderColorActual,borderColorExpected,"The Username Field Border Color is mismatched...");
		
		
		System.out.println("The Border color is matched");



		// Assert URL

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		String currentURL = driver.getCurrentUrl();

		soft.assertNotEquals(currentURL, "https://www.saucedemo.com/inventory.html","User is successfully Logged in...");



		/*
		 * This is where the AssertAll() method is invoked....
		 */

		soft.assertAll("There is an exception that has occured....");

		//System.out.println("Done....");


		driver.quit();




	}

}

