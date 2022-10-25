package com.test;

import com.pages.Account_page;
import com.pages.Features_page;
import com.pages.Login_page;

import Base.Drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.commons.io.IOUtils;
//import org.apache.commons.io.IOUtils.read;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

public class Login_test {
	public static WebDriver driver;
    public static String url="https://www.opencart.com/index.php?route=account/login";
    Login_page y;
    Drivers d ;
 
	    	@BeforeMethod
	    	public void launchDriver(){
			d = new Drivers(driver);
			y = new Login_page(driver);
			Scanner sc = new Scanner(System.in);
    		String ch = sc.next();
    		driver = d.launchDriver(ch);
    		driver.get(url);
    		driver.manage().window().maximize();
    		y.setDriver(driver);
			

	    	}
	    	
	    	
	    	//Login with valid credential
	        @Test(priority=0)
	        public void TestCase1()  {
	      
				
				try {
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  	File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");	        
		    		FileInputStream fileinput;
					fileinput = new FileInputStream(src);
					Workbook wb = new XSSFWorkbook(fileinput);	        
		    		XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet2");
			        String username1= Sheet1.getRow(2).getCell(3).getStringCellValue();	        
			        String pass1= Sheet1.getRow(3).getCell(3).getStringCellValue();
			        int pin1 = (int) Sheet1.getRow(4).getCell(3).getNumericCellValue();
			        String pinstring= String.valueOf(pin1);
			        System.out.println(pinstring);
			        y= new Login_page(driver);
			        y.login(username1, pass1, pinstring);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}       
	    	
			
	        }
	
	        //Login with invalid credential 
	        @Test(priority=1)
	        public void TestCase2()  {
	        
				try { driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");	        
		    		FileInputStream fileinput = new FileInputStream(src);	       
		    		Workbook wb;				
					wb = new XSSFWorkbook(fileinput);
					XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet2");
		        	String username2= Sheet1.getRow(6).getCell(3).getStringCellValue();	        
		        	String pass2= Sheet1.getRow(7).getCell(3).getStringCellValue();   
		        	y= new Login_page(driver);
		        	y.getEmail(username2);
			        y.getPassword(pass2);
					y.clickLoginButton();	        	
		     
				}
			 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			 }
	        		
	        }
	       
	        
	       //Login with empty field	
			@Test(priority=2)
	        public void TestCase3()  {
	       
				try {
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 	y= new Login_page(driver);	        		    
					File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");	        
		    		FileInputStream fileinput;
					fileinput = new FileInputStream(src);       
	    		Workbook wb;
					wb = new XSSFWorkbook(fileinput);
					XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet2");
		        	String username3= Sheet1.getRow(10).getCell(3).getStringCellValue();	  		        					
					y.getEmail(username3);
					y.clickLoginButton();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	       }
	
	
			@AfterMethod
			public void quitDriver() {
		    driver.close();
	}
}



