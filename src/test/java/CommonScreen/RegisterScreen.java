package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class RegisterScreen {
	// Text field
	public static final String NAME_TXT_ID 				= "username";
	public static final String EMAIL_TXT_ID				= "email";
	public static final String PASSWORD_TXT_ID 			= "password";
	public static final String CFM_PASSWORD_TXT_ID 		= "confirmPassword";
	
	// Button
	public static final String REGISTER_BTN_ID			= "btn-submit";
	
	// Error message 
	public static final String ERROR_MSG_XPATH 			= "(//div[@class='ant-form-item-explain-error'])[1]";
	
	public static final String SUCCESS_MSG_XPATH 		="//div[@class='ant-message-custom-content ant-message-success']//span[2]";
	
	public static final String ERROR_MSG_XPATH_2		= "(//div[@class='ant-notification-notice-description'])[1]";
	
	// List of messages
	public static final String SUCCESS_MSG 				= "Đăng ký tài khoản thành công!";
	
	public static final String ERROR_MSG 				= "Email đã tồn tại!";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.ACCOUNT_LINK_XPATH), By.id(LoginScreen.REGISTER_LINK_ID), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.id(LoginScreen.REGISTER_LINK_ID), By.id(NAME_TXT_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void register(WebDriver driver, String id, String name, String email, String password, String cfmPassword, String expectMsg) {
		Utilities.waitForElementVisibility(driver, By.id(NAME_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(EMAIL_TXT_ID), email, email);	
		Utilities.inputValueAndValidate(driver, By.id(PASSWORD_TXT_ID), password, password);	
		Utilities.inputValueAndValidate(driver, By.id(CFM_PASSWORD_TXT_ID), cfmPassword, cfmPassword);	
		if (expectMsg.equals(SUCCESS_MSG)) {
			Utilities.clickObscuredElement(driver, By.id(REGISTER_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), expectMsg);
		} else if (expectMsg.equals("Email đã tồn tại!")) {
			Utilities.clickObscuredElement(driver, By.id(REGISTER_BTN_ID), By.xpath(ERROR_MSG_XPATH_2), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH_2), expectMsg);
		}else {
			Utilities.clickObscuredElement(driver, By.id(REGISTER_BTN_ID), By.xpath(ERROR_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectMsg);
		}
	}	
}
