package com.selenium.practice.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignIn {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.facebook.com/");
		driver.getTitle();
		System.out.println("Title is " + driver.getTitle());

		driver.findElement(By.id("email")).sendKeys("ranjithkumarr.33@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("test1234");
		Thread.sleep(5000);
		driver.findElement(By.name("login"));

		Thread.sleep(15000);
		System.out.println("Before Closing");
		Thread.sleep(15000);
		driver.close();
		System.out.println("After Closing");

	}

}
