package com.pages;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Login_page {
	static final Logger log = LogManager.getLogger(Login_page.class.getName());
	WebDriver driver ;
	By email= By.id("input-email");
	By password = By.id("input-password");
	By loginButton =By.xpath("//button[@type='submit']");
	By pin = By.id("input-pin");
	By logoutButton = By.linkText("Logout");
	public Login_page(WebDriver driver) {
			 this.driver = driver;
		 }
	public void setDriver(WebDriver driver) {
		 this.driver = driver;
	}
	
	//To test login functionality
	public void login(String email_id, String pass, String pin_no ){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("logging into the site..");
		driver.findElement(email).sendKeys(email_id);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		driver.findElement(pin).sendKeys(pin_no);
		driver.findElement(pin).sendKeys(Keys.ENTER);
		log.info("log in successful..");
	}
	
	
		public void getEmail(String textEmail) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			  driver.findElement(email).sendKeys(textEmail);
		 }
		public void getPassword(String textPassword) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(password).sendKeys(textPassword);
		}
		public void clickLoginButton() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(loginButton).click();
		}
		public void logout() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(logoutButton).click();
		}
		

}
