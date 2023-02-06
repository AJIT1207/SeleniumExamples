package pavanonlinetraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlecheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		//1 - select specific checkbox
		
		//select all checkbox
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("size = " + checkboxes.size());
//		
//		for(int i=0;i<checkboxes.size();i++)
//		{
//			checkboxes.get(i).click();
//		}
		
		//specific day
//		for(WebElement ele : checkboxes)
//		{
//			String days = ele.getAttribute("id");
//			if(days.equalsIgnoreCase("monday") || days.equalsIgnoreCase("sunday"))
//			{
//				ele.click();
//			}
//		}
		
		//last 2 checkbox
		
		int totalchk = checkboxes.size();
		
		for(int i=totalchk-7;i<totalchk;i++)
		{
			checkboxes.get(i).click();
		}
		
		driver.quit();
	}
}


//div[normalize-space()='CheckBox & Radio Button practice']//following::label[contains(text(),'Which days of the week are best to start something')]