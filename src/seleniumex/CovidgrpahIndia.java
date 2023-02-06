package seleniumex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CovidgrpahIndia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1GCEA_enIN883IN883&oq=covind+case&aqs=chrome.1.69i57j0i10i433j0i10i433i457j0i402l2j0i10j0i10i433j0i10j0i10i433l2.4303j0j7&sourceid=chrome&ie=UTF-8");
		driver.manage().window().maximize();
		List<WebElement> graphlist = driver.findElements(By.xpath("(//*[name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		Actions act = new Actions(driver);
		for(WebElement e: graphlist)
		{
			act.moveToElement(e).perform();
			String text  = driver.findElement(By.xpath("//*[@class='ExnoTd']")).getText();
			System.out.println(text);
		}
	}

}
