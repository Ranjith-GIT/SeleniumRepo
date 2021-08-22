package com.selenium.practice.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AzureWebsitesPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.findElement(By.id("name")).sendKeys("RANJITHKMRS");
		driver.findElement(By.id("phone")).sendKeys("8147028314");
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test@2090");
		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("#2090 MIG 3rd Stage 18th B Cross YNK NTWN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(3000);
		
		//WebElement scrollDown = driver.findElement(By.xpath("//div[contains(text(),'DropDown practice')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(3000);
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='custom-select']"));
		Select slct = new Select(dropdown);
		//slct.selectByVisibleText("Potugal");
		//slct.selectByValue("5");
		slct.selectByIndex(4);
		Thread.sleep(3000);
		driver.close();
	}
}
