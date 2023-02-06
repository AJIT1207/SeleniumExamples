package selectorshub;

import java.time.Duration;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Selectorshubex {
	//static Logger log = Logger.getLogger(Selectorshubex.class);

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize(); // maximize window
		//		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//This Element is inside single shadow DOM.
	//	String cssSelectorForHost1 = "#userName";
		Thread.sleep(1000);
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector("#userName"));
		WebElement last = (WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
		Thread.sleep(1000);
		last.findElement(By.cssSelector("#concepts")).click();
			
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		
	}

}
