package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Marketplace_page {
		static final Logger log = LogManager.getLogger(Marketplace_page.class.getName());
		WebDriver driver;
		By searchbar = By.className("form-control");
		By sortby = By.id("input-sort");
		By ele = By.className("extension-description");
		By buy_button = By.id("button-purchase");
		By modal_body = By.className("modal-body");
		By cont = By.xpath("//button[@id='button-continue']");
		By credit_no = By.id("credit-card-number");
		By exp_year = By.id("expiration-year");
		By month = By.id("expiration-month");
		By cvv = By.id("cvv");
		//xpath changed
		By version = By.cssSelector("div.container div.row div.col-sm-4.col-md-3 div.collapse:nth-child(3) section:nth-child(2) div.form-group:nth-child(2) div.input-group > select.form-control");
		By check1 = By.id("input-vault");
		By check2 = By.id("agree");
		By marketPlace =By.linkText("Marketplace");
		public Marketplace_page(WebDriver driver){
			this.driver=driver;
			
		}
		public void setDriver(WebDriver driver) {
			 this.driver = driver;
		}
		
		public void search() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			log.info("searching for watch..");
			driver.findElement(marketPlace).click();
			driver.findElement(searchbar).sendKeys("watch");
			driver.findElement(searchbar).sendKeys(Keys.ENTER);
		}
		
		public void searchBy_version() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			log.info("searching by version..");
			
			Select drpCountry = new Select(driver.findElement(sortby));
	        drpCountry.selectByVisibleText("Rating");
	         
		}
		public void searchBy_rating() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			log.info("searching by rating..");
			driver.findElement(marketPlace).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,750)", "");
		    Select drpCountry1 = new Select(driver.findElement(version));
		        drpCountry1.selectByVisibleText("2.0.2.0");
		}
		public void buy(String card_no,String pin_no) throws InterruptedException {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			driver.findElement(ele).click();	
			driver.findElement(buy_button).click();
			WebElement modalContainer = driver.findElement(modal_body);
			WebElement modalAcceptButton = modalContainer.findElement(cont);
			modalAcceptButton.click();

			//enter the payment details
			driver.switchTo().frame("braintree-hosted-field-number");
			driver.findElement(credit_no).sendKeys(card_no);
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame("braintree-hosted-field-expirationYear");
			Select drpCountry = new Select(driver.findElement(exp_year));
			drpCountry.selectByVisibleText("2024");
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame("braintree-hosted-field-expirationMonth");
			Select drpCountry1 = new Select(driver.findElement(month));
			drpCountry1.selectByVisibleText("8");
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame("braintree-hosted-field-cvv");
			driver.findElement(cvv).sendKeys(pin_no);
			driver.switchTo().defaultContent();
			
			modalContainer.findElement(check1).click();
			modalContainer.findElement(check2).click();
			modalContainer.findElement(cont).click();
			
			log.info("Payment successful..");
		}
		

}
