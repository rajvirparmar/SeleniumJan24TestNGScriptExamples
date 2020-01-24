package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserSequentialExecutionExample {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser") //string browser is a parameter to the below method. define browser is a parameter with @parameters(browser) for testNG
	//TestNG.xml file is needed to send value of the browser parameter and to run script multiple times
	
	public void openApplication(String browser) {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // no need of this line; Since this is already in another class of the same project 
		//WebDriver driver = new ChromeDriver();
		
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.monsterindia.com/"); 
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
	}
	
	
	@Test (priority=0)// this can have only one validation only for another validation we need another @test and can have as as many @test as required
	
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Vacancy - Latest Job Openings - Job Search Online - Monster India";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	//how to disable any validation (enabled = false), this will skip this test case and will not execute
	@Test (priority=3, enabled = false) //priority is to set the priority of the test case2 to be performed after certain step incase test case 1 has some input for the test case 2 output
	
	public void verifyText() {
		String actualText = driver.findElement(By.cssSelector("#themeDefault > section:nth-child(2) > div > div > div > div.search-content-holder.pr > div.row.search-content > div.col-lg-5 > div > div:nth-child(1) > div > h2")).getText();
		String expectedText = "NEW TO MONSTER?";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (priority=2)
	
	public void verifyLoginBtnVisibility () {
		boolean loginBtnVisible = driver.findElement(By.cssSelector("#seekerLoginBtn > a")).isDisplayed();
		Assert.assertTrue(loginBtnVisible);
	}
	
	@Test (priority=1)
	
	public void verifySearchBtnEnable () {
		boolean SearchBtnEnabled = driver.findElement(By.cssSelector("#searchForm > div > div.col-md-2.col-xxs-12.fl.no-padding > input")).isEnabled();
		Assert.assertTrue(SearchBtnEnabled);
	}
	
	
	@AfterTest
	
	public void closeApplication() {
		driver.close();
		
	}
	
	
	
}


