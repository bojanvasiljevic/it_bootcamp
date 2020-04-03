package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPo {

	public static final String CUSTOMER_ACCOUNT = "//a[@class='account']//span";
	public static final String SIGN_OUT = "//nav//div[2]//a[1]";

	// Method that get Customer Account Button
	public static WebElement getMyInfo(WebDriver driver) {
		return driver.findElement(By.xpath(CUSTOMER_ACCOUNT));
	}

	// Method that returns String inner value of Customer Account button
	public static String getMyInfoInnerValue(WebDriver driver) {

		WebElement customerAccount = getMyInfo(driver);
		String innerHTML = customerAccount.getAttribute("innerHTML");
		return innerHTML;
	}

	// Gets Sign out button
	public static WebElement getSignOut(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_OUT));
	}

	// Click Sign out button
	public static void clickSignOut(WebDriver driver) {
		getSignOut(driver).click();
	}

}
