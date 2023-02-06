package selectorshub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Healeniumfirst {
	
	WebDriver driver;
	
	@Test
	public void healniumtest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	//	WebDriver driver1 = new ChromeDriver();
		//declare delegate
		WebDriver delegate = new ChromeDriver();
		//create Self-healing driver
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		
	}

}
