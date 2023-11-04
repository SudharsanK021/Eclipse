package MyTestNGPractice;

import org.testng.annotations.Test;

public class MetaGroupingEx {
	  @Test(groups= {"HealthCheck", "MainMetaExample1"})
	  public void meta1() {
		  System.out.println("This is Meta Grouping : Grp1");
		  
	  }
	  
	  
	  @Test(groups= {"HealthCheck", "MainMetaExample2"})
	  public void meta2() {
		  
		  System.out.println("This is Meta Grouping : Grp2");
		  
	  }
	  
	  
	  @Test(groups= {"Common"})
	  public void common() {
		  
		  System.out.println("This is Common Meta Grouping");
		  
	  }
	  
	  @Test
	  public void something() {
		  
		  login("Sudharsan");
		  login("Something");
		  login("SomethingNew");
		  
	  }
	  
	  public void login(String username) {
		  System.out.println(username);
	  }
	  
}
