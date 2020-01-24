package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// For internet explorer ONLy below setting needs to be done
// 1. zoom level should be set to 100%
// 2. Setting  - Internet options - security tab - enable protected mode check box should be checked for all 4 options
// download IE driver from selenium website (https://selenium.dev/downloads/) and paste in the project

//In IE no cssSelector option is available
//ID and Name is available
//Important Tip: create scripts using chrome browser but execution can be done on any browser


// Microsoft Edge driver file is needed only if edge verion is < 18 that can be downloaded from selenium website
// If version is < 18 then go at the bottom of seleium website
// click on Third Party > scroll down and go to microsoft edge driver and download

// if version is =>18 then go to window settings > click on update and security >
// For Developer select Developer mode

import org.testng.annotations.Test;

public class CrossBrowser {

	WebDriver driver;	
	@Test
	public void OpenBrowser() {
		
		//1. Internet Explorer
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://google.ca");
		

		
		//2. Microsoft Edge 
		driver = new EdgeDriver();
		driver.get("https://google.ca");
		
		
		//3. Firefox
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://google.ca");
	
	
	}
	

}
