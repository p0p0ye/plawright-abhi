package GroupPages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
  @Test
  public void f() {
	  
	  
	  SoftAssert assertion = new SoftAssert();
	  System.out.println("test 1 stared");
	  assertion.assertEquals(12, "12");
	  System.out.println("Test 1 complt");
	  assertion.assertAll();
	
	  
	  
	  
  }
}
