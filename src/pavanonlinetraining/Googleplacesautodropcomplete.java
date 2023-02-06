package pavanonlinetraining;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googleplacesautodropcomplete {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Toronto");
		
		String text;
		
		do 
		{
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			text = searchbox.getAttribute("value");
			
			if(text.equals("Toronto, OH, USA"))
			{
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			System.out.println("Test case passed");	
			Thread.sleep(3000);
		}while(!text.isEmpty());
		
		
		
		
	}

}
