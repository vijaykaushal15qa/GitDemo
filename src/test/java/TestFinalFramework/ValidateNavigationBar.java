package TestFinalFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseClass;

public class ValidateNavigationBar extends BaseClass{ // extending the base class.

	private static Logger log=LogManager.getLogger(ValidateNavigationBar.class.getName());

@BeforeTest
 
public void initialize() throws IOException
{
	 driver=initializeDriver();
	 driver.get(prop.getProperty("url"));	
}

@Test
public void NavigationBarCheck() throws IOException
{
	 // There are two methods to access objects and function of other classes. One way is inheritance and the other way is to create an object of the class of which function
	 //and methods you want to use in the current class.
	 LandingPage lp=new LandingPage(driver);// Passing local driver which has knowledger of chrom driver.
	 lp.closepopup().click();

	 Assert.assertTrue(lp.getNavigationBar().isDisplayed());// Assert.assertTrue expects true value from statement passed as an argument to it.
	 log.info("Navigation Bar Displayed");
	 
}

@AfterTest

public void teardown()
{
	driver.close();
	driver=null;// This is done to save memory.

}


}
