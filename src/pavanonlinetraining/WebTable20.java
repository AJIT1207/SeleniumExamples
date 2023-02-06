package pavanonlinetraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTable20 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//First Test Case
		
		
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println(rows);

		int cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		System.out.println(cols);
		
		Thread.sleep(3000);
		
		for(int i=2;i<=rows;i++)
		{
			for(int j=1;j<=cols;j++)
			{
				String data  = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data );
				System.out.println("\n");
			}
		}
		
		String name = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]/td[1]")).getText();
		System.out.println(name);
		
		

	}

}
