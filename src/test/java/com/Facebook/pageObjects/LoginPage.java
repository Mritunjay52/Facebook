package com.Facebook.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//1
	public WebDriver driver;
	
	//2. Create Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3- Locator for UserName
	@FindBy(id="email")
	@CacheLookup //To improve the performance of locating elements
	WebElement userName;
	
	//4- Locator for Password
	@FindBy(id="pass")
	@CacheLookup
	WebElement password; 
	
	//5- Locator for Login Button
	@FindBy(id="loginbutton")
	@CacheLookup
	WebElement login;
	
	//6- Locator for logout Arrow
	@FindBy(xpath="//div[contains(@class,'x1ey2m1c xds687c xg01cxk x47corl x10l6tqk')][position()=1]")
	@CacheLookup
	WebElement logOutArrow;
	
	//7- Locator for logout
	@FindBy(xpath="//span[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logout;
	
	//8. Entering UserName
	public void setUserName(String uname) {
		userName.clear();
		userName.sendKeys(uname);
	}
	
	//9. Entering Password
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	//10. Clicking on Login Button
	public void clickLoginButton() {
		login.click();
	}
}
