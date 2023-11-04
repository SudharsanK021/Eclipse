package MyTestNGPractice;

import org.testng.annotations.Test;

public class SuiteLevelGroupEx {
	  @Test(groups= {"HealthCheck", "SuiteMetaExample1"})
	  public void suite1() {
		  System.out.println("This is SuiteLevel Grouping : Grp1");
		  
	  }
	  
	  
	  @Test(groups= {"HealthCheck", "SuiteMetaExample2"})
	  public void suite2() {
		  
		  System.out.println("This is SuiteLevel Grouping : Grp2");
		  
	  }
	  
	  
	  @Test(groups= {"Common"})
	  public void common() {
		  
		  System.out.println("This is Common Suite Grouping");
		  
	  }
}
