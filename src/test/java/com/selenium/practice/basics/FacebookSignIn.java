package com.selenium.practice.basics;

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
		driver.findElement(By.partialLinkText("English")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Create")).click();
		Thread.sleep(3000);
		
		/*driver.findElement(By.name("firstname")).sendKeys("Ranj");
		driver.findElement(By.name("lastname")).sendKeys("KMRS");
		driver.findElement(By.xpath("//input[@id='u_3_g_tA']")).sendKeys("8431819415");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Pass@2090");*/
		
		driver.close();
	}

}
