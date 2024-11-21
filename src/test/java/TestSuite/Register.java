package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSVDataProvider.RegisterData;
import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.LoginScreen;
import CommonScreen.RegisterScreen;

public class Register extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = RegisterScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}
	
	@AfterMethod()
	public void tearDownMethod() throws Exception {
		if (Utilities.checkElementVisible(driver, By.id(LoginScreen.REGISTER_LINK_ID))) {
			Utilities.clickObscuredElement(driver, By.id(LoginScreen.REGISTER_LINK_ID), By.id(RegisterScreen.NAME_TXT_ID), Constant.WAIT_ELEMENT_EXIST);
		}
		else {
			Utilities.refreshScreen(driver);
		}
	}

	@Test(dataProvider = "registerData", dataProviderClass = RegisterData.class)
	public void testRegister(String id, String name, String email, String password, String cfmPassword, String expectedMsg) throws IOException {
		RegisterScreen.register(driver, id, name, email, password, cfmPassword, expectedMsg);
	}
	
//	@Test()
//	public void testRegister() throws IOException {
//		RegisterScreen.register(driver, "TCDangKy_24", "Test", "TCDangKy_24@gmail.com", "Abcd1234", "Abcd1234",	"Đăng ký tài khoản thành công!");
//	}
	
}
