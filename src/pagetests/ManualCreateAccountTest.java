package pagetests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.CreateAccountPo;
import pageobjects.MyAccountPo;
import utility.ManualUserData;

public class ManualCreateAccountTest {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	// Test to check if creating new account manually was succesful
	public void createNewAccountManualally() {

		CreateAccountPo.createAccountManually(driver);

		String expected = ManualUserData.FIRST_NAME + " "
				+ ManualUserData.LAST_NAME;
		String actual = MyAccountPo.getMyInfoInnerValue(driver);

		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}