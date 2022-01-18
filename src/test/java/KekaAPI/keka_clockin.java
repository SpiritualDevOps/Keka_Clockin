package KekaAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keka_clockin {
	
public WebDriver driver;
	
	
	@BeforeTest
	public void BT() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.keka.com/");
		
	}

	@Test(priority = 0)
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@class='text-secondary text-xs mr-40']")).click();
		driver.findElement(By.id("email")).sendKeys("Enter E-mail Here");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit' and @class='btn btn-danger btn-login btn-google-login']")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='whsOnd zHQkBf']")).sendKeys("Enter Password Here");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
		
		Thread.sleep(23000);
	}
	

	@Test(priority = 1)
	public void clock_in() throws InterruptedException {
		
		Thread.sleep(30000);
		
		WebElement clock_in1 = driver.findElement(By.xpath("//*[@class='btn btn-x-sm mx-4 btn-white']"));
		if (clock_in1.isDisplayed() && clock_in1.isEnabled()) {
			clock_in1.click();
			Thread.sleep(4000);
			
			
//			Alert alert = driver.switchTo().alert();
//			Thread.sleep(2000);
//			//accept() is to click on OK button and dismiss() is to click on CANCEL button.
//		    alert.accept();	
		} 
		
		
	}
	
	@Test(priority = 2)
	public void log_out() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement logout_dropdown = driver.findElement(By.id("top-nav"));
		if (logout_dropdown.isEnabled()) {
			
			logout_dropdown.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[contains(text(),' Logout')]")).click();
					
		}
		
	}
	
	@Test(priority = 3)
	public void browser_close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		
	}

}
