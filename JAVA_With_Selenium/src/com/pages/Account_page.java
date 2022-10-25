package com.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Account_page {
	    static final Logger log = LogManager.getLogger(Account_page.class.getName());
		public WebDriver driver ;
		By accDetail= By.linkText("Edit your account details");
		By clear = By.xpath("//button[contains(text(),'Clear')]");
		By name = By.id("input-username");
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By company = By.id("input-company");
		By country = By.id("input-country");
		By browse = By.xpath("//button[contains(text(),'Browse')]");
		By submit = By.xpath("//button[contains(text(),'Submit')]");
		By login_email= By.id("input-email");
		By login_password= By.id("input-password");
		//xpath
		By login_submit= By.xpath("//button[@type='submit']");
		By login_pin= By.id("input-pin");
		By first_name= By.xpath("//input[@id='input-firstname']");
		By last_name= By.id("input-lastname");
		By comp_name= By.id("input-company");
		By website= By.id("input-website");
		By email= By.id("input-email");
		By telephone= By.id("input-telephone");
		By part_type= By.id("input-partner-type");
		By short_desc= By.xpath("//textarea[@id='input-description-short']");
		By long_desc= By.xpath("//textarea[@id='input-description-long']");
		By address1= By.id("input-address-1");
		By address2= By.id("input-address-2");
		By city= By.id("input-city");
		By postcode= By.id("input-postcode");
		By zone= By.id("input-zone");
		//xpath changed
		By terms= By.xpath("//input[@type='checkbox']");
		By terms1= By.xpath("//input[@name='agree']");
		By image = By.xpath("//button[contains(text(),'Clear')]");
		//xpath changed
		By partner_up = By.linkText("Apply to become a partner");
		
		By cp = By.linkText("Change Password");
		By op = By.id("input-current");
		By np = By.id("input-password");
		By npc = By.id("input-confirm");
		By cont = By.xpath("//button[contains(text(),'Continue')]");
		
		public Account_page(WebDriver driver) {
				 this.driver = driver;
		}
		public void setDriver(WebDriver driver) {
			 this.driver = driver;

		}
		
		//To change the password
		public void changepassword (String op1, String np1, String npc1)   {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
					log.info("change the password..");
					driver.findElement(cp).click();
			
					driver.findElement(op).sendKeys(op1);
				
					driver.findElement(np).sendKeys(np1);
				
					driver.findElement(npc).sendKeys(npc1);
				
					driver.findElement(cont).click();
					log.info("Password changed successfully..");						
		}
		
		//To test the acc detail with valid credential 
		public void accDetails(String username,String f_name,String l_name,String comp)   {			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.findElement(name).clear();
			driver.findElement(name).sendKeys(username);
			driver.findElement(fname).clear();
			driver.findElement(fname).sendKeys(f_name);
			driver.findElement(lname).clear();
			driver.findElement(lname).sendKeys(l_name);
			driver.findElement(company).clear();
			driver.findElement(company).sendKeys(comp);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Select drpCountry = new Select(driver.findElement(country));
			drpCountry.selectByVisibleText("France");
		}
		
		//Valid profile picture upload
		public void profile_valid(){

			try {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(clear).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement chooseFile = driver.findElement(browse);
				chooseFile.click();
				Runtime.getRuntime().exec(".\\Resources\\AutoIt\\FileUpload.exe");
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(submit).click();
				log.info("account details edited..");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		
		//Invalid profile picture upload
		public void profile_invalid()  {	

			try {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(clear).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement chooseFile = driver.findElement(browse);
				chooseFile.click();	
				Runtime.getRuntime().exec(".\\Resources\\AutoIt\\FileUpload_invalid.exe");	
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(submit).click();
				log.error("invalid profile photo ..");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		//To clear up the partnerup fields
		public void partnerupClear() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(first_name).clear();
			driver.findElement(last_name).clear();
			driver.findElement(comp_name).clear();
			driver.findElement(website).clear();
			driver.findElement(email).clear();
			driver.findElement(telephone).clear();
			driver.findElement(short_desc).clear();
			driver.findElement(long_desc).clear();
			driver.findElement(address1).clear();
			driver.findElement(address2).clear();
			driver.findElement(city).clear();
			driver.findElement(postcode).clear();
			driver.findElement(image).click();
			log.info("clearing the partnerUp fields..");
		}
		
		//To test the partnerup with validCredential
		public void partnerup(String fname, String lname, String cname, String webname, String mail, String tele, String ptype,
				String ad1, String ad2, String city1, String post) {
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(first_name).sendKeys(fname);
			driver.findElement(last_name).sendKeys(lname);
			driver.findElement(comp_name).sendKeys(cname);
			driver.findElement(website).sendKeys(webname);
			driver.findElement(email).sendKeys(mail);
			driver.findElement(telephone).sendKeys(tele);
			driver.findElement(part_type).sendKeys(ptype);
			driver.findElement(part_type).sendKeys(Keys.ENTER);
			driver.findElement(address1).sendKeys(ad1);
			driver.findElement(address2).sendKeys(ad2);
			driver.findElement(city).sendKeys(city1);
			driver.findElement(postcode).sendKeys(post);
			Select country1 = new Select(driver.findElement(country));
			country1.selectByVisibleText("India");
			driver.findElement(zone).click();
			try {
		
				Select state = new Select(driver.findElement(zone));
				state.selectByVisibleText("Maharashtra");
				driver.findElement(browse).sendKeys(Keys.ENTER);
				Runtime.getRuntime().exec(".\\Resources\\AutoIt\\FileUpload.exe");	
				driver.findElement(submit).click();	
				log.info("PartnerUp updated..");
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}

		
}
