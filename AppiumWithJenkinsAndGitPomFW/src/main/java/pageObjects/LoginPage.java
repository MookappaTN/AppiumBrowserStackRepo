package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	
	AppiumDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	
	@FindBy(xpath="//android.widget.EditText")
	private WebElement uname;
	
	@FindBy(xpath="//android.widget.Button[@resource-id='btnContinueFirst']")
	private WebElement cntBtn;
	
	public LoginPage(AppiumDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterUname(String un) {
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.sendKeys(un);
	}
	
	public void clickCntBtn() {
		cntBtn.click();
	}
	
	
}
