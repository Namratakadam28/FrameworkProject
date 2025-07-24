package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class ThreeTest extends Base
{
  @Test
  public void testThree() throws InterruptedException, IOException
  {
	  System.out.println("Test three");
	  WebDriver driver= initializeDriver();
	  driver.get("http://tutorialsninja.com/demo/");
	  Thread.sleep(2000);
	  driver.close();
	  
  }
}
