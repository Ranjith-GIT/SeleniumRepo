package com.selenium.practice.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		Actions act = new Actions(driver);
		//driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		act.sendKeys(Keys.ENTER).build().perform();
		act.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();
		act.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();
		act.moveToElement(driver.findElement(By.linkText("Users"))).click().build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(1500);
		
		WebElement dropdown1 = driver.findElement(By.id("systemUser_userType"));
		Select slct = new Select(dropdown1);
		slct.selectByVisibleText("Admin");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Orange Test");
		driver.findElement(By.id("systemUser_userName")).sendKeys("User5");
			
		WebElement dropdown2 = driver.findElement(By.id("systemUser_status"));
		Select slct1 = new Select(dropdown2);
		slct1.selectByVisibleText("Enabled");
		
		driver.findElement(By.id("systemUser_password")).sendKeys("!234@TestRR##1");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("!234@RestRR##1");
		System.out.println("Incorrect password");
		Thread.sleep(1500);
		driver.findElement(By.id("systemUser_confirmPassword")).clear();
		System.out.println("Cleared field");
		Thread.sleep(3000);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("!234@TestRR##1");
		System.out.println("Correct password");
		//driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		//driver.findElement(By.xpath("//input[@name='btnCancel']")).click();
		System.out.println("User Created");
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("User5");
		System.out.println("Typed the above created UserName");
		driver.findElement(By.xpath("//input[@name='_search']")).click();
		System.out.println("Searching");
		Thread.sleep(5000);
		driver.close();
	}
}
