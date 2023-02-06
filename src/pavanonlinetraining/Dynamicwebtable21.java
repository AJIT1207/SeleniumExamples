package pavanonlinetraining;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dynamicwebtable21 {

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
		
		//First Test Case
		
		
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='input-username']")).clear();
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//sales->Order
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)", "");
		
	//	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
		
		//Table
		//finding total no of pages in table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);
		
		int total_pages  = Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		
		System.out.println("Total no. of pages = " + total_pages);
		
		for (int p=1;p<=10;p++)
		{
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println("Active page = " + active_page.getText());
			active_page.click();
			
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Number of rows = " + rows);
			
			for(int r=1;r<=rows;r++)
			{
				String orderId = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();

				System.out.println(orderId+"   "+customerName+"    "+status );
			}
			
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
		}
	}

}
