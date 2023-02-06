package pavanonlinetraining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Autosuggessionsdrpdwn12 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().getImplicitWaitTimeout();

		driver.get("https://www.bing.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("Selenium");
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		
		Thread.sleep(9000);
		
		System.out.println("Size of auto suggessions = " +  list.size());
		
		
		
		for(WebElement ele : list)
		{
			if(ele.getText().equalsIgnoreCase("selenium download"))
			{
				ele.click();
				break;
			}
		}
		
		//System.gc();
		
		driver.quit();
}
}
