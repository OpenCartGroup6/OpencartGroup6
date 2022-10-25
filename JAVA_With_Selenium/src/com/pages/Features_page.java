package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Features_page {
	static final Logger log = LogManager.getLogger(Features_page.class.getName());
	WebDriver driver ;
	By search_bar = By.name("filter_search");
	By trending = By.linkText("OpenCart Version 3.0.0.0 Available to Download Now");
	By feature = By.linkText("Features");
	By unlimited_tab = By.linkText("Unlimited everything");
	By customer_tab = By.linkText("Customer");
	By shipping_tab = By.linkText("Shipping, Payments and Reports");
	By extension_tab = By.linkText("Extensions");
	By mobile_tab = By.linkText("Mobile & SEO");
	By dev_tab = By.linkText("Developer");
	
	By newsletter = By.name("newsletter");
	By button1 = By.className("input-group-btn");
	By button2 = By.id("button-newsletter");
	By drpdown = By.xpath("//select[@id='fieldjrayki']");
	By other_check = By.id("fieldjrydjiy-3");
	By check1 = By.id("fieldjrayky-0");
	
	
	public Features_page(WebDriver driver) {
			 this.driver = driver;
			
	}
	 public void setDriver(WebDriver driver) {
	        this.driver=driver;
	    }
	
	//To explore features 
	public void explore(){
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(feature).click();
        for(int i=0;i<7;i++) {
        	
        	 js.executeScript("window.scrollBy(0,400)", "");

        }
        js.executeScript("window.scrollBy(0,-2800)", "");
  
        driver.findElement(unlimited_tab).click();
 
        for(int i=0;i<7;i++) {
       	 js.executeScript("window.scrollBy(0,400)", "");
 
       }
        js.executeScript("window.scrollBy(0,-2800)", "");

        
        driver.findElement(customer_tab).click();
 
        for(int i=0;i<6;i++) {
          	 js.executeScript("window.scrollBy(0,400)", "");
   
          }
        js.executeScript("window.scrollBy(0,-2400)", "");       
        driver.findElement(shipping_tab).click();
  
        for(int i=0;i<6;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
         }
        js.executeScript("window.scrollBy(0,-2400)", "");       
        driver.findElement(extension_tab).click();
        for(int i=0;i<7;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");
         }
        js.executeScript("window.scrollBy(0,-2800)", "");      
        driver.findElement(mobile_tab).click();
        for(int i=0;i<7;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");

         }
        js.executeScript("window.scrollBy(0,-2800)", "");       
        driver.findElement(dev_tab).click();

        for(int i=0;i<6;i++) {
         	 js.executeScript("window.scrollBy(0,400)", "");

         }
        js.executeScript("window.scrollBy(0,-2400)", "");

        
	}
	
	//To test News letter function
	public void Newsletter(String email_id){
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("testing newsletter..");
		WebElement email = driver.findElement(newsletter);
        email.sendKeys(email_id);
        WebElement buttn = driver.findElement(button1);
        buttn.click();
        
        Select country = new Select(driver.findElement(drpdown));
        country.selectByVisibleText("India");

        
        driver.findElement(other_check).click();
 
       
        driver.findElement(check1).click();;
 
        
        driver.findElement(button2).click();
 
        log.info("newsletter subscribed..");
	}
	

	
}
