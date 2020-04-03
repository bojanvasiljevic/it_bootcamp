package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePagePo {

	public static final String HOME_URL = "http://automationpractice.com/index.php";

	private static final String WOMEN_BTN = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	private static final String SUMMER_DRESSES_VIA_WOMEN = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
	private static final String DRESSES_BTN = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";
	private static final String SUMMER_DRESSES_VIA_DRESSES = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";

	// Opens home page
	public static void goToHomePage(WebDriver driver) {
		driver.get(HOME_URL);
		driver.manage().window().maximize();
	}

	// Gets Women button
	public static WebElement getWomen_BTN(WebDriver driver) {
		return driver.findElement(By.xpath(WOMEN_BTN));

	}

	// Gets Summer Dresses when hover over Women button
	public static WebElement getSummerDresses_Via_WomenBTN(WebDriver driver) {
		return driver.findElement(By.xpath(SUMMER_DRESSES_VIA_WOMEN));
	}

	// Gets Dresses button
	public static WebElement getDresses_BTN(WebDriver driver) {
		return driver.findElement(By.xpath(DRESSES_BTN));
	}

	// Gets Summer Dresses when hovering over Dresses button
	public static WebElement getSUmmerDresses_Via_DressesBTN(WebDriver driver) {
		return driver.findElement(By.xpath(SUMMER_DRESSES_VIA_DRESSES));
	}

	// Hovers over Women_btn and clics Summer Dresses_btn
	public static void hoverOverWomenAndClick(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement we = getWomen_BTN(driver);
		action.moveToElement(we).perform();
		we = getSummerDresses_Via_WomenBTN(driver);
		we.click();
	}

	// Hovers over Dresses_btn and clics Summer Dresses_btn
	public static void hoverOverDressesAndCLick(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement we = getDresses_BTN(driver);
		action.moveToElement(we).perform();
		we = getSUmmerDresses_Via_DressesBTN(driver);
		we.click();
	}
}
