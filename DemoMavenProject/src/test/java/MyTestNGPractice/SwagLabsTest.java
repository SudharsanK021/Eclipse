package MyTestNGPractice;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

/*
 * 
 * Method Names
 * 1. Validate Login
 * 2. AssertHomePage
 * 3. Select a Product
 * 4. AssertCartPage
 * 5. CheckoutProduct
 * 6. ContinueShopping
 */



public class SwagLabsTest {

	private WebDriver driver;
	private String productName;
	private String productPrice;
	private String productCount;




	
	@Test(groups={"HealthCheck","SiteAvailabilityCheck","FunctionalityCheck"}, priority= 1)
	@Parameters({"username","password"})	
	public void validateLogin(String username, String password) throws Exception {
		
		Thread.sleep(3000);

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);


	}

	@Test(groups= {"HealthCheck","SiteAvailabilityCheck","FunctionalityCheck"}, priority= 2)
	@Parameters("browserHeader")
	public void validateHomePage(String browserHeader)  throws Exception {
		
		
		Thread.sleep(3000);
		
		String siteHeader = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();

		String productGroup = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();

		//Assert The "Swag Labs" and "Product" Titles

		assertEquals(siteHeader,browserHeader, "The Site Login is a failure");
		assertEquals(productGroup,"Products", "The Site HomePage Load is a failure");
		
		System.out.println("Login is Successful");


	}
	
	@Test(groups={"FunctionalityCheck"}, priority= 3)
	public void selectProduct() throws Exception {
		
		Thread.sleep(3000);

		productName = driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[1]")).getText();

		productPrice = driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[1]")).getText();
		
		System.out.println("");

		// Add to Cart and Assert Cart Icon
		driver.findElement(By.xpath("(//button[normalize-space()=\"Add to cart\"])[1]")).click();

		productCount = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).getText();

		assertEquals(productCount, "1", "The Product is not Added to Cart!" );
		
		System.out.println("Product Name is : "+productName);
		System.out.println("Product Price is : "+productPrice);

	}

	@Test(groups={"FunctionalityCheck"}, priority= 4)
	public void assertCartPage() throws Exception  {
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();


		String productNameCartPage = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]")).getText();


		String productPriceCartPage = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).getText();

		assertEquals(productName, productNameCartPage , "The Selected Product Name is incorrect, So Product Addition to Cart is Unsuccessfull");
		assertEquals(productPrice, productPriceCartPage , "The Selected Product Price is incorrect, So Product Addition to Cart is Unsuccessfull");

		System.out.println("Product Name selected for Cart is : "+productNameCartPage);
		System.out.println("Product Price selected for Cart is : "+productPriceCartPage);


	}

	@Test(groups={"FunctionalityCheck"}, priority= 5)
	@Parameters("checkoutMessage")
	public void checkoutProduct(String checkoutMessage) throws Exception  {
		
		Thread.sleep(3000);

		driver.findElement(By.id("checkout")).click();

		String checkOutPage = driver.findElement(By.xpath("//span[@class=\"title\"]")).getText();

		assertEquals(checkOutPage,checkoutMessage, "CHeckout Page Load is unsuccessful");

	}
	
	
	@Test(priority=5)
	public void continueShopping() throws Exception  {
		
		Thread.sleep(3000);

		driver.findElement(By.id("continue-shopping")).click();

		System.out.println("User Selected Continue Shopping");


	}
	
	
	@Test
	@Parameters("invalidErrorMessage")
	public void validateInvalidCredentials(String invalidErrorMessage) throws Exception {
		
		Thread.sleep(3000);
		
		String invalidCredentialsError = driver.findElement(By.xpath("//h3")).getText();
		
		assertEquals(invalidErrorMessage, invalidCredentialsError, "The Application accepts invalid credentials!!");
		
		System.out.println("Invalid Error Message Assertion is Success");
		
		
	}


	@Parameters({"driverType","browserURL"})
	@BeforeTest(groups= {"HealthCheck","SiteAvailabilityCheck","FunctionalityCheck"})
	public void beforeTest(@Optional("chrome") String driverName, @Optional("https://www.saucedemo.com/") String browserURL) {

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
		
		driver.manage().window().maximize();
		driver.get(browserURL);


	}
	
	
	@AfterTest(groups= {"HealthCheck","SiteAvailabilityCheck","FunctionalityCheck"})
	public void afterTest() {

		driver.quit();

	}
	

}
