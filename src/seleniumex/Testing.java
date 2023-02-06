package seleniumex;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


		driver.get("https://selectorshub.com/xpath-practice-page/");


		driver.findElement(By.xpath("//label[normalize-space()='Can you enter name here through automation']//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).sendKeys("Ajit");
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		js.executeScript("document.querySelector(\"input[placeholder='Enter Last name']\").disabled = false");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placehold='Enter Last name']")).sendKeys("Jaiswal");

	}

}
