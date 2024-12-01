package tests;

import java.sql.Driver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage pageObj =  new LoginPage(BaseClass.getDriver());
	
	@Test
	public void verifyLogin() throws InterruptedException {
		Thread.sleep(2000);
		pageObj.enterUname("ese04");
		pageObj.clickCntBtn();
	}

}
