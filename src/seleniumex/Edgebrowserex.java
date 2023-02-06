package seleniumex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.WebElement;
public class Edgebrowserex {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver","C:\\Users\\jajit\\OneDrive - VMware, Inc\\VMwareCorp\\Documents\\Baseline\\Notes_Daily\\edgedriver_win64\\msedgedriver.exe");
		EdgeOptions op=new EdgeOptions();
		op.setCapability("InPrivate", true);
		WebDriver browser = new EdgeDriver(op);

		browser.get("http://example/login.com");

		WebElement username = browser.findElement(By.name("uname"));
		username.sendKeys("test_user");

		WebElement password = browser.findElement(By.name("psw"));
		password.sendKeys("abcd@1234");

		WebElement btn = browser.findElement(By.name("signIn"));
		btn.click();

	}

}




