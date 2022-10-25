package com.test;

import com.pages.Blog_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Blog_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com/blog";
    Blog_page b;
    Drivers d;
 
	    	@BeforeMethod
	    	public void launchDriver() {
	    		d = new Drivers(driver);
	    		b = new Blog_page(driver);
	    		Scanner sc = new Scanner(System.in);
	    		String ch = sc.next();
	    		driver = d.launchDriver(ch);
	    		driver.get(url);
	    		driver.manage().window().maximize();
	    		b.setDriver(driver);

			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	}
	  
	        @Test(priority=0)
	        public void Read()  {
	        	b.SearchBox("google");
	        	
	        }
	        
	        @Test(priority=1)
	        public void trendingRead() {
	        	b.TrendingBlog();
	        }
	     
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}
}



