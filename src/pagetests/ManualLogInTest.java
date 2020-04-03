package pagetests;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.LogInAndRegistrationPo;
import pageobjects.MyAccountPo;
import utility.ManualUserData;

public class ManualLogInTest {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public static void signOut() {
		MyAccountPo.clickSignOut(driver);
	}

	@Test
	// Test to check if already regitered user can log in succesfully
	public void logInUser() {
		LogInAndRegistrationPo.signInManual(driver);

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
