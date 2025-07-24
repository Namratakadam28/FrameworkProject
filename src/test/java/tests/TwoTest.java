package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class TwoTest extends Base
{
   @Test
   public void testTwo() throws IOException, InterruptedException
   {
	   System.out.println("Test Two");
	   WebDriver driver= initializeDriver();
	   driver.get("http://tutorialsninja.com/demo/");
	   Thread.sleep(2000);
	   driver.close();
   }
}
