package pavanonlinetraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


//This program is to check the sorted and unsorted in dropdown 
public class Checkdropdownsorted11 {

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

		driver.get("https://www.twoplugs.com");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click(); //live posting
		
		WebElement drpElement = driver.findElement(By.xpath("//select[@name='category_id']"));
		
		Select drpselect = new Select(drpElement);
		
		List<WebElement> options1 = drpselect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList templist = new ArrayList();
		
		for(WebElement option : options1)
		{
			originalList.add(option.getText());
			templist.add(option.getText());
		}
		
		System.out.println("Original list = " + originalList);
		System.out.println("Temp list = " + templist);
		
		
		Collections.sort(templist);  //sorting
		
		
		System.out.println("Original list after sorting = " + originalList);
		System.out.println("Temp list after sorting = " + templist);
		
		if(originalList.equals(templist))
		{
			System.out.println("Dropdown sorted "  );
		}
		else
		{
			System.out.println("DropDown unsorted " );
		}
	}

}
