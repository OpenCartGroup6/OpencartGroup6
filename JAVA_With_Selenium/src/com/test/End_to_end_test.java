package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Account_page;
import com.pages.Login_page;
import com.pages.Marketplace_page;
import com.pages.Resources_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_end_test {
	
	static final Logger log = LogManager.getLogger(End_to_end_test.class.getName());
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Account_page a;
	Login_page l;
	Marketplace_page m;
	Resources_page r;
	Drivers d ;
		@BeforeMethod
		public void launchDriver() {
			a = new Account_page(driver);
			l = new Login_page(driver);
			m = new Marketplace_page(driver);
			r = new Resources_page(driver);
			d = new Drivers(driver);
			Scanner sc = new Scanner(System.in);
			String ch = sc.next();
			driver = d.launchDriver(ch);
			
			
//			WebDriverManager.chromedriver().setup();
			driver.get(url);
			driver.manage().window().maximize();

			a.setDriver(driver);
			l.setDriver(driver);
			m.setDriver(driver);
			r.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		@Test
		@Parameters({"username","fname","lname","company","old_pass","new_pass","new_confirm","card_no","pin_no"}) 
		public void testMP(String username,String fname,String lname,String company,String old_pass, String new_pass, String new_confirm, String card_no, String pin_no){
			
	        try {
	        	File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");	        
	    		FileInputStream fileinput;
				fileinput = new FileInputStream(src);
				Workbook wb = new XSSFWorkbook(fileinput);	        
	    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet2");
		        String username1= Sheet1.getRow(2).getCell(3).getStringCellValue();	        
		        String pass1= Sheet1.getRow(3).getCell(3).getStringCellValue();
		        int pin1 = (int) Sheet1.getRow(4).getCell(3).getNumericCellValue();
		        String pinstring= String.valueOf(pin1);
	        
			//login
	        l= new Login_page(driver);
			l.login(username1, pass1, pinstring);
	        
			//edit account details
			driver.findElement(By.linkText("Edit your account details")).click();
			a.accDetails(username,fname,lname,company);
			
			//upload profile photo
			a.profile_valid();

			
			//change password
			a.changepassword(old_pass,new_pass,new_confirm);
			
			//go to marketplace and search
			driver.findElement(By.linkText("Marketplace")).click();
			m.searchBy_rating();
			m.searchBy_version();
			m.search();		
			//buy product
			m.buy(card_no, pin_no);
			driver.navigate().back();			
			//go to resources and add to cart-book

			driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();

		    driver.findElement(By.linkText("OpenCart Books")).click();

		    r.AddToCart();

	        } 
	        catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		    
		}
		
		@AfterMethod
		public void quitDriver() {

			driver.quit();
		}

}
