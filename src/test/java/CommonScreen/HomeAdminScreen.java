package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HomeAdminScreen {
	public static final String ACCOUNT_ADMIN_LINK_XPATH		= "(//*[contains(text(),'admin')])[2]";
	public static final String ADMIN_LINK_XPATH				= "//*[contains(text(),'Trang quản trị')]";
	public static final String MNT_PRODUCT_LINK_XPATH		= "//*[contains(text(),'Manage Product')]";
		
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.ACCOUNT_LINK_XPATH), By.id(LoginScreen.LOGIN_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL_ADMIN, Constant.BASE_PASSWORD_ADMIN);
			Utilities.clickObscuredElement(driver, By.xpath(ACCOUNT_ADMIN_LINK_XPATH), By.xpath(ADMIN_LINK_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(ADMIN_LINK_XPATH), By.xpath(MNT_PRODUCT_LINK_XPATH), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
}
