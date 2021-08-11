package com.selenium.practice.basics;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Profile']"))).perform();
		driver.findElement(By.xpath("//a[text()='login / Signup']")).click();
		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("8147028313");
		
		/*act.moveToElement(driver.findElement(By.xpath("//a[@data-group='men']"))).perform();
		driver.findElement(By.xpath("//a[@href='/men-tshirts']")).click();
		
		WebElement scrollDown  = driver.findElement(By.xpath("//li[@class='pagination-paginationMeta']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguements[0].scrollIntoView()", scrollDown);
		
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@value='price_desc']")).click();
		driver.findElement(By.xpath("//input[@value='Country of Origin']")).click();
		driver.findElement(By.className("common-checkboxIndicator")).click();*/
	
	}
}
