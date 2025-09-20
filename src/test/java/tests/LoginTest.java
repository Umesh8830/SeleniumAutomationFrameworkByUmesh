package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsereName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		System.out.println("The Page title is - "+driver.getTitle());
	}
}
