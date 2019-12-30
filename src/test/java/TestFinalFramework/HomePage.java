package TestFinalFramework;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass{ // extending the base class.
	
	private static Logger log=LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	 
	public void initialize() throws IOException
	{
		 driver=initializeDriver();
	}
	
@Test(dataProvider="getData")// declaring data provider as get Data function for function Base Page Navigation

public void homePageNavigation(String Username, String Password, String text) throws IOException, InterruptedException
{
	

	 // There are two methods to access objects and function of other classes. One way is inheritance and the other way is to create an object of the class of which function
	 //and methods you want to use in the current class.
	
	 driver.get(prop.getProperty("url"));	
	 
	 LandingPage lp=new LandingPage(driver);// Passing local driver which has knowledger of chrom driver.
	 Thread.sleep(6000);
	 
   	 lp.closepopup().click();
	 
	 lp.getLogin().click();// Clicking on Login Button.
	 
	 LoginPage lp1=new LoginPage(driver);
	 
	 lp1.getEmail().sendKeys(Username);
	 lp1.getPwd().sendKeys(Password);
	 //System.out.println(text);
	 log.info(text);
	 lp1.clicLogin().click();
	 System.out.println("GIT DEMO1");
	 System.out.println("GIT DEMO2");
         System.out.println("GIT DEMO3");
	 System.out.println("GIT DEMO4");

	 
}

@DataProvider
public Object[][] getData()
{
	// Row stands for how many different data types tests should run
	// Column stands for how many values for each tests.
	
	
	Object [][]data =new Object[1][3];// Object Array with 1 rows and 3 columns
	// Initializing values for first row data set elements
	data [0][0]="nonrestricteduser@qw.com";
	data [0][1]="password1";
	data [0][2]= "Non Restricted User";
	
	/*
	data [1][0]="restricteduser@qw.com";
	data [1][1]="password1";
	data [1][2]= "Restricted User";
	*/
	
	return data;
}

@AfterTest
public void teardown()
{
	driver.close();
	driver=null;// This is done to save memory.
}

}
