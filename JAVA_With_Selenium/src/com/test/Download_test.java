package com.test;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Download_page;
import com.pages.Login_page;
import com.pages.Marketplace_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_test {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Download_page d;
	Login_page l;
	Drivers d1;
		
		@BeforeMethod
		public void launchDriver() {

			d1 = new Drivers(driver);
			d = new Download_page(driver);
			l = new Login_page(driver);
			Scanner sc = new Scanner(System.in);
    		String ch = sc.next();
    		driver = d1.launchDriver(ch);
    		driver.get(url);
    		driver.manage().window().maximize();
    		d.setDriver(driver);
    		l.setDriver(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@Test(priority=0)
		@Parameters({"loginEmail","LoginPass","LoginPin"}) 
		public void testDwn(String loginEmail, String LoginPass, String LoginPin){
			
			l.login(loginEmail, LoginPass, LoginPin);
			driver.findElement(By.linkText("Download")).click();
			d.dwn_localhost();

		}
		
		@Test(priority=1)
		@Parameters({"loginEmail","LoginPass","LoginPin"}) 
		public void addExtension(String loginEmail, String LoginPass, String LoginPin){

			l.login(loginEmail, LoginPass, LoginPin);
			driver.findElement(By.linkText("Download")).click();
			d.dwn_extension();
		}
	
		@AfterMethod
		public void quitDriver() {

			driver.quit();
		}

}
