package MyTestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderIndicesEx {

	////////////////////////////
	// Single Dimensional Object Array DataProvider
	////////////////////////////

	@Test(dataProvider="testIndicesData")
	public void test_SingleObject(Object obj) {
		
		System.out.println("Name of the Candidate is>>>"+obj);
	}


	////////////////////////////
	// DataProvider with Indices Attribute Mentioned
	////////////////////////////
	
	@DataProvider(name="testIndicesData", indices={0,1})
	public String[] testWithIndicesObjectData() {
		String [] singleData = new String [] {"Sudharsan" , "Kumar", "Someone"};
		return singleData;
	}



	////////////////////////////
	// DataProvider without Indices Attribute Mentioned
	////////////////////////////
	
	
	@DataProvider(name="testWithoutIndicesData")
	public String[] testWithoutIndicesObjectData() {
		String [] singleData = new String [] {"Sudharsan" , "Kumar", "Someone"};
		return singleData;
	}

}
