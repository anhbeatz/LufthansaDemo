package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AdPopup;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver;

	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		goTo();
	}

	@Test
	public void basePageNavigation() throws IOException {
		AdPopup ad = new AdPopup(driver);
		ad.handlePopup();
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("navbar is displayed");

	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}
}
