package testng;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG1 {

			@Test(description="Hello")
			public void setUp() throws IOException
			{
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			WebDriver driver = new ChromeDriver(options);

			driver.manage().window().maximize(); // maximize window
			driver.manage().deleteAllCookies(); // delete all the cookies

			// dynamic wait
			//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

			driver.get("https://www.monsterindia.com/");
			
			//WebElement logo = driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']"));
		//	TakesScreenshot srcshot = (TakesScreenshot) driver;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File trg = new File("Homepage.png");
			FileUtils.copyFile(src, trg);
			
			
			
			driver.close();

}
		
}
