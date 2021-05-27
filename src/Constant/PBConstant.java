package Constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class PBConstant {
	public static WebDriver driver;
	public static Properties configprop;
	@BeforeMethod
	public void setUp()throws Throwable
	{
		configprop = new Properties();
		configprop.load(new FileInputStream("//Users//user//eclipse-workspace//Automation_Frameworks//PropertyFile//Environment.properties"));
		if(configprop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "//Users//user//eclipse-workspace//Automation_Frameworks//CommonDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(configprop.getProperty("Url"));
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		else
		{
			try{
			throw new Error("Browser Value is Not Matching");
			}catch (Throwable t)
			{
				System.out.println(t.getMessage());
			}
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	}


