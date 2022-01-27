package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class base {
    public WebDriver driver;
    public Properties prop;


    public WebDriver initializeDriver() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
        String path2 = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
        prop = new Properties();

        FileInputStream fis = new FileInputStream(path2);
        prop.load(fis);

        String browserName = prop.getProperty("browser");
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", path);
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox")) {


        } else if (browserName.equals("IE")) {

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void goTo() {
        String url = prop.getProperty("url");

        driver.get(url);
    }

    public void goToFileUpload() {
        String url = prop.getProperty("url2");

        driver.navigate().to(url);
    }

    public void goToTablePage() {

        String url = prop.getProperty("url4");
        driver.get(url);
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;


    }


}
