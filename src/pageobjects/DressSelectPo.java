package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressSelectPo {

	public static final String DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";

	public static final String FIRST_DRESS = "//li[1]//div[1]//div[2]//h5[1]//a[1]";
	public static final String QUANTITY = "//a[2]//span[1]";
	public static final String SIZE = "//option[contains(text(),'M')]";
	public static final String COLOR = "//a[@id='color_14']";
	public static final String ADD_TO_CART = "//span[contains(text(),'Add to cart')]";
	public static final String PROCEED_TO_CART = "//span[contains(text(),'Proceed to checkout')]";

	// Opens SummerDresses page
	public static void goToSummerDrssesPage(WebDriver driver) {
		driver.get(DRESSES_URL);
		driver.manage().window().maximize();
	}

	// Choses first dress
	public static void setFirstDress(WebDriver driver) {
		driver.findElement(By.xpath(FIRST_DRESS)).click();
	}

	// Adds 2 dresses
	public static void setDressQuantity(WebDriver driver) {
		driver.findElement(By.xpath(QUANTITY)).click();
	}

	// Selects specific size
	public static void setDressSize(WebDriver driver) {
		driver.findElement(By.xpath(SIZE)).click();

	}

	// Selects specific color
	public static void setDressColor(WebDriver driver) {
		driver.findElement(By.xpath(COLOR)).click();
	}

	// adds item to cart
	public static void clickToCart_BTN(WebDriver driver) {
		driver.findElement(By.xpath(ADD_TO_CART)).click();
	}

	// proceeds to cart
	public static void proceedToCart(WebDriver driver) {
		driver.findElement(By.xpath(PROCEED_TO_CART)).click();
	}

	// Opens cart vith specific dress and parameters added
	public static void goToCart(WebDriver driver) throws InterruptedException {
		goToSummerDrssesPage(driver);
		setFirstDress(driver);
		setDressQuantity(driver);
		setDressSize(driver);
		setDressColor(driver);
		clickToCart_BTN(driver);
		Thread.sleep(2000);
		proceedToCart(driver);

	}

}
