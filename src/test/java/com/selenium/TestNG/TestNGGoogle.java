package com.selenium.TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGGoogle {
	
	@Test
	public void TestGoogle () {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 
		driver.get("https://www.w3schools.com/default.asp");
		String ActualResult = driver.getCurrentUrl();
		System.out.println(ActualResult);
		String ExpectedResult = "https://www.w3schools.com/default.sp";
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ActualResult, ExpectedResult);
		
		driver.close();
		System.out.println("Closed");
		
		sa.assertAll();
	}
}
