package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Login_page;
import com.pages.Register_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_test {
	
	static final Logger log = LogManager.getLogger(Register_test.class.getName());
	WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Register_page r;
	Login_page l;
		
		@BeforeMethod
		public void launchDriver() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			r = new Register_page(driver);

		}
		
		//To test register with valid credential 
		@Test(priority=1)
		public void RegisterValid(){

		log.info("Testing register with valid credentials...");
		File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");            
		FileInputStream fileinput;
		try {
		fileinput = new FileInputStream(src);         
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet3");
		
		//variables (V=Valid,INV=Invalid)
		String usernameV= Sheet1.getRow(2).getCell(3).getStringCellValue();            
		String lastNameV= Sheet1.getRow(4).getCell(3).getStringCellValue();
		String firstNameV= Sheet1.getRow(3).getCell(3).getStringCellValue();
		String emailV= Sheet1.getRow(5).getCell(3).getStringCellValue();
		String passwordV= Sheet1.getRow(6).getCell(3).getStringCellValue();
		r.register(usernameV,firstNameV,lastNameV,emailV,passwordV);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}  
			
		}
		
//		To test register with Invalid credential 
		@Test(priority=2)
		public void RegisterInValid() {
		try {
		log.info("Testing register with invalid credentials...");
		File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");            
		FileInputStream fileinput = new FileInputStream(src);           
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet3");	
		
		//variables (V=Valid,INV=Invalid)
		String usernameInV= Sheet1.getRow(8).getCell(3).getStringCellValue();            
		String lastNameInV= Sheet1.getRow(10).getCell(3).getStringCellValue();
		String firstNameInV= Sheet1.getRow(9).getCell(3).getStringCellValue();
		String emailInV= Sheet1.getRow(11).getCell(3).getStringCellValue();
		String passwordInV= Sheet1.getRow(12).getCell(3).getStringCellValue();
		r.register(usernameInV,firstNameInV,lastNameInV,emailInV,passwordInV);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
			
		}
		
		//To test register with Empty credential 
		@Test(priority=3)
		public void RegisterEmptyField() {
		try {
		log.info("Testing register with empty credentials...");
		File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");            
		FileInputStream fileinput = new FileInputStream(src);           
		Workbook wb = new XSSFWorkbook(fileinput);            
		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet3");
		//variables (V=Valid,INV=Invalid)
		String usernameInV= Sheet1.getRow(14).getCell(3).getStringCellValue();            
		String lastNameInV= Sheet1.getRow(16).getCell(3).getStringCellValue();
		String firstNameInV= Sheet1.getRow(15).getCell(3).getStringCellValue();
		String emailInV= Sheet1.getRow(17).getCell(3).getStringCellValue();
		String passwordInV= Sheet1.getRow(18).getCell(3).getStringCellValue();
		r.register(usernameInV,firstNameInV,lastNameInV,emailInV,passwordInV);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
			
		}
	
		@AfterMethod
		public void quitDriver() {
			driver.quit();
		}

}