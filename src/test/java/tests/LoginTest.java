package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws Exception{
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		for(int i=1;i<rowCount;i++) {
			data[i-1][0] =ExcelUtils.getCellData(i, 0);
			data[i-1][1] =ExcelUtils.getCellData(i, 1);
		}
		ExcelUtils.closeExcel();
		return data;
	}
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		return new Object[][] {
			{"user1","Pass1"},
			{"user2","Pass2"},
			{"user3","Pass3"}
		};
	}
	
//	@Test(dataProvider = "LoginData2")
//	public void testValidLogin(String userName,String password) {
//		Log.info("Starting login test...");
//		test = ExtentReportManager.createTest("Login Test..");
//		test.info("Navigating to URL..");
//		LoginPage loginPage = new LoginPage(driver);
//		Log.info("Adding credentials...");
//		test.info("Adding credentials...");
////		loginPage.enterUsereName("admin@yourstore.com");
////		loginPage.enterPassword("admin");
//		loginPage.enterUsereName(userName);
//		loginPage.enterPassword(password);
//		test.info("Clicking on Login Button..");
//		loginPage.clickLogin();
//		Log.info("Getting page title...");
//		System.out.println("The Page title is - "+driver.getTitle());
////		 Assert.assertEquals("Dashboard / nopCommerce adminis", driver.getTitle());
//		test.pass("Lagin Successfully...");
//	}
	@Test()
	public void testValidLogin() {
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test..");
		test.info("Navigating to URL..");
		LoginPage loginPage = new LoginPage(driver);
		Log.info("Adding credentials...");
		test.info("Adding credentials...");
		loginPage.enterUsereName("admin@yourstore.com");
		loginPage.enterPassword("admin");
//		loginPage.enterUsereName(userName);
//		loginPage.enterPassword(password);
		test.info("Clicking on Login Button..");
		loginPage.clickLogin();
		Log.info("Getting page title...");
		System.out.println("The Page title is - "+driver.getTitle());
//		 Assert.assertEquals("Dashboard / nopCommerce adminis", driver.getTitle());
		test.pass("Lagin Successfully...");
	}
}
