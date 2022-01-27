package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.TablePage;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;

public class TableCount extends base {
    private static final Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    public int i;

    ExtentTest test;
    ExtentReports reports = ExtentReporterNG.getRowsObject();

    @BeforeTest
    public void initialize() throws IOException {


        driver = initializeDriver();
        goToTablePage();
        log.info("Nav to HomePage");

    }

    @Test
    public void tableRowsCount() {
        test = reports.createTest(this.getClass().getName());
        TablePage tp = new TablePage(driver);
        i = tp.getRows().size();
        test.log(Status.PASS, String.valueOf("n of rows "+i));

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        reports.flush();
    }

}
