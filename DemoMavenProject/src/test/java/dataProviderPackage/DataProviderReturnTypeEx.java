package dataProviderPackage;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


////////////////////////////
// This Class explains the return type and parameter that can be used for DataProvider
////////////////////////////

public class DataProviderReturnTypeEx {


	////////////////////////////
	// Single Dimensional Object Array DataProvider
	////////////////////////////

	@Test(dataProvider="test_SingleObjectData")
	public void test_SingleObject(Object obj) {
		System.out.println(obj);
	}


	@DataProvider()
	public Object[] test_SingleObjectData() {
		Object [] singleData = new Object [] {"Sudharsan" , 24, "Engineer"};
		return singleData;
	}



	////////////////////////////
	// Multi Dimensional Object Array DataProvider
	////////////////////////////

	@Test(dataProvider="test_MultiObjectData")
	public void test_MultiObject(Object [] obj) {
		for (int i = 0; i < obj.length; i++) {

			System.out.println(obj[i]);
		}
		System.out.println("Length of Object is>>>"+obj.length);

	}


	@DataProvider()
	public Object[][] test_MultiObjectData() {

		Object [][] multiData = new Object [][] {{"Sudharsan" , 24, "Engineer"},
			{"Kumar",25,"Doctor"},{"Someone",26}
		};


		return multiData;

	}



	////////////////////////////
	// Iterator Object DataProvider
	////////////////////////////


	@Test(dataProvider="test_IteratorObjectData")
	public void test_IteratorObject(Object obj) {
		System.out.println(obj);
	}


	@DataProvider()
	public Iterator<Object> test_IteratorObjectData() {

		List<Object> iteratorObject = new ArrayList<>();

		iteratorObject.add("Sudharsan");
		iteratorObject.add("Kumar");
		iteratorObject.add("SK");

		return iteratorObject.iterator();


	}


	////////////////////////////
	// Iterator Object Array DataProvider
	////////////////////////////

	@Test(dataProvider="test_IteratorObjectArrayData")
	public void test_IteratorObjectArray (String[] str) {
		
		for (String string : str) {
			System.out.println(string.toString());
		}
		
	}


	@DataProvider()
	public Iterator<String[]> test_IteratorObjectArrayData() {

		List<String[]> iteratorObjectArray = new ArrayList<>();

		iteratorObjectArray.add(new String[] {"Sudharsan", "Engineer"});
		iteratorObjectArray.add(new String[] {"Kumar", "Doctor"});

		return iteratorObjectArray.iterator();


	}
















}
