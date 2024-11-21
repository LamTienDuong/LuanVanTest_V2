package TestSuite;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.ProductDetailScreen;

public class AddToCart extends Initialization {
	private String id;
	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreenWithoutLogin(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		id = method.getName();
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.TITLE_STRING, "áo dài tay caro xám")), By.id(ProductDetailScreen.ADD_TO_CART_BTN_ID), Constant.WAIT_ELEMENT_EXIST);
	}

	@AfterMethod()
	public void tearDownMethod() throws Exception {
		Utilities.clickObscuredElement(driver, By.xpath(ProductDetailScreen.HOME_LINK_XPATH), By.xpath(HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.TITLE_STRING, "áo dài tay caro xám")), Constant.WAIT_ELEMENT_EXIST);
	}
	
	@Test()
	public void TCThemVaoGioHang_01() throws Exception {
		ProductDetailScreen.addToCart(driver, id, "1", "S");
	}

	@Test()
	public void TCThemVaoGioHang_02() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "1ab2");
	}
	
	@Test()
	public void TCThemVaoGioHang_03() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "1  2");
	}
	
	@Test()
	public void TCThemVaoGioHang_04() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "1@#2");
	}
	
	@Test()
	public void TCThemVaoGioHang_05() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "-1");
	}
	
	@Test()
	public void TCThemVaoGioHang_06() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "0");
	}
	
	@Test()
	public void TCThemVaoGioHang_07() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "+2");
	}
	
	@Test()
	public void TCThemVaoGioHang_08() throws Exception {
		ProductDetailScreen.inputAndValidateQuantity(driver, id, "5.1");
	}
	
	@Test()
	public void TCThemVaoGioHang_09() throws Exception {
		ProductDetailScreen.addToCart(driver, id, ProductDetailScreen.PLUS_BTN_ID, "S");
	}
	
	
	@Test()
	public void TCThemVaoGioHang_10() throws Exception {
		ProductDetailScreen.addToCart(driver, id, ProductDetailScreen.MINUS_BTN_ID, "S");
	}
	
	@Test()
	public void TCThemVaoGioHang_11() throws Exception {
		ProductDetailScreen.addToCart(driver, id, "3", "XL");
	}
}