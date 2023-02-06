package pavanonlinetraining;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrapdrpdwn9 {

		public static void main(String[] args) throws InterruptedException {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(options);
			
		//	WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize(); // maximize window
			driver.manage().deleteAllCookies(); // delete all the cookies

			// dynamic waitS
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts();

			driver.get("https://www.hdfcbank.com/");
			
			
			
			Thread.sleep(3000);
			
		//	driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
			
			List<WebElement> producttype = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
			
			System.out.println("Number of options = " + producttype.size());
			
			for(int i=0;i<producttype.size();i++)
			{
				System.out.println(producttype.get(i).getText());
			}
			
			selectdropdownbootstrap(producttype, "Accounts");
			driver.quit();
			
		}		
		public static void selectdropdownbootstrap(List<WebElement> option, String value)
		{
			for(WebElement ptype : option)
			{
				if(ptype.getText().equalsIgnoreCase("HDFC Bank MyCards"))
				{
					ptype.click();
					break;
				}
			}
		
		
		}

}
