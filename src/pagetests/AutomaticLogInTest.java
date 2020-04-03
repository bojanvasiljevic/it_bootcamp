package pagetests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.LogInAndRegistrationPo;
import pageobjects.MyAccountPo;
import utility.UserData;

public class AutomaticLogInTest {

	public static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	// Test to check if already regitered user can log in succesfully using Excel
	// file data
	public static void logInUser() {

		SoftAssert logIn = new SoftAssert();

		for (int index = 1; index < UserData.getNumberOfRows(); index++) {
			LogInAndRegistrationPo.signInAutomatic(driver, index);

			String expected = UserData.getFirstName(index) + " " + UserData.getLastName(index); // value from Excel file
			String actual = MyAccountPo.getMyInfoInnerValue(driver); // inner value form MyAccount page
			logIn.assertEquals(actual, expected);

			MyAccountPo.clickSignOut(driver);
		}
		logIn.assertAll();
	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}
