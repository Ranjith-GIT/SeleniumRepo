package com.selenium.practice.basics;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart_Clocks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Login->Home->Home&Furnitures->Clocks->

		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[text()='Home']")).click();

		Actions act = new Actions(driver);
		// act.moveToElement(driver.findElement(By.xpath("//span[text()='Home &
		// Furniture']"))).perform();
		// Wanted to click on Clocks - But locate madok gothagthilla

		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys("Clocks");
		Thread.sleep(1500);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath(
				"//img[@src='https://rukminim1.flixcart.com/image/612/612/koad9jk0/wall-clock/v/c/1/wall-clock-for-home-wall-clock-10-analog-flipkart-smartbuy-original-imag2rxwyfw44q4q.jpeg?q=70']"))
				.click();

		String fkParent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {
			if (!fkParent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("560064");
				driver.findElement(By.xpath("//span[text()='Check']")).click();
				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();

				File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ss, new File(".\\Screenshots\\Cart.png"));

				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
				Thread.sleep(2500);
				driver.close();
			}
		}
		driver.switchTo().window(fkParent);
		driver.findElement(By.xpath("//div[@class='YUhWwv']")).click();
	}
}
