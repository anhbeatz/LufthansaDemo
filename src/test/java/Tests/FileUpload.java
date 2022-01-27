package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FileUploadPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class FileUpload extends base {
	public WebDriver driver;
	String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\fileupload.exe";

	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		goToFileUpload();
		log.info("Nav to HomePage");

	}

	@Test
	public void FileUploadTest() throws InterruptedException, IOException {
		FileUploadPage fu = new FileUploadPage(driver);
		fu.pickFiles().click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(path);
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
