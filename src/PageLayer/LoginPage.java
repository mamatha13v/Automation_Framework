package PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
}
//maintain Repository
@FindBy(name="txtUsername")
WebElement EnterUsername;
@FindBy(name="txtPassword")
WebElement EnterPassword;
@FindBy(name="Submit")
WebElement ClickLogin;
//method for login
public void verifyLogin(String userName,String Password)throws Throwable
{
	this.EnterUsername.sendKeys(userName);
	this.EnterPassword.sendKeys(Password);
	this.ClickLogin.click();
	Thread.sleep(2000);
}
}
