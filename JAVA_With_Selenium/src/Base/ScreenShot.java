package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	//Take Screenshot
	 public WebDriver driver;
	    
	    public ScreenShot(WebDriver driver){
	        this.driver=driver;
	    } 
	    public void setDriver(WebDriver driver) {
	        this.driver=driver;
	    }
			public void takeSnapShot(WebDriver webdriver,String fileWithPath) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	    		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    		File DestFile=new File(fileWithPath);
	    		try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		
			}
}
