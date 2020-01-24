package demo;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotExample {


	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.newtours.demoaut.com/"); 
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
	}



	@Test
	public void verifyFlightBooking() throws IOException {
		try {
			driver.findElement(By.name("userName")).sendKeys("mercury");
			driver.findElement(By.name("password")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			takeScreenshot();
			
			driver.findElement(By.name("findFlights")).click();
			takeScreenshot();
			
			driver.findElement(By.name("reserveFlights")).click();
			takeScreenshot();
			
			driver.findElement(By.name("passFirst0")).sendKeys("John");
			driver.findElement(By.name("passLast0")).sendKeys("Smith");
			driver.findElement(By.name("creditnumber")).sendKeys("45323569415");
			takeScreenshot();
			
			driver.findElement(By.name("buyFlights")).click();
			takeScreenshot();
			
			String actualText = driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p > font > b > font:nth-child(2)")).getText();
			String expectedText = "Your itinerary has been booked!";
			Assert.assertEquals(actualText, expectedText);
			takeScreenshot(); //this mehtod can be called after any step where ever screenshot is needed 
		}

		catch (Exception ex) {
			takeScreenshot(); //method is being called to get the screenshot
			Assert.fail("Script failed due to exception "+ex); // to fail the test case 
		}
	}

	private void takeScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\Users\\ZANY\\Documents\\Rajvir\\Selenium Traning\\SelJan14\\Screenshots\\SS"+(new Random().nextInt())+".jpg"));
	}

	@AfterTest //(enabled = false)
	public void closeApplication() {
		driver.close();
	}
}
