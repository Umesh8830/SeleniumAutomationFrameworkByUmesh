package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement userNameText;
	@FindBy(id="Password")
	WebElement passwordText;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginField;
	
//	private By userNameField = By.id("Email");
//	private By passwordField = By.id("Password");
//	private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsereName(String userName) {
		userNameText.clear();
		userNameText.sendKeys(userName);
//		driver.findElement(userNameField).clear();
//		driver.findElement(userNameField).sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		passwordText.clear();
		passwordText.sendKeys(password);
//		driver.findElement(passwordField).clear();
//		driver.findElement(passwordField).sendKeys(password);
		
	}
	
	public void clickLogin() {
		loginField.click();
//		driver.findElement(loginButton).click();
		
	}
}
//jmbp qxop pram bdij
//https://www.youtube.com/watch?v=Ktjt-pebRoc&list=PLhW3qG5bs-L_zQUmcXPs0F_e159DZ8OrP&index=3