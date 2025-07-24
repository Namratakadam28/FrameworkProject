package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class Login extends Base
{
	WebDriver driver;
	 LandingPage landingPage;
	  LoginPage loginPage;
	  AccountPage accountPage ;
   @Given("^Open any Browser$")
   public void open_any_browser() throws Exception
   {
	   driver=initializeDriver();
   }
   @And("^Navigate to Login page$")
  
	   public void navigate_to_login_page() throws Exception
	   {
	   driver.get(prop.getProperty("url"));

		 landingPage = new LandingPage(driver);
		 landingPage.myAccountDropdown().click();
		 landingPage.loginOption().click();
		  Thread.sleep(3000);
		  
		   
	   }
 //  @When("^User enters email as \"([^\"]*)\" and password as \"([^\"]*)\" into the field$")
   @When("^User enters email as (.*) and password as (.*) into the field$")
   public void user_enters_email_as_something_and_password_as_something_into_the_fields(String email, String password) 
   {
	    loginPage = new LoginPage(driver);
		// loginPage.emailAddressField().sendKeys(prop.getProperty("email"));
		 //loginPage.passwordField().sendKeys(prop.getProperty("password"));
	    loginPage.emailAddressField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);

		
   }
   @And("^User clicks on Login button$")
   public void user_clicks_on_login_button()
   {
	   loginPage.loginButton().click();
		    
   }
   @Then("^Verify user is able to successfully login$")
   public void user_is_able_to_successfully_login()
   {
	   accountPage = new AccountPage(driver);
		 
		 Assert.assertTrue(accountPage.newUserAccount().isDisplayed());
		 accountPage.newUserAccount().click();

   }
   @After
   public void closeBrowser()
   {
	   driver.close();
   }
}
