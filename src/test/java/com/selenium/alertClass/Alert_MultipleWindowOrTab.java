package com.selenium.alertClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alert_MultipleWindowOrTab {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Login to Orange HRM --> Click on OrangeHRM --> Do some activities in Child window and come back to parent window
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println(parentWindow);
		System.out.println(allWindows);
		
		for (String child : allWindows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.partialLinkText("Company"))).build().perform();
				driver.findElement(By.linkText("About Us")).click();
				String title =driver.getTitle();
				System.out.println(title);
				File ss1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ss1, new File ("./Screenshots/newSS1.png"));
				
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		File ss2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss2, new File ("./Screenshots/newSS2.png"));
		
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath("//input[@value='Subscribe']"))).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(3000);
		driver.close();
	}
}
