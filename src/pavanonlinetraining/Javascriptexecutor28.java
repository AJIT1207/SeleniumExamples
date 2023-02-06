package pavanonlinetraining;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Javascriptexecutor28 {

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
		
	
		driver.get("https://www.google.com");
		 
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("size of cookies = " + cookies.size());
		
		for(Cookie co : cookies)
		{
			System.out.print(co.getValue() +" \n");
		}

		Cookie coe = new Cookie("AJIT", "1234aa");
		driver.manage().addCookie(coe);
		
		System.out.println(coe);
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		Thread.sleep(1000);
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector(cssSelectorForHost1));
		SearchContext last = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
		Thread.sleep(1000);
		last.findElement(By.cssSelector("driver.findElement(By.cssSelector(shadowDomHostElement));"));
	}

}
