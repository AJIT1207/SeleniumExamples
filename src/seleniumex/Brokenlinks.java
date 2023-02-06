package seleniumex;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class Brokenlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
				//ChromeOptions co = new ChromeOptions();
				//co.addArguments("--headless");
			//	WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();
				
			List<WebElement> urllist = 	driver.findElements(By.tagName("a"));
			
			System.out.println(urllist.size());
			
		
			
			List<String> urladd = new ArrayList<String>();
			
			for (WebElement webElement : urllist) {
				 	String url = webElement.getAttribute("href");
				 	urladd.add(url);
				 	
				 	//	System.out.println(url);
				 	
			}
			driver.quit();	
	}
	
	public static void checkBrokenLink(String linkurl)
	{
		try {
			
			URL brokenurl = new URL();
			HttpURLConnection httpsurlconnection = (HttpURLConnection) brokenurl.openConnection();
			httpsurlconnection.setConnectTimeout(5000);
			httpsurlconnection.connect();
			
			if(httpsurlconnection.getResponseCode() >= 400)
			{
				System.out.println(linkurl + " ---- >" +httpsurlconnection.getResponseMessage() + " is a broken link");
			}
			else
			{
				
			}
			
		} catch (Exception e) {
			
		}
	}
	

}
