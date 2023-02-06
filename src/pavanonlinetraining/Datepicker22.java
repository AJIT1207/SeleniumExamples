package pavanonlinetraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Datepicker22 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		//First Test Case
		
		
		
		driver.get("https://www.redbus.in/");	
		String year="2022";
		String month="May";
		String date="10";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		while(true)
		{
			String data = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[] = data.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))			
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();		
					
		}
		
		//Date selection
		List<WebElement> date1 = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement ele:date1)
		{
			String dt = ele.getText();
			if(date.equalsIgnoreCase(dt))
			{
				ele.click();
				break;
			}
		}
		
		System.out.println("test case is passed");
		
	}

}
