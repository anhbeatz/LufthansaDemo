package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	By title = By.cssSelector("div[class='text-center'] h2");
	By nav= By.cssSelector(".navbar-collapse.collapse");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public LoginPage getLogin() {

		 driver.findElement(signin).click();
		 LoginPage lp=new LoginPage (driver);
		 return lp;
	}
	public WebElement getTitle() {

		return driver.findElement(title);
	}
	public WebElement getNavBar() {

		return driver.findElement(nav);
	}


}