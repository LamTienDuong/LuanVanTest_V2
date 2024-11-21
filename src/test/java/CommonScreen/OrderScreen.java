package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class OrderScreen {
	// Text field
	public static final String NAME_TXT_ID 				= "name";
	public static final String PHONE_TXT_ID				= "phone";
	public static final String PROVINCE_SELECT_ID 		= "province";
	public static final String DISTRICT_SELECT_ID		= "district";
	public static final String WARD_SELECT_ID 			= "ward";
	public static final String ADDRESS_TXT_ID	 		= "address";
	
	// Button
	public static final String ORDER_BTN_ID				= "order";
	public static final String HISTORY_LINK_BTN_ID		= "link_history";
	
	// Link
	public static final String HOME_LINK_XPATH			= "//span[contains(text(),'Trang Chủ')]";
		
	// Error message 
	public static final String ERROR_MSG_XPATH 			= "(//div[@class='ant-form-item-explain-error'])[1]";
	public static final String SUCCESS_MSG_XPATH		= "//div[@class='ant-message-custom-content ant-message-success']//span[2]";

	// List of messages
	public static final String SUCCESS_MSG 				= "Đặt hàng thành công !";
	
	public static WebDriver openScreen(WebDriver driver) {
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.TITLE_STRING, "áo dài tay caro xám")), By.id(ProductDetailScreen.ADD_TO_CART_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(ProductDetailScreen.ADD_NOW_BTN_ID), By.id(CartScreen.BUY_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(CartScreen.BUY_BTN_ID), By.id(ORDER_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
		return driver;
	}
	
	public static void orderE2E(WebDriver driver, String name, String phone, String province, String district, String ward, String address) throws InterruptedException {
		Utilities.waitForElementVisibility(driver, By.id(NAME_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
		Thread.sleep(1000);
		Utilities.inputValueAndValidate(driver, By.id(PHONE_TXT_ID), phone, phone);
		Thread.sleep(1000);
		Utilities.selectListBox(driver, By.id(PROVINCE_SELECT_ID), province);
		Thread.sleep(1000);
		Utilities.selectListBox(driver, By.id(DISTRICT_SELECT_ID), district);
		Thread.sleep(1000);
		Utilities.selectListBox(driver, By.id(WARD_SELECT_ID), ward);
		Thread.sleep(1000);
		Utilities.inputValueAndValidate(driver, By.id(ADDRESS_TXT_ID), address, address);
		Thread.sleep(1000);
		Utilities.clickObscuredElement(driver, By.id(ORDER_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
		Thread.sleep(1000);
		Utilities.clickObscuredElement(driver, By.id(HISTORY_LINK_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
	}
	
	public static void order(WebDriver driver, String id, String name, String phone, String province, String district, String ward, String address, String expectMsg) {
		Utilities.waitForElementVisibility(driver, By.id(NAME_TXT_ID));
		Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(PHONE_TXT_ID), phone, phone);	
		Utilities.selectListBox(driver, By.id(PROVINCE_SELECT_ID), province);
		Utilities.selectListBox(driver, By.id(DISTRICT_SELECT_ID), district);
		Utilities.selectListBox(driver, By.id(WARD_SELECT_ID), ward);
		Utilities.inputValueAndValidate(driver, By.id(ADDRESS_TXT_ID), address, address);	
		if (expectMsg.equals(SUCCESS_MSG)) {
			Utilities.clickObscuredElement(driver, By.id(ORDER_BTN_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), expectMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.id(ORDER_BTN_ID), By.xpath(ERROR_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.captureScreen(driver, id);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectMsg);
		}
	}	
}
