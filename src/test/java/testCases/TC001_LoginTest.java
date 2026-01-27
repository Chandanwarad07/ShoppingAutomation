package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {

	@Test
	public void verifyLogin()
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUserName(p.getProperty("username"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickButton();
		
		System.out.println(driver.getCurrentUrl());
		
		  Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}
}
