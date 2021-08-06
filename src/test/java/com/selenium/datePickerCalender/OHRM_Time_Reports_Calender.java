package com.selenium.datePickerCalender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OHRM_Time_Reports_Calender {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driverExecutables\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.id("btnLogin")).click();
	    
	    Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.id("menu_time_viewTimeModule"))).build().perform();
	    act.moveToElement(driver.findElement(By.id("menu_time_Reports"))).build().perform();
	    driver.findElement(By.linkText("Project Reports")).click();
	    
	    WebElement dropdown = driver.findElement(By.id("time_project_name"));
	    Select slct = new Select(dropdown);
	    slct.selectByValue("9");
	    Thread.sleep(3000);
	    slct.deselectByValue("9");
	    
	    
	    driver.findElement(By.name("time[only_include_approved_timesheets]")).click();
	    
	    
	    //To be continued with Date Picker / Calender Activity
	}

}
