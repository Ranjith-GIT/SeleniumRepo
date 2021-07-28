package com.selenium.practice.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSignIn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
	}

}
