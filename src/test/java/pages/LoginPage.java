package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Pagefactory
	@FindBy(id="input-email")
	WebElement emailAddress;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	//Actions
	public void setEmailAddress(String mail) {
		emailAddress.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
