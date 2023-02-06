package pavanonlinetraining;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploadfile31 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.get("https://www.monsterindia.com/");

		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		
		

		Thread.sleep(3000);

		// driver.findElement(By.xpath("(//input[@id='file-upload'])[2]")).sendKeys("C:\\Users\\jajit\\Downloads\\HTLDVAHKKPRPLCRF_Trips_Hotel_Invoice.pdf");

		//Robot class

		WebElement ele = driver.findElement(By.xpath("(//input[@id='file-upload'])"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele); //Click action on the button

		//Robot class
		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection ss = new StringSelection("C:\\Users\\jajit\\Downloads\\BoardingPass.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(2000);
		//CTRL+V	  
		rb.keyPress(KeyEvent.VK_CONTROL); //press on ctrl key
		rb.keyPress(KeyEvent.VK_V);  //Press on CTRL key

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		//Enter
		rb.delay(4000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File uploaded successfully");


	}

}
