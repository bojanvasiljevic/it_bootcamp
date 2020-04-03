package pagetests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.CartPo;
import pageobjects.DressSelectPo;

public class CartTest {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DressSelectPo.goToCart(driver);
	}

	@Test
	// Tests quantity in shopping cart
	public void quantityTest() throws InterruptedException {

		String value = CartPo.getQTY(driver);
		Assert.assertEquals(value, "2");
	}

	@Test
	// Tests description in shopping cart
	public void descriptionTest() throws InterruptedException {

		String value = CartPo.getDescrition(driver);
		boolean ok = value.toLowerCase().contains("printed summer dress");
		Assert.assertTrue(ok);
	}

	@Test
	// Tests size in shopping cart
	public void sizeTest() throws InterruptedException {

		String value = CartPo.getSizeAndColor(driver);
		boolean size = value.toLowerCase().contains("size : m");
		Assert.assertTrue(size);
	}

	@Test
	// Tests color in shopping cart
	public void colorTest() throws InterruptedException {

		String value = CartPo.getSizeAndColor(driver);
		boolean color = value.toLowerCase().contains("color : blue");
		Assert.assertTrue(color);
	}

	@AfterClass
	public void end() {
		driver.close();
	}

}
