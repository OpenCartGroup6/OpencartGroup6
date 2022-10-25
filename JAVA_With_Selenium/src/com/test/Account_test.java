package com.test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import com.pages.Account_page;
import com.pages.Login_page;

import Base.Drivers;
import Base.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Account_test {
	
	public static WebDriver driver;
	public static String url="https://www.opencart.com/index.php?route=account/login";
	Account_page a;
	Login_page l;
	ScreenShot s;
	Drivers d;
	
	
	@BeforeTest
	public void launchDriver() {
		a = new Account_page(driver);
		l = new Login_page(driver);
		s= new ScreenShot(driver);
		d = new Drivers(driver);
		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
		driver = d.launchDriver(ch);
		driver.get(url);
		driver.manage().window().maximize();
		a.setDriver(driver);
		l.setDriver(driver);
		s.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=0)
	@Parameters({"username","fname","lname","company","loginEmail","LoginPass","LoginPin"}) 
	public void accountDetail(String username,String fname,String lname,String company,String loginEmail, String LoginPass, String LoginPin)  {

		l.login(loginEmail, LoginPass, LoginPin);
		driver.findElement(By.linkText("Edit your account details")).click();
		a.accDetails(username,fname,lname,company);
		a.profile_valid();
		s.takeSnapShot(driver, ".\\screenshots\\test_accDetail_valid.png") ;


	}
	
	@Test(priority=1)
	@Parameters({"old_pass","new_pass","new_confirm"})
	public void pwchange(String old_pass, String new_pass, String new_confirm)  {
		
		a.changepassword(old_pass,new_pass,new_confirm);
		
	}
	
	@Test(priority=2)
	public void partnerUp()  {

		try {
			
			//xlsx setup
			File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");            
		    FileInputStream fileinput;
			fileinput = new FileInputStream(src);
		    Workbook wb = new XSSFWorkbook(fileinput);            
		    XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet4");

		    
		    //variables (V=Valid,INV=Invalid)
		    String firstNameV= Sheet1.getRow(2).getCell(3).getStringCellValue();            
		    String lastNameV= Sheet1.getRow(3).getCell(3).getStringCellValue();
		    String companyNameV= Sheet1.getRow(4).getCell(3).getStringCellValue();
		    String websiteNameV= Sheet1.getRow(5).getCell(3).getStringCellValue();	   
		    String emailV= Sheet1.getRow(6).getCell(3).getStringCellValue();
		    int telephoneV = (int) Sheet1.getRow(7).getCell(3).getNumericCellValue();   
		    String telephoneVstring= String.valueOf(telephoneV);	    
		    String address1V= Sheet1.getRow(8).getCell(3).getStringCellValue();
		    String address2V= Sheet1.getRow(9).getCell(3).getStringCellValue();
		    String cityNameV= Sheet1.getRow(10).getCell(3).getStringCellValue();
		    int postcodeV = (int) Sheet1.getRow(11).getCell(3).getNumericCellValue();   
		    String postcodeVstring= String.valueOf(postcodeV);
			
		    //login page functionality	    
		    driver.findElement(By.linkText("Edit Partner Information")).click();
		    a.partnerupClear();
		    
		    //test with valid details
		    a.partnerup(firstNameV,lastNameV,companyNameV,websiteNameV,emailV,telephoneVstring,"D",address1V,address2V,cityNameV,postcodeVstring);
		} 
		catch (IOException e) {

			e.printStackTrace();
		}           

	    
	}
	
	@Test(priority=3)
	public void partnerUpInvalid() {

		try {
			
			//xlsx setup
			File src = new File(".\\Resources\\excel\\OpenCartProject.xlsx");            
		    FileInputStream fileinput;
			fileinput = new FileInputStream(src);
		    Workbook wb = new XSSFWorkbook(fileinput);            
		    XSSFSheet Sheet1 = (XSSFSheet) wb.getSheet("Sheet4");
		    
		  
		    
		    String firstNameINV= Sheet1.getRow(13).getCell(3).getStringCellValue();
		    String lastNameINV= Sheet1.getRow(14).getCell(3).getStringCellValue();
		    String companyNameINV= Sheet1.getRow(15).getCell(3).getStringCellValue();
		    String websiteNameINV= Sheet1.getRow(16).getCell(3).getStringCellValue();
		    int telephoneINV = (int) Sheet1.getRow(18).getCell(3).getNumericCellValue();   
		    String telephoneINVstring= String.valueOf(telephoneINV);
		    String address1INV= Sheet1.getRow(19).getCell(3).getStringCellValue();
		    String address2INV= Sheet1.getRow(20).getCell(3).getStringCellValue();
		    String cityNameINV= Sheet1.getRow(21).getCell(3).getStringCellValue();
		    int postcodeINV = (int) Sheet1.getRow(22).getCell(3).getNumericCellValue();   
		    String emailV= Sheet1.getRow(23).getCell(3).getStringCellValue();
		    String postcodeINVstring= String.valueOf(postcodeINV);
		    
		    driver.findElement(By.linkText("Edit Partner Information")).click();
		    a.partnerupClear();
		    
		    //test with invalid details
		    a.partnerup(firstNameINV,lastNameINV,companyNameINV,websiteNameINV,emailV,telephoneINVstring,"D",address1INV,address2INV,cityNameINV,postcodeINVstring);
			s.takeSnapShot(driver, ".\\screenshots\\test_partnerUp_invalid.png") ;
			
		} 
		catch (IOException e) {

			e.printStackTrace();
		}           

	    
	}
	
	@Test(priority=4)
	@Parameters({"username","fname","lname","company","loginEmail","LoginPass","LoginPin"}) 
	public void accDetailInv(String username,String fname,String lname,String company,String loginEmail, String LoginPass, String LoginPin)  {
		//with invalid profile pic
		driver.navigate().back();
		driver.navigate().back();

		driver.findElement(By.linkText("Edit your account details")).click();
		a.accDetails(username,fname,lname,company);
		a.profile_invalid();
		s.takeSnapShot(driver, ".\\screenshots\\test_accDetail_invalid.png") ;

		driver.switchTo().alert().accept();

		
		    
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}	
	
}
