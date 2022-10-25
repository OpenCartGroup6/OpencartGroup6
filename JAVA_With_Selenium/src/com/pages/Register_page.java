package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register_page {
	
	static final Logger log = LogManager.getLogger(Register_page.class.getName());
	WebDriver driver;
	By username = By.id("input-username");
	By firstname = By.id("input-firstname");
	By lastname = By.id("input-lastname");
	By email_id = By.id("input-email");
	By country = By.id("input-country");
	By password = By.id("input-password");
	By button = By.cssSelector("button[type='submit']");
	By register_btn = By.xpath("//a[@class='btn btn-black navbar-btn']");
	
	public Register_page(WebDriver driver){
		this.driver=driver;
		
	} public void setDriver(WebDriver driver) {
        this.driver=driver;
    }

	public void register(String usernameV, String firstNameV, String lastNameV, String emailV, String passwordV){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(register_btn).click();
		driver.findElement(username).sendKeys(usernameV);
		driver.findElement(firstname).sendKeys(firstNameV);
		driver.findElement(lastname).sendKeys(lastNameV);
		driver.findElement(email_id).sendKeys(emailV);
		Select country1 = new Select(driver.findElement(country));
        country1.selectByVisibleText("India");
		driver.findElement(password).sendKeys(passwordV);
		driver.findElement(button).click();
	}
}
