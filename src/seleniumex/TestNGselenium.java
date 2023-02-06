package seleniumex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGselenium {

	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

	}

	@Test
	public void googleTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		int i = 9/0;
	}
	
	@Test(dependsOnMethods="googleTitleTest")
	public void googlelogotest()
	{
		boolean b = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		System.out.println(b);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("close the browser");
		driver.quit();
	}

}
