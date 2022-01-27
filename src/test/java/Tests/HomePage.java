package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdPopup;
import pageObjects.ForgotPswPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeDriver();
		goTo();
		log.info("Nav to HomePage");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		AdPopup ad = new AdPopup(driver);
		ad.handlePopup();
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		
		log.info("navigate to login");

		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		// System.out.println(Text);
		lp.getSigninbtn().click();
		log.info("sent keys to loginpage");

	}

	@Test
	public void ForgotPsw() {
		AdPopup ad = new AdPopup(driver);
		ad.handlePopup();
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		ForgotPswPage fp = lp.forgotPsw();
		fp.getEmail().sendKeys("AlbiNikehasani@ymail.com");
		fp.sendInstr().click();
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "albinikehasani@ymail.com";
		data[0][1] = "12345678";

		data[1][0] = "abc@ymail.com";
		data[1][1] = "asdfghjkl";

		return data;

	}

}
