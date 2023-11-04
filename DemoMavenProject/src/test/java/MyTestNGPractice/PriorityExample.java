package MyTestNGPractice;

import org.testng.annotations.*;

public class PriorityExample {
	
  @Test(priority=-1)
  public void Test_1() {
	  System.out.println("Test_1");
  }
  
  @Test(priority=0)
  public void Test_2() {
	  System.out.println("Test_2");
  }
  
  
  @Test(priority=1)
  public void Test_3() {
	  System.out.println("Test_3");
  }
  
  
  /*
   * Based on ASCII Value, Test_3 will execute first, and then Test_4
   */
  @Test(priority=1)
  public void Test_4() {
	  System.out.println("Test_4");
  }
  
  
  /*
   * This one is default Priority and the value is "0" So will execute after Negative Priorities
  */
  

  @Test
  public void Test_5() {
	  System.out.println("Test_5");
  }
 
  
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
