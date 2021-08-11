package com.selenium.practice.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cricbuzz {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.cricbuzz.com/");
		Thread.sleep(4000);
		
		//driver.findElement(By.id("search_bar_menu")).sendKeys("Dravid");
		driver.findElement(By.id("search_bar_menu")).sendKeys("Kumble");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		System.out.println("Print "+ driver.getTitle());
		//driver.findElement(By.xpath("//a[@title='Rahul Dravid']")).click();
		driver.findElement(By.xpath("//a[@title='Anil Kumble']")).click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Rahul Dravid Profile - ICC Ranking, Age, Career Info & Stats | Cricbuzz.com")) {
			System.out.println("Player is Rahul Dravid");
		}
		else if (driver.getTitle().equals("Anil Kumble Profile - ICC Ranking, Age, Career Info & Stats | Cricbuzz.com")) {
			System.out.println("Player is Anil Kumble");
		}
		else {
			System.out.println("Unknown Player");
		}
		
		driver.close();
		
	}

}
