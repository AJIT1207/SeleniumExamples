package seleniumex;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNG {		
	WebDriver driver;
	
	@Test (priority = 0)
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Driver Closed After Testing");
	}
	
	@Test (priority = -1)
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
        Reporter.log("Launching Google Chrome Driver version 81 for this test"); 
        
        driver.get("https://www.demoqa.com");
        SoftAssert softassert = new SoftAssert();
        Reporter.log("The website used was DemoQA for this test", true);
        String expectedTitle = "ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation";
        String originalTitle = driver.getTitle();
        softassert.assertEquals(originalTitle, expectedTitle);
        System.out.println("*** Checking For The Second Title ***");
//Checking title for ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation
        softassert.assertEquals(originalTitle, "ToolsQA – Demo Website to Practice Automation – Demo Website to Practice Automation" );
        softassert.assertAll();
        
        
        Assertion asssstttt = new Assertion(); //hard assertion
        
        Assertion softassert1  = new SoftAssert();
        
        
  }
}