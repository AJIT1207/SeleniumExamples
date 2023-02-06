package seleniumex;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getwindowhandles {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://omayo.blogspot.com/");
		
		String firstwindow = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Open a popup window")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
				Iterator<String> itr = windows.iterator();
				
				while(itr.hasNext())
				{
					String childwindow = itr.next();
					driver.switchTo().window(childwindow);
					
				if(	driver.getTitle().equals("Basic Web Page Title"))
				{
					driver.close();
				}
					
				}
				
				driver.switchTo().window(firstwindow);
				
				driver.close();
		
	}

}
