package MyTestNGPractice;



import org.testng.annotations.Test;


public class InitialGroupEx {
  @Test(groups= {"HealthCheck", "InitialMetaExample1"})
  public void initial1() {
	  System.out.println("This is Initial Grouping : Grp1");
	  
  }
  
  
  @Test(groups= {"HealthCheck", "InitialMetaExample2"})
  public void initial2() {
	  
	  System.out.println("This is Initial Grouping : Grp2");
	  
  }
  
  
  @Test(groups= {"Common"})
  public void common() {
	  
	  System.out.println("This is Common Initial Grouping");
	  
  }
  
  
}
