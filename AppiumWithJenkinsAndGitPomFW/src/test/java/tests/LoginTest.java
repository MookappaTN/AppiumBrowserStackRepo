package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pageObjects.LoginPage;

public class LoginTest {
	public static AppiumDriver driver;
	LoginPage pageObj =  new LoginPage(driver);
	
	@Test
	public void verifyLogin() throws InterruptedException, MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("Google Pixel 8");
		options.setPlatformVersion("14.0");
		options.setCapability("debug", true);
		options.setCapability("video", true);
		options.setApp("bs://c4ec1fc63ff5185d0b9444952eb066475f06322c");
		options.setAppPackage("com.apihealthcare.workforce.test");
		options.setAppActivity(".MainActivity");
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("autoAcceptAlert", true);
		
		options.setCapability("bstack:options", new HashMap<String,Object>(){{
			put("userName","mookappat_C9IjUJ");
			put("accessKey","e1vfKTTQxxgMbznsy9B6");
			put("projectName","Ui test Through Jenkins");
			put("buildName","Android Test build");
			put("idleTimeout",3000);
		  }
		});
		
		
		URL url = new URL("https://mookappat_C9IjUJ:e1vfKTTQxxgMbznsy9B6@hub.browserstack.com/wd/hub");
		
		this.driver = new AppiumDriver(url, options);
		Thread.sleep(2000);
		pageObj.enterUname("ese04");
		pageObj.clickCntBtn();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destNation = new File("./ScreenShots/"+System.currentTimeMillis()+".png");
			FileHandler.copy(src, destNation);
		}
		
		if(driver!=null) {
			driver.quit();
		}
	}

}
