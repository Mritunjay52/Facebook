package com.Facebook.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Facebook.pageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Login_Test {

	//1.
	public WebDriver driver;
	public String expTitle = "Facebook";
	
	//2. Launching Browser
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//3. Login into the application
	@Test
	public void loginTest() {
		driver.get("https://www.facebook.com/login");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("mritunjay.chauhan42@yahoo.com");
		lp.setPassword("8802159070@Mc");
		lp.clickLoginButton();
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if (expTitle.equalsIgnoreCase(actTitle) ) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//4. closing all the browser
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
