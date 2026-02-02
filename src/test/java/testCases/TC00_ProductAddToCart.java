package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.ProductAddToCart;
import testBase.BaseClass;

public class TC00_ProductAddToCart extends BaseClass {

    @Test
    public void ProductAddToCart() {

        LoginPage lp = new LoginPage(driver);
        lp.enterUserName(p.getProperty("username"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickButton();

        // ✅ Create object AFTER login
        ProductAddToCart pa = new ProductAddToCart(driver);
        pa.clickAddBackpack();
        pa.clicklight();
        
        System.out.println("Cart Count: " + pa.getCartCount());

        String count = pa.getCartCount();
        System.out.println("Cart Count: " + count);
        Assert.assertEquals(count, "5", "Cart count mismatch!");

        pa.clickcartIcon();
        pa.ContionShopping();
    }
}

