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

import com.pages.Login_page;
import com.pages.Marketplace_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MarketPlace_test {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Marketplace_page m;
	Login_page l;
	Drivers d;
		
		@BeforeMethod
		public void launchDriver() {

			m = new Marketplace_page(driver);
			l = new Login_page(driver);	
			d = new Drivers(driver);
			Scanner sc = new Scanner(System.in);
    		String ch = sc.next();
    		driver = d.launchDriver(ch);
    		driver.get(url);
    		driver.manage().window().maximize();
    		l.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		//To test the search functionality
		@Test(priority=0)
		@Parameters({"loginEmail","LoginPass","LoginPin"}) 
		public void search(String loginEmail, String LoginPass, String LoginPin) {
			
			m = new Marketplace_page(driver);
			l = new Login_page(driver);
			try {
				l.login(loginEmail, LoginPass, LoginPin);
				Thread.sleep(2000);
				m.searchBy_rating();
				m.searchBy_version();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
		
		//to test the buy functionality
		@Test(priority=1)
		@Parameters({"card_no","pin_no","loginEmail","LoginPass","LoginPin"}) 
		public void buy_function(String card_no, String pin_no, String loginEmail, String LoginPass, String LoginPin)  {
			try {
				l.login( loginEmail, LoginPass, LoginPin);
				Thread.sleep(2000);
				m.search();
				m.buy(card_no, pin_no);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
	
		@AfterMethod
		public void quitDriver() {
			driver.quit();
		}

}

