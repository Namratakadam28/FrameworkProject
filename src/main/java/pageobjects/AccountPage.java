package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage
{

   WebDriver driver;
   public AccountPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
//  @FindBy(xpath="//a[@title='Continue']") // will give nosuchelementException
  // @FindBy(className="btn btn-primary") //will give exception InvalidSelector
   @FindBy(xpath="//a[text()='Continue']")
   WebElement newUserAccount;
   public WebElement newUserAccount()
   {
	   return newUserAccount;
   }
}
