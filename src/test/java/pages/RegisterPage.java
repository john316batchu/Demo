package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class RegisterPage extends BaseClass {

	public JavascriptExecutor js;
	
	public RegisterPage() {
		
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="input-firstname")
	WebElement firstname;
	
	
	@FindBy(id="input-lastname")
	WebElement lastname;
	
	@FindBy(id="input-email")
	WebElement email;

	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement accountCreate;
	
	//Actions classes
	
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		lastname.sendKeys(lname);
	}
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void selectPrivcyPolicy() {

		js.executeScript("arguments[0].click();", privacyPolicy);
		
	}
	public void clickContinueBtn() {
		//continuebtn.click();
		js.executeScript("arguments[0].click();", continuebtn);
	}
	
	public boolean isAccountCreated() {
		return accountCreate.isDisplayed();
	}
}
