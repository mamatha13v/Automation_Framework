package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBConstant;

public class FunctionLibrary extends PBConstant{
//method login
	public static boolean verifyLogin(String username,String password)throws Throwable
	{
		driver.findElement(By.xpath(configprop.getProperty("ObjUsername"))).sendKeys(username);
		driver.findElement(By.xpath(configprop.getProperty("ObjPassword"))).sendKeys(password);
		driver.findElement(By.xpath(configprop.getProperty("ObjLogin"))).click();
		Thread.sleep(5000);
		String Expected = "adminflow";
		String Actual = driver.getCurrentUrl();
		if(Actual.toLowerCase().contains(Expected.toLowerCase()))
		{
			Reporter.log("Login Success:::"+Expected+"       "+Actual,true);
			return true;
		}
		else
		{
			Reporter.log("Login Fail:::"+Expected+"       "+Actual,true);
			return false;
		}
	}
	//method for click branches
	public static void clickBranches()throws Throwable
	{
		driver.findElement(By.xpath(configprop.getProperty("ObjBranches"))).click();
		Thread.sleep(5000);
		
	}
	//method for new branch creation
public static boolean verifyNewBranch(String Bname,String Address1,String Address2,
	String Address3,String Area,String zipcode,String Country,String state,String city)throws Throwable	
{
	driver.findElement(By.xpath(configprop.getProperty("ObjnewBranch"))).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath(configprop.getProperty("ObjBranchName"))).sendKeys(Bname);
 driver.findElement(By.xpath(configprop.getProperty("ObjAddress1"))).sendKeys(Address1);
 driver.findElement(By.xpath(configprop.getProperty("ObjAddress2"))).sendKeys(Address2);
 driver.findElement(By.xpath(configprop.getProperty("ObjAddress3"))).sendKeys(Address3);
 driver.findElement(By.xpath(configprop.getProperty("ObjArea"))).sendKeys(Area);
 driver.findElement(By.xpath(configprop.getProperty("Objzipcode"))).sendKeys(zipcode);
 new Select(driver.findElement(By.xpath(configprop.getProperty("ObjCountry")))).selectByVisibleText(Country);
 Thread.sleep(3000);
 new Select(driver.findElement(By.xpath(configprop.getProperty("ObjState")))).selectByVisibleText(state);
  Thread.sleep(3000);
  new Select(driver.findElement(By.xpath(configprop.getProperty("ObjCity")))).selectByVisibleText(city);
  Thread.sleep(3000);
  driver.findElement(By.xpath(configprop.getProperty("ObjSubmit"))).click();
  Thread.sleep(5000);
  //capture alert message
  String ActualAlert =driver.switchTo().alert().getText();
  Thread.sleep(5000);
  driver.switchTo().alert().accept();
  Thread.sleep(5000);
  String Expected ="new branch with";
  if(ActualAlert.toLowerCase().contains(Expected.toLowerCase()))
  {
	  Reporter.log("New Branch Created Success::"+Expected+"     "+ActualAlert,true);
	  return true;
  }
  else
  {
	  Reporter.log("New Branch Fail to Create::"+Expected+"     "+ActualAlert,true);
	  return false;  
  }
}

}





