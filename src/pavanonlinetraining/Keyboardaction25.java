package pavanonlinetraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Keyboardaction25 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		/*
		 * driver.get("https://the-internet.herokuapp.com/key_presses");
		 * 
		 * Actions act = new Actions(driver); act.sendKeys(Keys.ENTER).perform();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * act.sendKeys(Keys.TAB).perform();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * act.sendKeys(Keys.LEFT).perform();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * act.sendKeys(Keys.RIGHT).perform();
		 * 
		 * Thread.sleep(2000);
		 */
		
		//MultipleKeys
		
		
			driver.get("https://text-compare.com/");
			
			WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
			WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
			
			input1.sendKeys("Welcome to home");
			
			
			Actions act = new Actions(driver); 
			
			//CTRL+A
			Thread.sleep(2000);
			act.keyDown(Keys.CONTROL);
			act.sendKeys("A");
			
			act.keyUp(Keys.CONTROL);
			act.perform();
			
			//ctrl+c
			Thread.sleep(4000);
			act.keyDown(Keys.CONTROL);
			act.sendKeys("C");
			
			act.keyUp(Keys.CONTROL);
			act.perform();
			
			//TAB - shift to input2 box
			Thread.sleep(4000);
			act.sendKeys(Keys.CONTROL);
			act.perform();
						
			//ctrl+v
			Thread.sleep(2000);
			act.keyDown(Keys.CONTROL);
			act.sendKeys("V");
			
			act.keyUp(Keys.CONTROL);
			act.perform();
			
			//compare text
			Thread.sleep(2000);
			
			if(input1.getAttribute("value").equalsIgnoreCase(input2.getAttribute("value")))
				System.out.println("Text copied");
			
			else
				System.out.println("Txt not copied");
		 
	}

}
