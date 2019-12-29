package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	

	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	
	private By close_popup_button=By.xpath("//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]");
	
	public WebElement closepopup()
	{
		return driver.findElement(close_popup_button);
		
	}
	
	private By title=By.xpath("//*[@id='content']/div/div/h2");
	
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	private By navbar=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	

	public WebElement getNavigationBar()
	{
		return driver.findElement(navbar);
		
    }
	
	private By header=By.xpath("//*[@id='myCarousel']/div/div/div/div/div[1]/h3");
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
		
    }
}