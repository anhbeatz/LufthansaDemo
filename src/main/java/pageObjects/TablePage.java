package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePage {
	public WebDriver driver;
	By table = By.xpath("//div[@class='left-align']//table[@id='product']/tbody/tr");

	public TablePage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getRows() {


		return driver.findElements(table);

	}

}
