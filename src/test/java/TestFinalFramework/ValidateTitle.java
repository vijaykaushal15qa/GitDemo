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

public class ValidateTitle extends BaseClass
{ // extending the base class.
	
	LandingPage lp;
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());

@BeforeTest
public void initialize() throws IOException
	{
		 driver=initializeDriver();
		 log.info("Driver is Initialized");
		 
		 driver.get(prop.getProperty("url"));	
		 log.info("Navigated to Home Page");
	}
	
@Test
public void TitleCheck() throws IOException
{
	 
	 // There are two methods to access objects and function of other classes. One way is inheritance and the other way is to create an object of the class of which function
	 //and methods you want to use in the current class.
	 
	 lp=new LandingPage(driver);// Passing local driver which has knowledger of chrome driver.
	 lp.closepopup().click();
	 Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
	 log.info("Title Validation Successful");	 
}

@Test
public void validateHeader() throws IOException
{
	 	
	Assert.assertEquals(lp.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	log.info("Header Validation Successful");
	
}


@AfterTest
public void teardown()
{
	driver.close();
	driver=null;// This is done to save memory.

}

}
