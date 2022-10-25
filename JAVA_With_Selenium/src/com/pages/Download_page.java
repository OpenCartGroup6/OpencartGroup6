package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Download_page {
	static final Logger log = LogManager.getLogger(Download_page.class.getName());
	WebDriver driver;
	By dwn = By.linkText("Download");
	By dwn2 = By.xpath("//a[@class='btn btn-primary']");
	By dwn1 = By.xpath("//a[@class='btn btn-success btn-lg btn-block']");
	By extension =By.xpath("//div[contains(text(),'A Carbon Effect variant of the default theme for Opencart')]");

	
	public Download_page(WebDriver driver){
		this.driver=driver;
		
		
	}
	 public void setDriver(WebDriver driver) {
	        this.driver=driver;
	    }
	
	public void dwn_localhost(){
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(dwn).click();
        log.info("localhost file downloaded..");
	}
	
	public void dwn_extension(){
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(extension).click();
		driver.findElement(dwn1).sendKeys(Keys.ENTER);
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(dwn2).click();
		log.info("extension downloaded..");
	}

}
