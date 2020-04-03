package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.ManualUserData;
import utility.UserData;

public class CreateAccountPo {

	public static final String FIRST_NAME_PERSONAL = "//input[@id='customer_firstname']";
	public static final String LAST_NAME_PERSONAL = "//input[@id='customer_lastname']";
	public static final String PASSWORD = "//input[@id='passwd']";
	public static final String ADDRESS = "//input[@name='address1']";
	public static final String CITY = "//input[@name='city']";
	public static final String STATE = "//select[@id='id_state']";
	public static final String POSTAL_CODE = "//input[@name='postcode']";
	public static final String COUNTRY = "//option[contains(text(),'United States')]";
	public static final String MOBILE_PHONE = "//input[@name='phone_mobile']";
	public static final String ADDRESS_ALIAS = "//input[@name='alias']";
	public static final String REGISTER = "//span[contains(text(),'Register')]";

	// Method that gets First Name field
	public static WebElement getFirstName(WebDriver driver) {

		return driver.findElement(By.xpath(FIRST_NAME_PERSONAL));
	}

	// Method that gets Last Name field
	public static WebElement getLastName(WebDriver driver) {

		return driver.findElement(By.xpath(LAST_NAME_PERSONAL));
	}

	// Method that gets Password field
	public static WebElement getPassword(WebDriver driver) {

		return driver.findElement(By.xpath(PASSWORD));
	}

	// Method that gets Address field
	public static WebElement getAddress(WebDriver driver) {
		return driver.findElement(By.xpath(ADDRESS));
	}

	// Method that gets City field
	public static WebElement getCity(WebDriver driver) {
		return driver.findElement(By.xpath(CITY));
	}

	// Method that gets State
	public static WebElement getState(WebDriver driver) {
		return driver.findElement(By.xpath(STATE));
	}

	// Method that gets Address field
	public static WebElement getPostalCode(WebDriver driver) {
		return driver.findElement(By.xpath(POSTAL_CODE));
	}

	// Method that gets Mobile phone field
	public static WebElement getPhone(WebDriver driver) {
		return driver.findElement(By.xpath(MOBILE_PHONE));
	}

	// Method that gets Address alias field
	public static WebElement getAddressAlias(WebDriver driver) {
		return driver.findElement(By.xpath(ADDRESS_ALIAS));
	}

	// Method that gets Register button
	public static WebElement getRegister(WebDriver driver) {
		return driver.findElement(By.xpath(REGISTER));
	}

	// Method that sets First Name in Personal section
	public static void setFirstName(WebDriver driver, String firstName) {
		getFirstName(driver).sendKeys(firstName);
	}

	// Method that sets Last Name in Personal section
	public static void setLastName(WebDriver driver, String lastName) {
		getLastName(driver).sendKeys(lastName);
	}

	// Method that sets Password
	public static void setPassword(WebDriver driver, String password) {
		getPassword(driver).sendKeys(password);
	}

	// Method that sets Address
	public static void setAddress(WebDriver driver, String address) {
		getAddress(driver).sendKeys(address);
	}

	// Method that sets City
	public static void setCity(WebDriver driver, String city) {
		getCity(driver).sendKeys(city);
	}

	// Method that selects state
	public static void setState(WebDriver driver, String stateName) {
		Select state = new org.openqa.selenium.support.ui.Select(getState(driver));
		state.selectByVisibleText(stateName);
	}

	// Method that sets Zip/Postal code
	public static void setPostalCode(WebDriver driver, String postalCode) {
		getPostalCode(driver).sendKeys(postalCode);
	}

	// Metod that selects Country
	public static void setCountry(WebDriver driver) {
		driver.findElement(By.xpath(COUNTRY)).click();
	}

	// Method that sets Mobile phone
	public static void setPhone(WebDriver driver, String phone) {
		getPhone(driver).sendKeys(phone);
	}

	// Method deletes text in field and sets Address alias
	public static void setAddressAlias(WebDriver driver, String alias) {
		getAddressAlias(driver).clear();
		getAddressAlias(driver).sendKeys(alias);
	}

	// Method that clicks on Register button
	public static void clickRegister(WebDriver driver) {
		getRegister(driver).click();
	}

	// Method that fills required fields with manually created data and clics
	// register button
	public static void createAccountManually(WebDriver driver) {

		LogInAndRegistrationPo.goToCreateAccount(driver, ManualUserData.EMAIL);
		setFirstName(driver, ManualUserData.FIRST_NAME);
		setLastName(driver, ManualUserData.LAST_NAME);
		setPassword(driver, ManualUserData.PASSWORD);
		setAddress(driver, ManualUserData.ADDRESS);
		setCity(driver, ManualUserData.CITY);
		setState(driver, ManualUserData.STATE);
		setPostalCode(driver, ManualUserData.POSTAL_CODE);
		setCountry(driver);
		setPhone(driver, ManualUserData.PHONE);
		setAddressAlias(driver, ManualUserData.ADDRESS_ALIAS);

	}

	// Method that creates new user by using data from Excel file
	public static void createAccountAutomatically(WebDriver driver, int index) {

		LogInAndRegistrationPo.goToCreateAccount(driver, UserData.getEmail(index));
		setFirstName(driver, UserData.getFirstName(index));
		setLastName(driver, UserData.getLastName(index));
		setPassword(driver, UserData.getPassword(index));
		setAddress(driver, UserData.getAddress(index));
		setCity(driver, UserData.getCity(index));
		setState(driver, UserData.getState(index));
		setPostalCode(driver, UserData.getPostalCode(index));
		setCountry(driver);
		setPhone(driver, UserData.getMobilePhone(index));
		setAddressAlias(driver, UserData.getAddressAlias(index));
		clickRegister(driver);

	}

}
