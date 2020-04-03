package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ManualUserData;
import utility.UserData;

public class LogInAndRegistrationPo {

	public static String REGISTER_LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	public static final String EMAIL_FOR_REGISTER = "//input[@id='email_create']";
	public static final String CREATE_ACCOUNT = "//form[@id='create-account_form']//span[1]";
	public static final String EMAIL_FOR_LOG_IN = "//input[@id='email']";
	public static final String PASSWORD_FOR_LOG_IN = "//input[@id='passwd']";
	public static final String SIGN_IN = "//div[@id='columns']//p//span[1]";

	// Method that navigates to Login and Register page
	public static void navigateToLoginPage(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get(REGISTER_LOGIN_URL);
	}

	// Method that gets User name field for Log in
	public static WebElement getLogInEmail(WebDriver driver) {
		return driver.findElement(By.xpath(EMAIL_FOR_LOG_IN));
	}

	// Method that gets Password field for Log in
	public static WebElement getLogInPasword(WebDriver driver) {
		return driver.findElement(By.xpath(PASSWORD_FOR_LOG_IN));
	}

	// method that gets Sign in button
	public static WebElement getSignIn(WebDriver driver) {
		return driver.findElement(By.xpath(SIGN_IN));
	}

	// Method that gets email field for registering new user
	public static WebElement getEmail(WebDriver driver) {
		return driver.findElement(By.xpath(EMAIL_FOR_REGISTER));
	}

	// Method that sets email for registering new user
	public static void setEmail(WebDriver driver, String email) {
		getEmail(driver).sendKeys(email);
	}

	// Method that sets Email for sign in already registered user
	public static void setSignInEmail(WebDriver driver, String email) {
		getLogInEmail(driver).sendKeys(email);
	}

	// Method that sets Sign In Password for already registered user
	public static void setSignInPassword(WebDriver driver, String password) {
		getLogInPasword(driver).sendKeys(password);
	}

	// Method that finds Create an Account button
	public static WebElement getCreateAccount(WebDriver driver) {
		return driver.findElement(By.xpath(CREATE_ACCOUNT));
	}

	// Method that clicks SIgn in button
	public static void clickSignIn(WebDriver driver) {
		getSignIn(driver).click();
	}

	// Methot that clicks on Create an Account button
	public static void clickCreateAccount(WebDriver driver) {
		getCreateAccount(driver).click();
	}

	// Method that navigates to Login and Registration page sets email
	// And clicks registration button and navigates to create an account page
	public static void goToCreateAccount(WebDriver driver, String email) {
		navigateToLoginPage(driver);
		setEmail(driver, email);
		clickCreateAccount(driver);
	}

	// Method that sign in alredy registered user by using data from Excel file
	public static void signInAutomatic(WebDriver driver, int index) {
		navigateToLoginPage(driver);
		setSignInEmail(driver, UserData.getEmail(index));
		setSignInPassword(driver, UserData.getPassword(index));
		clickSignIn(driver);
	}

	// Method that sign in alredy registered user with manual Sign in
	public static void signInManual(WebDriver driver) {
		navigateToLoginPage(driver);
		setSignInEmail(driver, ManualUserData.EMAIL);
		setSignInPassword(driver, ManualUserData.PASSWORD);
		clickSignIn(driver);
	}

}
