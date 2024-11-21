package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSVDataProvider.LoginData;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.LoginScreen;

public class Login extends Initialization {	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = LoginScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}
	
	@AfterMethod()
	public void tearDownMethod() throws Exception {
		/* Utilities.refreshScreen(driver); */
		Utilities.linkToScreenLogin(driver); // lam tien duong
	}

	@Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
	public void testLogin(String id, String email, String password, String expectedMsg) throws IOException {
		LoginScreen.login(driver, id, email, password, expectedMsg);
	}
	
}