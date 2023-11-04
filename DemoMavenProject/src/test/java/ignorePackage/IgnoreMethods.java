package ignorePackage;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

	public class IgnoreMethods {
		
			
		  @Test(enabled=false)
		  public void Test1() {
			  System.out.println("Test1");
		  }
		  
		  @Ignore
		  @Test(enabled=true, priority=1)
		  public void Test2() {
			  System.out.println("Test2");
		  }
		  
		  
		  
		  @Test(priority=2)
		  public void Test3() {
			  System.out.println("Test3");
		  }
		  
		  @Ignore
		  @Test(priority=3)
		  public void Test4() {
			  System.out.println("Test4");
		  }
		}
