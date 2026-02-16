package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.ProductAddToCart;
import testBase.BaseClass;

public class TC00_ProductAddToCart extends BaseClass {

    @Test(groups = { "smoke", "regression" })
    public void ProductAddToCart() {

        // ---------- LOGIN ----------
        LoginPage lp = new LoginPage(driver);
        lp.enterUserName(p.getProperty("username"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickButton();

        ProductAddToCart pa = new ProductAddToCart(driver);

        // ---------- ADD BACKPACK ----------
        int countBefore = Integer.parseInt(pa.getCartCount());
        pa.clickAddBackpack();
        String countAfterBackpack =
                pa.waitForCartCountIncrease(countBefore);

        // ---------- ADD BIKE LIGHT ----------
        countBefore = Integer.parseInt(countAfterBackpack);
        pa.clickBikeLight();
        String finalCount =
                pa.waitForCartCountIncrease(countBefore);

        System.out.println("Final Cart Count: " + finalCount);

        Assert.assertEquals(finalCount, "2", "Cart count mismatch!");

        // ---------- CART FLOW ----------
        pa.clickCartIcon();
        pa.clickContinueShopping();
    }
}


