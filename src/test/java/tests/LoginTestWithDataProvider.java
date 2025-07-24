package tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LoginTestWithDataProvider  extends Base
{
    WebDriver driver;
    @Test(dataProvider="getLoginData")
    public void login(String email,String password,String expectedStatus) throws IOException, InterruptedException
	 {
		driver= initializeDriver();
		//driver.get("http://tutorialsninja.com/demo/"); avoiding hardcoding by calling properties method by using get()
		 driver.get(prop.getProperty("url"));
		 
		 LandingPage landingPage = new LandingPage(driver);
		 landingPage.myAccountDropdown().click();
		 landingPage.loginOption().click();
		  Thread.sleep(3000);
		  
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.emailAddressField().sendKeys(prop.getProperty("email"));
		 loginPage.passwordField().sendKeys(prop.getProperty("password"));
		 loginPage.loginButton().click();
		 
		 AccountPage accountPage = new AccountPage(driver);
		 String actualResult;
		 try
		 {
	        accountPage.newUserAccount().isDisplayed();
	        actualResult="Failure";
	        System.out.println("Inside Try Block");
		
		 }
		 catch(Exception e)
		 {
			 System.out.println("Inside Catch Block");
			 actualResult= "Failure";
		 }
		 
		Assert.assertEquals(actualResult, expectedStatus);
		 accountPage.newUserAccount().click();
	  }
		@AfterMethod
		public void closure()
		{
			driver.close();
		}
		@DataProvider
		public Object[][] getLoginData()
		{
			Object[][] data = {{"arun.selenium@gmail.com","Second@123","Failure"},{"dummy@test.com","dummy","Failure"}};
			return data;
		}
	}


