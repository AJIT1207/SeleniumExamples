package seleniumex;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));

		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		
		List<WebElement> list = driver.findElements(By.xpath("//li/div/div[@role='option']"));
		
		Thread.sleep(4000);
		
		System.out.println("total number of suggestions in search box:::===>" + list.size());
	//	System.out.println(list);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			Thread.sleep(4000);
			
		if(list.get(i).getText().contains("selenium download")){
				list.get(i).click();
				break;
			}
			
		}
		
		driver.quit();
		
	}

}

