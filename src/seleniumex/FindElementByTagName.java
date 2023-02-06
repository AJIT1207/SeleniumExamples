package seleniumex;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class FindElementByTagName {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, AWTException {		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");

	      //create object of chrome options
      //  ChromeOptions options = new ChromeOptions();
        
        //add the headless argument
      //  options.addArguments("headless");
        
        //pass the options parameter in the Chrome driver declaration
     //   WebDriver driver = new ChromeDriver();
			WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://demoqa.com/links");
	      
	   //   String url1="";
	      List<WebElement> url1 = driver.findElements(By.tagName("a"));
	      System.out.println("size of links are = " + url1.size());
	      
	      for(int i=0;i<url1.size();i++)
	      {
	    	  WebElement ele = url1.get(i);
	    	  String urlresponse = ele.getAttribute("href");
	    	  verifyURL(urlresponse);
	      }
	      driver.close();
	}
	public static void verifyURL(String linkURL)
	{
		try
		{
			URL urlresponse = new URL(linkURL);
			
			HttpURLConnection httpURLConnect = (HttpsURLConnection)urlresponse.openConnection(); 
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				System.out.println(linkURL+ " - " + httpURLConnect.getResponseMessage() + " is a broke link");
			}
			else{
                System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }
   }
}
		
	      
	      
//	      Iterator<WebElement> iterator = url1.iterator();
//	      while(iterator.hasNext())
//	      {
//	    	  String links = iterator.next().getText();
//	    	  System.out.println("Links are = " + links);
//	    	  
//	      }
	      
