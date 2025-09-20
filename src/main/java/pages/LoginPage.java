package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userNameField = By.id("Email");
	private By passwordField = By.id("Password");
	private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsereName(String userName) {
		driver.findElement(userNameField).clear();
		driver.findElement(userNameField).sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
		
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
		
	}
}

//https://www.youtube.com/watch?v=Ktjt-pebRoc&list=PLhW3qG5bs-L_zQUmcXPs0F_e159DZ8OrP&index=3