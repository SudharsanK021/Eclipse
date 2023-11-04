package dataProviderPackage;

import java.io.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import java.util.Arrays;



////////////////////////////
//This Class explains how to retreive the Testdata from Excel and provide it through DataProvider
////////////////////////////

public class ExcelDataProvider{

	@Test
	@DataProvider(parallel = true)
	//@DataProvider(name="swagLabLoginTestData", indices= {0,1})
	public String[][] swagLabLoginTestData() throws Exception {

		File testFile = new File("./src/test/ResourcesTestData/TestData.xlsx");

		String swagLabLoginTestData [][] = null;

		if(testFile.exists()==true) {

			FileInputStream testFileStream = new FileInputStream(testFile);

			XSSFWorkbook testWorkBook = new XSSFWorkbook(testFileStream);

			XSSFSheet testSheet = testWorkBook.getSheetAt(testWorkBook.getActiveSheetIndex());

			int rowCount = testSheet.getPhysicalNumberOfRows();

			int columnCount = testSheet.getRow(0).getLastCellNum();

			swagLabLoginTestData = new String[rowCount-1][columnCount];

			Row row = null; 

			for (int i = 1; i < rowCount; i++) {

				row = testSheet.getRow(i);

				int columnCountTemp = row.getLastCellNum();

				for (int j = 0; j < columnCountTemp; j++) {

					// Used to retreive data in user specified datatype

					DataFormatter df = new DataFormatter();

					swagLabLoginTestData [i-1][j] = df.formatCellValue(row.getCell(j));


				}



			}

			testWorkBook.close();

			testFileStream.close();

		}

		//		for (String[] temp : swagLabLoginTestData) {
		//			System.out.println("Hello");
		//			System.out.println(Arrays.toString(temp));
		//		}


		return swagLabLoginTestData;

	}
}
