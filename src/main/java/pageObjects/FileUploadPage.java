package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
	public WebDriver driver;
	
	By centerbutton = By.cssSelector("#pickfiles");
	
	public FileUploadPage(WebDriver driver) {
		this.driver=driver;
	}
      
	 
	public WebElement pickFiles() {

		return driver.findElement(centerbutton);
		
	}
	
	
	
}
