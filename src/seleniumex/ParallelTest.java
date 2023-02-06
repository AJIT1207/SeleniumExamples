package seleniumex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//TestNG hierarchy 

/*
@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite
 * 
 * */


public class ParallelTest {
	public WebDriver driver;
        @Test
        public void FirefoxTest() {	 
            //Initializing the firefox driver (Gecko)
        	WebDriverManager.firefoxdriver().setup();
    		WebDriver driver = new FirefoxDriver();  
	    driver.get("https://www.demoqa.com"); 
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
	   driver.quit();
         }
 
        @Test
        public void ChromeTest()
        	{ 
        	WebDriverManager.chromedriver().setup();
    		WebDriver driver = new ChromeDriver();
        	driver.get("https://www.demoqa.com"); 
        	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
        	driver.quit();
 	}
}