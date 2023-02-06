package seleniumex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Seleniumfirst {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
	//	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		String verxpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String textxpath = "//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		List<WebElement> barlist = driver.findElements(By.xpath(verxpath));
		System.out.println("size " + barlist.size() );	
		
		Actions act = new Actions(driver);
		for(WebElement e : barlist)
		{
			act.moveToElement(e).perform();
			Thread.sleep(2000);
			String text = driver.findElement(By.xpath(textxpath)).getText();
			System.out.println(text);
		}
			
		driver.quit();
	}

}
