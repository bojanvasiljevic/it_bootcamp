package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPo {

	public static final String QUANTITY = "//input[@name='quantity_5_24_0_0']";
	public static final String DRESS_DESCRIPTION = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	public static final String SIZE_COLOR = "//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]";
	public static final String PROCEED_CHECKOUT = "Proceed to checkout";

	// Returns quantity from cart page
	public static String getQTY(WebDriver driver) {

		WebElement elemetn = driver.findElement(By.xpath(QUANTITY));
		elemetn.click();
		String value = elemetn.getAttribute("value");
		return value;
	}

	// Returns size and color from cart page
	public static String getSizeAndColor(WebDriver driver) {

		WebElement elementn = driver.findElement(By.xpath(SIZE_COLOR));
		String innerHTML = elementn.getAttribute("innerHTML");
		return innerHTML;
	}

	// Returns dress description from cart page
	public static String getDescrition(WebDriver driver) {

		WebElement elementn = driver.findElement(By.xpath(DRESS_DESCRIPTION));
		String innerHTML = elementn.getAttribute("innerHTML");
		return innerHTML;
	}

	// Method that finds Proceed to checkout button
	public static WebElement getProceedTocheckout(WebDriver driver) {

		return driver.findElement(By.linkText(PROCEED_CHECKOUT));

	}

	// Method that navigates to register user page
	public static void clickProceedTocheckout(WebDriver driver) {

		getProceedTocheckout(driver).click();
	}

}
