package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	
	@Test
	public void loginTest() {
		hp=new HomePage();
		logger.info("*****Starting loginTest*******");
		hp.clickMyAccount();
		logger.info("Clicking on Login link");
		hp.clickLogin();
		lp=new LoginPage();
		logger.info("Entering email address");
		lp.setEmailAddress(prop.getProperty("email"));
		logger.info("Entering password");
		lp.setPassword(prop.getProperty("password"));
		logger.info("Clicking on login button");
		lp.clickLogin();
		logger.info("Validating title after login");
		String title=lp.getTitle();
		Assert.assertEquals(title, "My Account");
		
	}

}
