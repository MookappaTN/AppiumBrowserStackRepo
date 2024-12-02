package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

			
public class LoginTest extends BaseClass {
	
	WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(20));
	@Test
	public void verifyLogin() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText"))).sendKeys("ese04");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id='btnContinueFirst']"))).click();
	}

}
