package com.selenium.practice.basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM_Time_ProjectInfor {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Login-->Time-->ProjectInfo-->Customers-->Add(Name,Description)--> Save-->Check&UncheckCreatedCustomer-->TakeScreenshot-->Quit
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		act.moveToElement(driver.findElement(By.id("menu_time_viewTimeModule"))).build().perform();
		act.moveToElement(driver.findElement(By.linkText("Project Info"))).build().perform();
		driver.findElement(By.id("menu_admin_viewCustomers")).click();
		
		File ss1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss1, new File ("./Screenshots/SS1.png"));
		
		driver.findElement(By.name("btnAdd")).click();
		driver.findElement(By.xpath("//input[@id='addCustomer_customerName']")).sendKeys("Opt IT Technologies");
		driver.findElement(By.xpath("//textarea[@id='addCustomer_description']")).sendKeys("This is a Good Company");
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='addCustomer_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='addCustomer_description']")).sendKeys("This is a Good Company to Work with");
		driver.findElement(By.id("btnSave")).click();
		
		File ss2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss2, new File ("./Screenshots/SS2.png"));
		
		Thread.sleep(4000);
		driver.close();
	}
}
