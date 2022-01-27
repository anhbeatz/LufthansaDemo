package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdPopup {
	public WebDriver driver;

	public AdPopup(WebDriver driver) {
		this.driver = driver;
	}

	public void handlePopup() {
		if (driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).isDisplayed())
			driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
	}
}
