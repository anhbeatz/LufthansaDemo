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

public class validateTitle extends base {
	public WebDriver driver;

	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("driver is initialized");
		goTo();
		log.info("navigate to homepage");
	}

	@Test
	public void basePageNavigation() throws IOException {
		AdPopup ad = new AdPopup(driver);
		ad.handlePopup();
		LandingPage l = new LandingPage(driver);
		String centeredText = l.getTitle().getText();
		Assert.assertEquals(centeredText, "FEATURED COURSE");
		log.info("sucessfully validated title");
		}

	@AfterTest
	public void tearDown() {
		driver.close();

	}

}
