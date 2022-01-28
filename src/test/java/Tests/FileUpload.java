package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FileUploadPage;
import resources.base;

import java.io.IOException;

public class FileUpload extends base {
    private static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\fileupload.exe";
    String path2 = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\fileuploadMozilla.exe";

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
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            Runtime.getRuntime().exec(path);
            Thread.sleep(3000);
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            Runtime.getRuntime().exec(path2);
            Thread.sleep(3000);

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
