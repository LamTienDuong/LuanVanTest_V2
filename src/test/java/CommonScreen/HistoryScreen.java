package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HistoryScreen {
public static final String HISTORY_DETAIL_XPATH 		= "//div[@class='action']//div[@class='action-detail']";
	
	public static final String MODAL_DETAIL_HISTORY_ID 		= "history_detail";
	
	public static final String MODAL_BTN_CLOSE 				= "//button//span[@class='ant-modal-close-x']";
	
	public static final String SUCCESS_MSG_XPATH 			= "//div[@class='ant-message-custom-content ant-message-success']//span[2]";
	
	public static final String AVATAR_USER_XPATH 			= "//div[@class='ant-space-item']//span//img";
	
	public static final String BTN_LOGOUT_ID				=	"logout";
	
	public static void openScreenE2E(WebDriver driver) throws InterruptedException {
		Utilities.clickObscuredElement(driver, By.xpath(HISTORY_DETAIL_XPATH), By.id(MODAL_DETAIL_HISTORY_ID), Constant.WAIT_ELEMENT_EXIST);
		Thread.sleep(1000);
		Utilities.clickElement(driver, By.xpath(MODAL_BTN_CLOSE));
		Thread.sleep(1000);
		Utilities.clickObscuredElement(driver, By.xpath(AVATAR_USER_XPATH), By.id(BTN_LOGOUT_ID), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.id(BTN_LOGOUT_ID), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), "Đăng xuất thành công");
	}

}
