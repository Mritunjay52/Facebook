package com.Facebook.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Facebook.pageObjects.LoginPage;
import com.Facebook.testBase.BaseClass;

public class TC003_Login_Test_with_ConfigProperties extends BaseClass {

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
		
		
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		/*lp.setUserName("mritunjay.chauhan42@yahoo.com");
		lp.setPassword("8802159070@Mc");*/
		lp.clickLoginButton();
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if (expTitle.equalsIgnoreCase(actTitle) ) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	/*//4. closing all the browser
	@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
	
}
