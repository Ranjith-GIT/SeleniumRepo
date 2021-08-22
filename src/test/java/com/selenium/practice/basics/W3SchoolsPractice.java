package com.selenium.practice.basics;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3SchoolsPractice {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/");
		driver.findElement(By.id("navbtn_tutorials")).click();
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File W3STutSs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(W3STutSs, new File (".\\Screenshots\\TutorialsList.png"));
		
		String test = driver.findElement(By.xpath("//h3[text()='Programming']")).getText();
		System.out.println(test);
		if (test=="Programming") {
			System.out.println("Proceed");
		}
		else {
			System.out.println("Check Manually");
		}
		
		driver.findElement(By.xpath("//a[text()='Learn Java']")).click();
		
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("//a[text()='Try it Yourself »']")).click();
				
		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int winCount = allWindows.size();
		System.out.println(winCount);
		
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				
				driver.findElement(By.xpath("//button[text()='Run »']"));
				
				driver.switchTo().frame(driver.findElement(By.id("iframe")));
				System.out.println(driver.findElement(By.id("iframeResult")).getText());
			}
		}
	}
}
