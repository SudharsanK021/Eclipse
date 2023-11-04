package dataProviderPackage;

import org.testng.annotations.DataProvider;

public class DataProviderTestDataClassEx {


	
	@DataProvider(parallel=true)
	public String[][] dataProviderContainer1() {

		String [][] testData = new String[][]{{"standard_user","secret_sauce","https://www.saucedemo.com/"},
		{"visual_user","secret_sauce","https://www.saucedemo.com/"},
		{"performance_glitch_user","secret_sauce","https://www.saucedemo.com/"}
		};
		
		return testData;
		
	}
}
