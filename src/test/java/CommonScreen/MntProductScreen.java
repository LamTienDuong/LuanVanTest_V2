package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class MntProductScreen {
	public static final String ADD_PRODUCT_BTN_ID		= "add_product";
		
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.ACCOUNT_LINK_XPATH), By.id(LoginScreen.LOGIN_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL_ADMIN, Constant.BASE_PASSWORD_ADMIN);
			Utilities.clickObscuredElement(driver, By.xpath(HomeAdminScreen.ACCOUNT_ADMIN_LINK_XPATH), By.xpath(HomeAdminScreen.ADMIN_LINK_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeAdminScreen.ADMIN_LINK_XPATH), By.xpath(HomeAdminScreen.MNT_PRODUCT_LINK_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeAdminScreen.MNT_PRODUCT_LINK_XPATH), By.id(ADD_PRODUCT_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
}
