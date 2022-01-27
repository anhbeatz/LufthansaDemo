package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage extends base{
	public WebDriver driver;
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By signinbtn = By.cssSelector("input[value='Log In']");
	By forgotPsw = By.cssSelector(".link-below-button");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
public ForgotPswPage forgotPsw() {
	driver.findElement(forgotPsw).click();
	return new ForgotPswPage(driver);
	
	
	
}
	public WebElement getEmail() {

		return driver.findElement(email);
	}
	public WebElement getPassword() {

		return driver.findElement(password);
	}
	public WebElement getSigninbtn() {

		return driver.findElement(signinbtn);
	}
	
}