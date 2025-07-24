package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class FourTest extends Base
{
 public WebDriver driver;
  @Test
  public void testFour() throws IOException, InterruptedException 
  {
	  System.out.println("test four");
	  driver=initializeDriver();
	  driver.get("http://tutorialsninja.com/demo/");
	  Thread.sleep(2000);
	  Assert.assertTrue(false); //this line written to fail test case intentionally to capture screenshot for failed test case
	//close();
  }
  
  @AfterMethod
  public void closingBrowser()
  {
  
	  driver.close();
  }
  
}
