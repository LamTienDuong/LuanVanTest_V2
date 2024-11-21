package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ProductDetailScreen {
	// Text field
	public static final String QUANTITY_TXT_ID			= "value";
	
	// Button
	public static final String MINUS_BTN_ID				= "minus";
	public static final String PLUS_BTN_ID				= "plus";
	public static final String ADD_TO_CART_BTN_ID		= "add-to-cart";
	public static final String ADD_NOW_BTN_ID			= "add-now";
	
	// Link
	public static final String HOME_LINK_XPATH			= "//span[contains(text(),'Trang Chủ')]";
	
	// Error message 
	public static final String ERROR_MSG_XPATH 			= "(//div[@class='ant-form-item-explain-error'])[1]";
	public static final String SUCCESS_MSG_XPATH		= "//div[@class='ant-message-custom-content ant-message-success']//span[2]";

	// List of messages
	public static final String SUCCESS_MSG 				= "Sản phẩm đã được thêm vào Giỏ hàng";
		
	public static void inputAndValidateQuantity(WebDriver driver, String id, String inputValue) throws Exception {
		Utilities.inputValue(driver, By.id(QUANTITY_TXT_ID), inputValue);
		Utilities.captureScreen(driver, id);
		if (inputValue == "0") {
			Utilities.assertInputValue(driver, By.id(QUANTITY_TXT_ID), "1");
		}
		else {
			Utilities.assertInputValue(driver, By.id(QUANTITY_TXT_ID), inputValue.replaceAll("[^0-9]", ""));
		}
	}
	
	public static void addToCart(WebDriver driver, String id, String quantity, String size) throws Exception {
		if (quantity.equals(PLUS_BTN_ID)) {
			Utilities.clickObscuredElement(driver, By.id(PLUS_BTN_ID), By.id(ADD_TO_CART_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		else if (quantity.equals(MINUS_BTN_ID)) {
			Utilities.clickObscuredElement(driver, By.id(PLUS_BTN_ID), By.id(ADD_TO_CART_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.id(MINUS_BTN_ID), By.id(ADD_TO_CART_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		else {
			Utilities.inputValueAndValidate(driver, By.id(QUANTITY_TXT_ID), quantity, quantity);
		}
		Utilities.clickRadioBtn(driver, size);
		Utilities.clickObscuredElement(driver, By.id(ADD_TO_CART_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
		Utilities.captureScreen(driver, id);
		Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), SUCCESS_MSG);
	}
}
