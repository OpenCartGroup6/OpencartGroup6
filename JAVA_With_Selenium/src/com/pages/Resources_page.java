package com.pages;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Resources_page {
			
			static final Logger log = LogManager.getLogger(Resources_page.class.getName());
			WebDriver driver;
			By book = By.xpath("//a[contains(text(),'OPENCART GEBRUIKERSGIDS V1.5+')]");
			By ver = By.id("input-option2");
			By domain = By.id("input-option1");
			By cart = By.id("button-cart");
			//xpath changed
			By resource =  By.xpath("//a[@href='#']");
			//xpath change
			By showcase =  By.xpath("//a[@href='https://www.opencart.com/index.php?route=cms/showcase']");
			//xpath
			By viewWebsite = By.xpath("//a[@href='https://www.eclipseorganics.com.au/']");
			By allStores = By.xpath("//a[contains(text(),'All Stores')]");
			By clothesAppeal = By.linkText("Clothes & Apparel");
			By techGadgets = By.xpath("//a[contains(text(),'Tech & Gadgets')]");
			//xpath
			By contactUs =  By.xpath("//a[@href='https://www.opencart.com/index.php?route=support/contact']");
			By contacUsinput1 = By.xpath("//select[@id='input-reason']");
			By contactUsinput2 = By.xpath("//input[@id='input-name']");
			By contactUsinput3 = By.xpath("//input[@id='input-email']");
			By contactUsinput4 = By.xpath("//textarea[@id='input-enquiry']");


			By communityForums = By.xpath("//a[contains(text(),'Community Forums')]");

			//xpath changed
			By opencartPartner = By.xpath("//a[@href='https://www.opencart.com/index.php?route=support/partner']");
			
			By ocPartner_country = By.cssSelector("div.container div.row div.col-sm-4.col-md-3 section:nth-child(1) div.form-group:nth-child(2) > select.form-control");
			//xpath changed		
			By ocPartner_view = By.xpath("//a[@href='https://www.opencart.com/index.php?route=support/partner/info&partner_id=128213&filter_country_id=99']");
			By community = By.xpath("//a[contains(text(),'Community Forums')]");
			By news = By.linkText("News & Announcements");
			By article1 = By.linkText("[LEGAL] EC Court Decision about \"Buy Button\" (and how to name it)");
			By forum_log =  By.xpath("//button [@class='btn btn-primary dropdown-toggle' ]");
			By username = By.id("username");
			By password = By.id("password");
			//xpath changed
			By login_button = By.xpath("//input[@type='submit']");
			//xpath changed			
			By project_oc = By.xpath("//span[@class='hidden-sm hidden-xs']");


			By post = By.linkText("Your posts");
			//xpath changed
			By logout = By.xpath("//button[@class='btn btn-danger btn-block']");   
			By git_tracker = By.linkText("Github Bug Tracker");
			By article2 = By.linkText("Upgrading a 3.x shop to 4.x dosnt respect an already out-of-root storage dir");
		    By opencartBooks = By.linkText("OpenCart Books");
			
		
			public Resources_page(WebDriver driver){
				this.driver=driver;
		
			}
			public void setDriver(WebDriver driver) {
				 this.driver = driver;
			}

			public void AddToCart() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				log.info("opencart books..");
				driver.findElement(opencartBooks).click();
				String parenthandle=driver.getWindowHandle();
				JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("window.scrollBy(0,1500)");
			        driver.findElement(book).click();
			        
			        Set<String> handles=driver.getWindowHandles();
			        for(String handle:handles) {
			            if(!handle.equals(parenthandle)) {
			                driver.switchTo().window(handle);
			                JavascriptExecutor s = (JavascriptExecutor)driver;
			                s.executeScript("window.scrollBy(0,500)");
			                            
			                driver.findElement(ver).sendKeys("1.5.3");
			                driver.findElement(domain).sendKeys("Domain");
			                driver.findElement(cart).click();
			            }
			        }
			        
			        log.info("Book added to cart..");
			        driver.switchTo().window(parenthandle);
				} 
			
			public void resources() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(resource).click();
			}
			public void showcase() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(showcase).click();
				
			}
			public void showcase_viewWEbsite() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(viewWebsite).click();
				
			}
			public void showcase_allStores() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(allStores).click();
				
			}
			public void showcase_closthesAppeal() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(clothesAppeal).click();
				
			}
			public void showcase_techGadgets() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(techGadgets).click();
				
			}
			public void contactUs() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(contactUs).click();
				
			}
			public void communityForums() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(communityForums);
			}

			public void contactUs_input1() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Select input1 = new Select(driver.findElement(contacUsinput1));
			    input1.selectByVisibleText("I would like to report an account issue");
			}
			public void contactUs_input2() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(contactUsinput2).sendKeys("The ShubhAM SHAH");
				
			}
			public void contactUs_input3() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(contactUsinput3).sendKeys("abctp@gmail.com");
			}
			public void contactUs_input4() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(contactUsinput4).sendKeys("I really like to interact with you  I like your idea it is great thankyou plz contact as soon as possible ");
			}
			public void opencartPartner() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(opencartPartner).click();
			}
			public void openCartPrtnerCountry() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Select country1 = new Select(driver.findElement(ocPartner_country));
			    country1.selectByValue("https://www.opencart.com/index.php?route=support/partner&filter_country_id=99");
				
			}
			public void oc_partner_view() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(ocPartner_view).click();
			}
			
			public void comn_forum(String ForumLoginEmail, String ForumLoginPass){
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				driver.findElement(resource).click();
				driver.findElement(community).click();
				js.executeScript("window.scrollBy(0,500)", "");
				driver.findElement(news).click();
				js.executeScript("window.scrollBy(0,350)", "");
				driver.findElement(article1).click();
				js.executeScript("window.scrollBy(0,250)", "");
				js.executeScript("window.scrollBy(0,250)", "");
				js.executeScript("window.scrollBy(0,-500)", "");
				driver.findElement(forum_log).click();
				driver.findElement(username).sendKeys(ForumLoginEmail);
				driver.findElement(password).sendKeys(ForumLoginPass);
				driver.findElement(forum_log).click();
				driver.findElement(post).click();
				js.executeScript("window.scrollBy(0,500)", "");
				js.executeScript("window.scrollBy(0,-500)", "");
				driver.findElement(forum_log).click();
				driver.findElement(logout).click();

			}
			
			public void gitTrack() {
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				JavascriptExecutor js = (JavascriptExecutor)driver;
				driver.findElement(resource).click();
				driver.findElement(git_tracker).click();
				js.executeScript("window.scrollBy(0,400)", "");
				driver.findElement(article2).click();
				js.executeScript("window.scrollBy(0,400)", "");
				js.executeScript("window.scrollBy(0,400)", "");
				js.executeScript("window.scrollBy(0,400)", "");
				js.executeScript("window.scrollBy(0,400)", "");
				driver.navigate().back();

				driver.navigate().back();

			}

}
