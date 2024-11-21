package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSVDataProvider.OrderData;
import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.OrderScreen;
import CommonScreen.ProductDetailScreen;

public class Order extends Initialization {	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		driver = OrderScreen.openScreen(driver);
	}
	
	@AfterMethod()
	public void tearDownMethod() throws Exception {
		Utilities.clickObscuredElement(driver, By.xpath(ProductDetailScreen.HOME_LINK_XPATH), By.xpath(HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.TITLE_STRING, "áo dài tay caro xám")), Constant.WAIT_ELEMENT_EXIST);
	}

	@Test(dataProvider = "orderData", dataProviderClass = OrderData.class)
	public void testOrder(String id, String name, String phone, String province, String district, String ward, String address, String expectMsg) throws IOException {
		OrderScreen.order(driver, id, name, phone, province, district, ward, address, expectMsg);
	}
	
//	@Test()
//	public void testOrder() throws IOException {
//		OrderScreen.order(driver,"TCDatHang_06", "Kiểm thử1234","987654321","Thành phố Cần Thơ","Huyện Cờ Đỏ","Thị trấn Cờ Đỏ","Kiểm thử địa chỉ","Tên người nhận nhập vào không hợp lệ!");
//	}
}