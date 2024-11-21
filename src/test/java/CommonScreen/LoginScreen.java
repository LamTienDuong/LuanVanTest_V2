package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class LoginScreen {
	//Link
	public static final String REGISTER_LINK_ID			= "link-to-register";
	
	// Text field
	public static final String EMAIL_TXT_ID				= "email";
	public static final String PASSWORD_TXT_ID			= "password";
	
	// Button
	public static final String LOGIN_BTN_ID				= "btn-submit";
	
	// Error message
	public static final String ERROR_MSG_XPATH 			= "(//div[@class='ant-form-item-explain-error'])[1]";
	public static final String ERROR_MSG_XPATH2			= "(//div[@class='ant-notification-notice-description'])[1]";
	public static final String SUCCESS_MSG_XPATH		= "//div[@class='ant-message-custom-content ant-message-success']//span[2]";
	
	// List of messages
	public static final String SUCCESS_MSG 				= "Đăng nhập tài khoản thành công!";
	public static final String INVALID_INFO_MSG 		= "Tên đăng nhập hoặc mật khẩu không chính xác";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.ACCOUNT_LINK_XPATH), By.id(LOGIN_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void login(WebDriver driver, String email, String password) {
		Utilities.waitForElementVisibility(driver, By.id(EMAIL_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(EMAIL_TXT_ID), email, email);
		Utilities.inputValueAndValidate(driver, By.id(PASSWORD_TXT_ID), password, password);
		Utilities.clickObscuredElement(driver, By.id(LOGIN_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);

	}
	
	public static void login(WebDriver driver, String id, String email, String password, String expectMsg) {
		Utilities.waitForElementVisibility(driver, By.id(EMAIL_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(EMAIL_TXT_ID), email, email);
		Utilities.inputValueAndValidate(driver, By.id(PASSWORD_TXT_ID), password, password);
		
		if (expectMsg.equals(SUCCESS_MSG)) {
			Utilities.clickObscuredElement(driver, By.id(LOGIN_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), expectMsg);
		}
		else if (expectMsg.equals(INVALID_INFO_MSG)) {
			Utilities.clickObscuredElement(driver, By.id(LOGIN_BTN_ID), By.xpath(ERROR_MSG_XPATH2), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH2), expectMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.id(LOGIN_BTN_ID), By.xpath(ERROR_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectMsg);
		}
	}	
}
