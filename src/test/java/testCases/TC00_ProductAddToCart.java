package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.ProductAddToCart;
import testBase.BaseClass;

public class TC00_ProductAddToCart extends BaseClass {

	@Test(groups = {"smoke", "regression"})
	public void ProductAddToCart() {

	    LoginPage lp = new LoginPage(driver);
	    lp.enterUserName(p.getProperty("username"));
	    lp.enterPassword(p.getProperty("password"));
	    lp.clickButton();

	    ProductAddToCart pa = new ProductAddToCart(driver);

	    int expectedCount = 0;

	    pa.clickAddBackpack();
	    expectedCount++;

	    pa.clicklight();
	    expectedCount++;

	    String actualCount = pa.getCartCount();
	    System.out.println("Cart Count: " + actualCount);

	    Assert.assertEquals(
	        actualCount,
	        String.valueOf(expectedCount),
	        "Cart count mismatch!"
	    );

	    pa.clickcartIcon();
	    pa.ContionShopping();
	}

}

