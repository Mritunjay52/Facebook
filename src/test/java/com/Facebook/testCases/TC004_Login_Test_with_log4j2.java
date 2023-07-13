package com.Facebook.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Facebook.pageObjects.LoginPage;
import com.Facebook.testBase.BaseClass;

public class TC004_Login_Test_with_log4j2 extends BaseClass {

	//1.
	//public WebDriver driver;
	public String expTitle = "Facebook";
	
	/*//2. Launching Browser
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}*/
	
	//3. Login into the application
	@Test
	public void loginTest() {
		//driver.get("https://www.facebook.com/login");
		
		logger.info("******TC004_Login_Test_with_log4j2******");
		driver.get(prop.getProperty("url"));
		logger.info("******Application is opened******");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("******Entering Login Details******");
		lp.setUserName(prop.getProperty("username"));
		logger.info("******Username entered is******" +prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		logger.info("******Password entered is******" +prop.getProperty("password"));
		/*lp.setUserName("mritunjay.chauhan42@yahoo.com");
		lp.setPassword("8802159070@Mc");*/
		lp.clickLoginButton();
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if (expTitle.equalsIgnoreCase(actTitle) ) {
			logger.info("******Login Successful******");
			Assert.assertTrue(true);
		} else {
			logger.info("******Login is not Successful******");
			Assert.assertTrue(false);
		}
		logger.info("******Ending Test Case - TC004_Login_Test_with_log4j2******");
	}
	
	/*//4. closing all the browser
	@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
	
}
