package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.InventoryPage;
import PageObject.LoginPage;
import testBase.BaseClass;

public class TC002_AddToCartTest extends BaseClass {

	@Test(groups = {"regression"})
    public void verifyAddToCart() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);
        lp.enterUserName(p.getProperty("username"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickButton();

        InventoryPage ip = new InventoryPage(driver);
        
        ip.clickAddToCart();
        ip.clickCart();

        CartPage cp = new CartPage(driver);
        Assert.assertTrue(cp.isProductDisplayed());
    }
}
