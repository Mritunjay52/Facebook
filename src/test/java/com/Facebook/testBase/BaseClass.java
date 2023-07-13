package com.Facebook.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//1.
		public WebDriver driver;
		public Properties prop; //config
		
		public Logger logger = LogManager.getLogger(this.getClass());
		
		
	//2. Launching Browser
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws IOException {
		/********config.properties code********/
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
			prop.load(fis);
			
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();*/
			if (br.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (br.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Please pass chrome/firefox as browser names");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies(); 
	}
			
	//4. closing all the browser
	@AfterClass
	public void tearDown() {
			driver.quit();
		}
	
	//5.This method is used for capturing the screenshot
	public void captureScreen(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+ testName+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Captured Screenshot");
	}
}
