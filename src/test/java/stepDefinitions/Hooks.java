package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;
	public static WebDriverWait wait;
	@Before(order=0)
	public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
       
    }
	
	 @Before(order=1)
     public void launchBrowser()
     {
     driver.get("https://www.yatra.com/");
     wait=new WebDriverWait(driver,Duration.ofSeconds(5));
     }
	 
	 
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriverWait getWait()
	{
		return wait;
	}
	
	
	
}
