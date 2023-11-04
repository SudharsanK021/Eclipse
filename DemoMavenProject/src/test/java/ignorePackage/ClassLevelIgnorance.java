package ignorePackage;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


/*
 * This is example of Class Level Ignore
 */

@Ignore
public class ClassLevelIgnorance {
	  @Test
	  public void Test1() {
		  System.out.println("Test1");
	  }
	  public void Test2() {
		  System.out.println("Test2");
	  }
	  public void Test3() {
		  System.out.println("Test3");
	  }
	  public void Test4() {
		  System.out.println("Test4");
	  }
	}
