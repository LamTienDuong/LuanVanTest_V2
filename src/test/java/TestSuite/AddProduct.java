package TestSuite;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CSVDataProvider.AddProductData;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.AddProductScreen;
import CommonScreen.MntProductScreen;

public class AddProduct extends Initialization {	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = MntProductScreen.openScreen(browser);
	}
	

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		driver = AddProductScreen.openScreen(driver);
	}
	
	@AfterMethod()
	public void tearDownMethod() throws Exception {
		Utilities.refreshScreen(driver);
	}

	@Test(dataProvider = "addProductData", dataProviderClass = AddProductData.class)
	public void testAddProduct(String id, String name, String price, String category, String quantity, String thumbnail, String slider, String expectMsg) throws Exception {
		AddProductScreen.addProduct(driver, id, name, price, category, quantity, thumbnail, slider, expectMsg);
	}
	


}