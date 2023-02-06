package pavanonlinetraining;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Downloadfile30 {

	public static void main(String[] args) throws InterruptedException {
		
		String loc = System.getProperty("user.dir")+"\\Downloads\\";
		HashMap preference = new HashMap();
		preference.put("download.default_directory", loc);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.setExperimentalOption("Pref", preference);
		
	//	WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize(); // maximize window
//		driver.manage().deleteAllCookies(); // delete all the cookies

		// dynamic wait
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	
		 driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 
		 Thread.sleep(4000);
		 
		 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

	}

}
