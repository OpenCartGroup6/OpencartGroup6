package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {
    public WebDriver driver;
    
    public Drivers(WebDriver driver){
        this.driver=driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver=driver;
    }
    public WebDriver launchDriver(String browser){
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
        //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            //create chrome instance
            driver = new ChromeDriver();
            return driver;
        }



           
        return driver;
        }
}


