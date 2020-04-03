package pagetests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.CreateAccountPo;
import pageobjects.MyAccountPo;
import utility.UserData;

public class AutomaticCreateAccountTest {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	// Test to check if creating user acount automatically using data from Excel
	// file is succesfull
	public void createNewAccountAutomatically() {
		SoftAssert regiterTest = new SoftAssert();

		for (int index = 1; index < UserData.getNumberOfRows(); index++) {
			CreateAccountPo.createAccountAutomatically(driver, index);

			String expected = UserData.getFirstName(index) + " " + UserData.getLastName(index); // from Excel file
			String actual = MyAccountPo.getMyInfoInnerValue(driver); // inner value on MyAccount page

			regiterTest.assertEquals(actual, expected);
			MyAccountPo.clickSignOut(driver);
		}
		regiterTest.assertAll();
	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}
