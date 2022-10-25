package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Blog_page {
	static final Logger log = LogManager.getLogger(Blog_page.class.getName());
	WebDriver driver ;
	By search_bar = By.name("filter_search");
	By cont_button = By.xpath("//a[@class='btn btn-primary hidden-xs']");	
	By trending = By.linkText("OpenCart Version 3.0.0.0 Available to Download Now");
	

	public Blog_page(WebDriver driver) {
			 this.driver = driver;

	}

	 public void setDriver(WebDriver driver) {
	        this.driver=driver;
	    }
	
	
	public void SearchBox(String search_word)  {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
				log.info("searching the given keyword in blog..");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(search_bar).sendKeys(search_word);
				driver.findElement(search_bar).sendKeys(Keys.ENTER);
				js.executeScript("window.scrollBy(0,750)", "");
				driver.findElement(cont_button).click();
				js.executeScript("window.scrollBy(0,250)", "");
				js.executeScript("window.scrollBy(0,250)", "");

	}
	public void TrendingBlog() {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(trending).click();
		log.info("reading trending blogs..");
		
	}
	
}
