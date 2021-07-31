package com.selenium.practice.basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class OrangeHRM_Admin_JOB {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Login-->Admin-->Job-->Job Titles-->Add(Job Title, Job Description, Note)--> Save-->ScrollToBottom-->TakeScreenshot-->Quit
		//Actions, Select, TakesScreenshot, JavascriptExecutor, Waits
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		System.out.println("Logged In");
		
		//Actions Class
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"))).build().perform();
		act.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
		driver.findElement(By.linkText("Job Titles")).click();
		
		//Screenshot 1 - Before Adding JOB Title
		File ss1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss1, new File("./Screenshots/BeforeCreatingJOBTitle.png"));
		
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver.findElement(By.xpath("//input[@id='jobTitle_jobTitle']")).sendKeys("A6:Senior Test Automation Engineer 1");
		driver.findElement(By.xpath("//textarea[@name='jobTitle[jobDescription]']")).sendKeys("Should have knowledge on Manual&Automation");
		driver.findElement(By.id("jobTitle_note")).sendKeys("Basics of API Testing Gothidre Olledu");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		//Screenshot 2 - After Adding JOB Title
		File ss2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss2, new File("./Screenshots/AfterCreatingJOBTitle.png"));
		
		//Navigation concept
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		/*driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();*/
		
		driver.findElement(By.partialLinkText("Job Title")).click();
		driver.findElement(By.partialLinkText("Job Title")).click();
		Thread.sleep(4000);
		
		//Scrolling concept
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//Screenshot 2 - After Adding JOB Title
		File ss3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss3, new File("./Screenshots/AfterScrollingDown.png"));
		
		String expectedResult = "A6:Senior Test Automation Engineer 1";
		String actualResult = driver.findElement(By.linkText("A6:Senior Test Automation Engineer 1")).getText();
		System.out.println("Actual Result is: "+actualResult);
		System.out.println("Expected Result is: "+ expectedResult);
		
		System.out.println("Finish");
		Thread.sleep(5000);
		driver.close();
	}
}
