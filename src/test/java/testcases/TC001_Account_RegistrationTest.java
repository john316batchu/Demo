package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import testBase.BaseClass;

public class TC001_Account_RegistrationTest extends BaseClass {
	
	
	public HomePage hp;
	public RegisterPage rp;
	
	@Test
	public void account_Registration() {
	logger.info("*******Starting Account_Registration Test******");	
	hp=new HomePage();
	hp.clickMyAccount();
	hp.clickRegister();
	logger.info("New User registration");
	logger.info("Entering user details");
	rp=new RegisterPage();
	try {
	rp.setFirstName(BaseClass.generateRandomString());
	rp.setLastName(BaseClass.generateRandomString());
	rp.setEmail(BaseClass.generateRandomString()+"@gmail.com");
	rp.setPassword("test@1234");
	rp.selectPrivcyPolicy();
	logger.info("Clicking on Continue button");
	rp.clickContinueBtn();
	logger.info("Validating New user Registration");
	if(rp.isAccountCreated()) {
		Assert.assertTrue(true);
	}else {
		Assert.fail();
	}
	}catch(Exception e) {
		Assert.fail();
	}
		
	}
	
}
