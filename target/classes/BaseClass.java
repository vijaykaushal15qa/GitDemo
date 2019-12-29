package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.io.FileHandler;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	//public static WebDriver driver;// Declaring driver as public so that it can be accessed outside the class.
	// Static helps in maintaining one copy of driver in entire execution, so tests cannot be run in parallel when driver is static.
	// In this framework till now we have created a fresh copy of driver for every test.
	// When tests are to run in an sequential manner then static driver is object is recommended as it saves memory.
	// When multiple are running parallel they cannot share common driver variable and hence static driver variable will cause wierd results in that case.
	// Keeping driver static is not recommended as these days there are requirements to run test in parallel, so removing static from web driver objects for successfully running tests in parallel.
	
	public  WebDriver driver;
	
    public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		 prop=new Properties();// Creating object of property class.
		
		 // Removing the path hard coding by using System.getProperty("user.dir"). This return the path till project level.
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
//String browserName=System.getProperty("browser");// From this statement browser value is taken from the maven command by jenkins instead from the property file.
		
String browserName=prop.getProperty("browser");// From this statement browser value is taken from data.properties property file.
		
		System.out.println(browserName);// Printing the browser name.
		
		
		if(browserName.contains("chrome"))
		{
			// Removing the path hard coding by using System.getProperty("user.dir"). This return the path till project level.
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();// Creating object for chrome option class and passing it to driver.
			
			if(browserName.contains("headless"))
			{
			option.addArguments("headless");// Passing headless argument to chrome option when browser name has headless keyword.
			}
			
			driver= new ChromeDriver(option);
		}
		
		else if (browserName.equals("firefox"))
		{
			// Removing the path hard coding by using System.getProperty("user.dir"). This return the path till project level.
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			 driver= new FirefoxDriver();	
		}
		
		else if (browserName.equals("ie"))
		{
			 driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;	
	}
	
	// Method for Screenshot.
	public void getScreenshot(String result) {
		
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    try {
	        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\vijay_000\\FrameworkScratchE2E\\Screenshots\\"+result+"screenshot.png"));
	    } 
	    catch (WebDriverException e)
	    {

	    } catch (IOException e) {

	    }
		
	}
}
