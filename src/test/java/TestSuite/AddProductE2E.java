package TestSuite;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSVDataProvider.AddProductData;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.AddProductScreen;
import CommonScreen.MntProductScreen;

public class AddProductE2E extends Initialization{
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = MntProductScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		driver = AddProductScreen.openScreen(driver);
	}
	
	@Test()
	public void testAddProduct() throws Exception {
		AddProductScreen.addProductE2E(driver, "ao dai tay", "10000", "áo sơ mi dài tay", "100", "valid_image.png", "valid_image.png");
	}

}
