package pavanonlinetraining;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handleframes18 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//First Test Case
		
		/*
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageListFrame");
		
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.xpath("//span[normalize-space()='Alert']")).click();
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("classFrame");
		
		driver.findElement(By.xpath("//div[@class='bottomNav']//a[normalize-space()='Help']")).click();
		
		System.out.println("Frame test case is passed");
		
		*/
		//second test case which is in frame under frame
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(outerframe);
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id='Multiple/iframe']")).click();
		
		WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		
		
		Thread.sleep(2000);
		driver.switchTo().frame(innerframe);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("welcome to frame");
		
		

	}

}
