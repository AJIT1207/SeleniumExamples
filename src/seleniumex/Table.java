package seleniumex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\chromedriver.exe");
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
	//	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(getrownumber("Germany"));

	}	
		public static boolean getrownumber(String name)
		{
			
			int rowsize = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
			int columnsize = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
			boolean flag = false;
			for(int i=1;i<rowsize;i++)
			{
				for(int j=1;j<=columnsize;j++)
				{
					String actValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
					if(actValue.equals(name))
					{
						flag = true;
						System.out.println(i + " :" + j);
						break;
					}
				
				}
			}
			if(flag)
			{
				return true;
			}
		
			return flag;
		}
		
	}


	


