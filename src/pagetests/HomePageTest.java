package pagetests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePagePo;

public class HomePageTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void before() {
		HomePagePo.goToHomePage(driver);
	}

	@Test
	// Checks if method hoverOverWomenAndClick opens correct page
	public void womenToSummerDresses() {
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";

		HomePagePo.hoverOverWomenAndClick(driver);
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, expected);
	}

	@Test
	// Checks if method hoverOverDressesAndCLick opens correct page
	public void dressesToSummerDresses() {
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";

		HomePagePo.hoverOverDressesAndCLick(driver);
		String current = driver.getCurrentUrl();
		Assert.assertEquals(current, expected);
	}

	@Test
	// Testig if hoverOverWomenAndClick() method and hoverOverDressesAndCLick()
	// method are navigating to same page
	public void twoMethodsURLTest() {
		HomePagePo.goToHomePage(driver);
		HomePagePo.hoverOverWomenAndClick(driver);
		String women = driver.getCurrentUrl();

		HomePagePo.hoverOverDressesAndCLick(driver);
		String dresses = driver.getCurrentUrl();
		Assert.assertEquals(women, dresses);
	}

	@AfterClass
	public void end() {
		driver.close();

	}
}
