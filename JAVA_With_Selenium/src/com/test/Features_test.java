package com.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Download_page;
import com.pages.Features_page;
import com.pages.Login_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Features_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com";
    Features_page f;
    Drivers d;
 
	    	@BeforeMethod
	    	public void launchDriver(){
	    	
			
			d = new Drivers(driver);
			f = new Features_page(driver);
			Scanner sc = new Scanner(System.in);
    		String ch = sc.next();
    		driver = d.launchDriver(ch);
    		driver.get(url);
    		driver.manage().window().maximize();
    		f.setDriver(driver);

			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	}

	    	//To test explore functionality
		    @Test(priority=0)
		    public void Read(){
		        	f.explore();
		        }
		    
		    
		    //To test newsletter with valid credential
	        @Test(priority=1)
	        @Parameters({"email_id"})
	        public void newsletterValid(String email_id) {
	        	f.Newsletter(email_id);
	        	try {
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
		        	Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        }
	        
	        //To test newsletter with Invalid credential
	        @Test(priority=2)
	        @Parameters({"invalid_email_id"})
	        public void newsletterInvalid(String invalid_email_id){
	        	
	        	f.Newsletter(invalid_email_id);
	        }
	        
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}

}
