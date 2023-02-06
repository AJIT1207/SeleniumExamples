package pavanonlinetraining;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autocompletegoogle12 {

	public static void main(String[] args) throws InterruptedException {

	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.google.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("jav");
		
		List<WebElement> list = driver.findElements(By.xpath("//li/div/div[@role='option']"));
		
		Thread.sleep(12000);
		
		System.out.println("Size of auto suggessions = " +  list.size());
		
		Thread.sleep(5000);
		
		for(WebElement ele : list)
		{
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase("javatpoint"))
			{
				ele.click();
				System.out.println("clicked on expected link");
				Thread.sleep(3000);
				break;
			}
		}
		
	//	driver.quit();

	}

}
