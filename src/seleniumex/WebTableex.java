package seleniumex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableex {

	public static void main(String[] args) {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		String beforeXpath_company =   "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company = "]/td[1]";

		String beforeXpath_contact =   "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tr"));
		System.out.println("total no. of rows = " + (rows.size()-1));
		int rowcount  = rows.size();
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\Writingtable.xlsx");
		
		for(int i=2; i<=rowcount; i++)
		{
			String actualXpath_company = beforeXpath_company + i + afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);

			String actualXpath_contact = beforeXpath_contact +i + afterXpath_contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);
		}
			
		driver.quit();
	}

}
