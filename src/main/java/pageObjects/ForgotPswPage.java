package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPswPage {
	public WebDriver driver;
	By email = By.cssSelector("#user_email");
	By sendInstr = By.cssSelector("input[value='Send Me Instruction']");

	public ForgotPswPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}
	public WebElement sendInstr() {

	return driver.findElement(sendInstr);
	
	}
}