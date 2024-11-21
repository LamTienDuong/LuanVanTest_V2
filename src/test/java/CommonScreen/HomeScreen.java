package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HomeScreen {
	public static final String ACCOUNT_LINK_XPATH			= "//*[contains(text(),'Tài Khoản')]";	
	
	public static final String PRODUCT_LINK_XPATH			= "//div[@title='[TITLE]']";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.ACCOUNT_LINK_XPATH), By.id(LoginScreen.LOGIN_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD);
		}
		return driver;
	}
	
	public static WebDriver openScreenWithoutLogin(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
		}
		return driver;
	}
}
