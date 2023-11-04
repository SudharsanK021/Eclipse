package dataProviderPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx {

	private WebDriver driver;


	@Test(dataProvider = "MultiDimensionalTestData")
	public void loginFunctionality(String driverName,String browserURL, String username, String password) throws Exception {


		switch (driverName.toLowerCase()) {

		case "chrome" :{

			driver = WebDriverManager.chromedriver().create();	break;

		}
		case "edge" :{
			driver = WebDriverManager.edgedriver().create();	break;
		}
		default:{
			System.err.println("The Driver Type is Invalid");
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






	}


	////////////////////////////
	// This Method acts as Dataset Container / DataProvider Method
	////////////////////////////
	
	@DataProvider(name="MultiDimensionalTestData")
	//@DataProvider()
	public String[][] loginFunctionalityArrayTestData() {

		String dataSet [][] = new String[2][4];

		////////////////////////////
		//TestDataset - 1
		////////////////////////////


		dataSet[0][0] = "chrome";
		dataSet[0][1] = "https://www.saucedemo.com/";
		dataSet[0][2] = "standard_user";
		dataSet[0][3] = "secret_sauce";



		////////////////////////////
		//TestDataset - 2
		////////////////////////////


		dataSet[1][0] = "chrome";
		dataSet[1][1] = "https://www.saucedemo.com/";
		dataSet[1][2] = "performance_glitch_user";
		dataSet[1][3] = "secret_sauce";


		return dataSet;



	}
	
	

	////////////////////////////
	// Iterator Object Array DataProvider
	////////////////////////////
	
	@Test(dataProvider = "IteratorArrayTestData")
	public void loginFunctionalityteratorObject(String[] testData) throws Exception {

		String driverName=testData[0]; 
		String browserURL=testData[1]; 
		String username=testData[2]; 
		String password=testData[3];
		
		switch (driverName.toLowerCase()) {

		case "chrome" :{

			driver = WebDriverManager.chromedriver().create();	break;

		}
		case "edge" :{
			driver = WebDriverManager.edgedriver().create();	break;
		}
		default:{
			System.err.println("The Driver Type is Invalid");
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


	}


	@DataProvider(name ="IteratorArrayTestData")
	public Iterator<String[]> loginFunctionalityIteratorArrayTestData() {

		List<String[]> iteratorObjectArray = new ArrayList<>();

		iteratorObjectArray.add(new String[] {"edge","https://www.saucedemo.com/", "standard_user","secret_sauce"});
		iteratorObjectArray.add(new String[] {"edge","https://www.saucedemo.com/", "performance_glitch_user","secret_sauce"});

		return iteratorObjectArray.iterator();


	}
	
	
	



	@AfterTest()
	public void afterTest() {
		driver.quit();

	}

}
