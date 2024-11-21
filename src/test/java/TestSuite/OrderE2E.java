package TestSuite;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Initialization;
import CommonScreen.HistoryScreen;
import CommonScreen.LoginScreen;
import CommonScreen.OrderScreen;
import CommonScreen.RegisterScreen;

public class OrderE2E extends Initialization{
	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = RegisterScreen.openScreen(browser);
	}
	
	@Test()
	public void testAddProductE2E() throws IOException, InterruptedException {
		RegisterScreen.registerE2E(driver, "Lam Tien Duong", "lamtienduong@gmail.com", "Abcd1234", "Abcd1234");
		Thread.sleep(1000);
		LoginScreen.loginE2E(driver, "lamtienduong@gmail.com", "Abcd1234");
		Thread.sleep(1000);
		driver = OrderScreen.openScreen(driver);
		Thread.sleep(1000);
		OrderScreen.orderE2E(driver, "Lam Tien Duong", "0899675442", "Thành phố Cần Thơ", "Huyện Cờ Đỏ", "Thị trấn Cờ Đỏ", "Số nhà 123");
		Thread.sleep(1000);
		HistoryScreen.openScreenE2E(driver);
		Thread.sleep(1000);
	}

}
