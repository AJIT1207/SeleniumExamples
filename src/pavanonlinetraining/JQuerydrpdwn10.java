package pavanonlinetraining;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JQuerydrpdwn10 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		SelectChoiceValues(driver, "all");
		
	}
	
	public static void SelectChoiceValues(WebDriver driver, String...value)
	{
		List<WebElement> choicelist = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item: choicelist)
			{
				String text = item.getText();
				
				for(String val : value)
				{
					if(text.equals(val))
					{
						item.click();
					}
				}
			}
		}
		else
		{
			try {
			for(WebElement item : choicelist)
			{
				item.click();
			}
			}
			catch(Exception e)
			{
				System.out.println("Exception caught in catch block");
			}
		}

	}

}
