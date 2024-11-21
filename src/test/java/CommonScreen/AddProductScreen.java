package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class AddProductScreen {
	// Text field
	public static final String NAME_TXT_ID = "basic_name";
	public static final String PRICE_TXT_ID = "basic_price";
	public static final String CATEGORY_SELECT_ID = "basic_category";
	public static final String QUANTITY_TXT_ID = "basic_quantity";
	public static final String THUMBNAIL_UPLOAD_BTN_ID = "thumbnail";
	public static final String SLIDER_UPLOAD_BTN_ID = "slider";
	public static final String THUMBNAIL_UPLOAD_BTN_XPATH = "(//*[@class='ant-upload'])[1]";
	public static final String SLIDER_UPLOAD_BTN_XPATH = "(//*[@class='ant-upload'])[2]";

	// Button
	public static final String ADD_BTN_ID = "submit";

	// Error message
	public static final String ERROR_MSG_XPATH = "(//div[@class='ant-form-item-explain-error'])[1]";
	public static final String ERROR_MSG_XPATH2 = "//div[@class='ant-notification-notice-description']";
	public static final String SUCCESS_MSG_XPATH = "//div[@class='ant-message-custom-content ant-message-success']//span[2]";

	// List of messages
	public static final String SUCCESS_MSG = "Tạo mới sản phẩm thành công";

	public static WebDriver openScreen(WebDriver driver) {
		Utilities.clickObscuredElement(driver, By.id(MntProductScreen.ADD_PRODUCT_BTN_ID), By.id(ADD_BTN_ID),
				Constant.WAIT_ELEMENT_EXIST);
		return driver;
	}

	public static void inputAndValidateNumber(WebDriver driver, String id, String elementID, String inputValue)
			throws Exception {
		Utilities.inputValue(driver, By.id(elementID), inputValue);
		Utilities.click(driver, By.id(NAME_TXT_ID));
		Utilities.captureScreen(driver, id);
		if (inputValue.equals("-1")) {
			Utilities.assertInputValue(driver, By.id(elementID), "0");
		} else {
			Utilities.assertInputValue(driver, By.id(elementID), inputValue.replaceAll("[^0-9]", ""));
		}
	}

	public static void addProduct(WebDriver driver, String id, String name, String price, String category,
			String quantity, String thumbnail, String slider, String expectMsg) throws Exception {
		Utilities.waitForElementVisibility(driver, By.id(NAME_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
		Utilities.inputValue(driver, By.id(PRICE_TXT_ID), price);
		Utilities.selectListBox(driver, By.id(CATEGORY_SELECT_ID), category);
		Utilities.inputValue(driver, By.id(QUANTITY_TXT_ID), quantity);
		if (!thumbnail.isEmpty()) {
			Utilities.click(driver, By.xpath(THUMBNAIL_UPLOAD_BTN_XPATH));
			Utilities.selectFile(driver, Constant.IMAGES_PATH + thumbnail);
		}
		if (!slider.isEmpty()) {
			Utilities.click(driver, By.xpath(SLIDER_UPLOAD_BTN_XPATH));
			Utilities.selectFile(driver, Constant.IMAGES_PATH + slider);
		}
		
		if (expectMsg.equals(SUCCESS_MSG)) {
			Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(SUCCESS_MSG_XPATH),
					Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), expectMsg);
		} else if (thumbnail.isEmpty() || slider.isEmpty() || thumbnail.equals("invalid_image.docx")
				|| slider.equals("invalid_image.docx")) {
			Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(ERROR_MSG_XPATH2),
					Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH2), expectMsg);
		} else {
			Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(ERROR_MSG_XPATH),
					Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectMsg);
		}


	}

//	public static void addProduct(WebDriver driver, String id, String name, String price, String category, String quantity, String thumbnail, String slider, String expectMsg) throws Exception {
//		Utilities.waitForElementVisibility(driver, By.id(NAME_TXT_ID));
//		if (expectMsg.equals("NULL_PRICE")) {
//			inputAndValidateNumber(driver, id, PRICE_TXT_ID, price);
//		}
//		else if (expectMsg.equals("NULL_QUANTITY")) {
//			inputAndValidateNumber(driver, id, QUANTITY_TXT_ID, quantity);
//		}
//		else {
//			Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
//			Utilities.inputValue(driver, By.id(PRICE_TXT_ID), price);	
//			Utilities.selectListBox(driver, By.id(CATEGORY_SELECT_ID), category);
//			Utilities.inputValue(driver, By.id(QUANTITY_TXT_ID), quantity);
//			if (!thumbnail.isEmpty()) {
//				Utilities.click(driver, By.xpath(THUMBNAIL_UPLOAD_BTN_XPATH));
//				Utilities.selectFile(driver, Constant.IMAGES_PATH + thumbnail);
//			}
//			if (!slider.isEmpty()) {
//				Utilities.click(driver, By.xpath(SLIDER_UPLOAD_BTN_XPATH));
//				Utilities.selectFile(driver, Constant.IMAGES_PATH + slider);
//			}
//			if (expectMsg.equals(SUCCESS_MSG)) {
//				Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
//				Utilities.captureScreen(driver, id);
//				Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), expectMsg);
//			}
//			else if (thumbnail.isEmpty() || slider.isEmpty() || thumbnail.equals("invalid_image.docx") || slider.equals("invalid_image.docx")) {
//				Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(ERROR_MSG_XPATH2), Constant.WAIT_ELEMENT_EXIST);
//				Utilities.captureScreen(driver, id);
//				Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH2), expectMsg);
//			}
//			else {
//				Utilities.clickObscuredElement(driver, By.id(ADD_BTN_ID), By.xpath(ERROR_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
//				Utilities.captureScreen(driver, id);
//				Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectMsg);
//			}
//		}
//	}	
}
