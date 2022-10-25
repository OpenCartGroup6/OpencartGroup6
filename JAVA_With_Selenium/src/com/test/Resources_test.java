package com.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pages.Resources_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resources_test {
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=common/home";
	Resources_page r;
		
		@BeforeMethod
		public void launchDriver() {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			 r = new Resources_page(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		@Test(priority=0)
		public void showcase()  {
			r.resources();
			r.showcase();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			r.showcase_allStores();
			r.showcase_closthesAppeal();
			r.showcase_techGadgets();
			
		}
		
		
		//To test contact us functionality 
		@Test(priority=1)
		public void contactUs() {
			r.resources();
			r.contactUs();
			r.contactUs_input1();
			r.contactUs_input2();
			r.contactUs_input3();
			r.contactUs_input4();

		}
	
		@Test(priority=2)
		public void partners() {
			r.resources();		
			r.opencartPartner();
			r.openCartPrtnerCountry();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,350)", "");
			r.oc_partner_view();
			driver.navigate().back();
			driver.navigate().back();

		}
		
		//To test add to cart functionality
		@Test(priority=3)
		public void Books()  {
			
			r.resources();
			 r.AddToCart();
		  
		    
		}
		
		
		@Test(priority=4)
		public void git_bug_tracker() {
			r.gitTrack();
		}
		
		
		//To explore forum and check posts
		@Test(priority=5)
		@Parameters({"ForumLoginEmail", "ForumLoginPass"}) 
		public void forums(String ForumLoginEmail, String ForumLoginPass) {
			r.comn_forum(ForumLoginEmail, ForumLoginPass);
		}

		@AfterMethod
		public void quitDriver() {
			driver.quit();
		}

}
