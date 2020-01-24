package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	
	//making changes - Jan 24 2020
	
	//in TestNG main method is not used and is 
	//replaced by as annotations
	// 3 annotations used are 
	//@beforetest
	//@aftertest
	//@test
	
	//apply selenium jar files 
	//add TestNG library
	//this will add new library with name TestNG
	//in the ProjectExplorer
	
	// now import @BeforeTest
	//Copy Chromedriver file in the project too
	
	
	//to get the testoutput folder refresh the project
	//index.html, emailable-report.htm & 
	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com"); 
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyFacebookPageTitle() {
		//scope of variable concept
		// need to change //WebDriver driver = new ChromeDriver(); in the above class to make driver variable workable in this class
		String actualTitle = driver.getTitle(); 
		String expectedTitle = "Facebook - Log In or Sign Up";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void closeApplication() {
		driver.close();
	}
	
	//result of running class tab is NOT appearing for me in the console window
	
	
}
