package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAddToCart extends BasePage {

    // ---------- CONSTRUCTOR ----------
    public ProductAddToCart(WebDriver driver) {
        super(driver);
    }

    // ---------- LOCATORS ----------

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement btnAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement btnAddBikeLight;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "continue-shopping")
    private WebElement btnContinueShopping;

    // Cart badge appears ONLY when items are added
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private List<WebElement> cartBadge;

    // ---------- ACTION METHODS ----------

    public void clickAddBackpack() {
        btnAddBackpack.click();
        waitForCartBadgePresence();
    }

    public void clickBikeLight() {
        btnAddBikeLight.click();
        waitForCartBadgePresence();
    }

    public void clickCartIcon() {
        cartIcon.click();

        // Wait until cart page loads
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("cart"));
    }

    public void clickContinueShopping() {

        // Continue button exists only on cart page
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(btnContinueShopping));

        btnContinueShopping.click();
    }

 // ---------- CART COUNT METHODS ----------

    public String getCartCount() {
        if (cartBadge.size() > 0) {
            return cartBadge.get(0).getText();
        }
        return "0";
    }

    /**
     * Waits until cart count increases after adding product
     */
    public String waitForCartCountIncrease(int previousCount) {

        new WebDriverWait(driver, Duration.ofSeconds(7))
            .until(driver -> {
                String text = getCartCount();
                int current = Integer.parseInt(text);
                return current > previousCount;
            });

        return getCartCount();
    }

    // ---------- PRIVATE WAIT HELPERS ----------

    private void waitForCartBadgePresence() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@class='shopping_cart_badge']")));
    }
}








//
//@FindBy(xpath="//button[@id='checkout']") @CacheLookup private WebElement checkout;
//@FindBy(xpath="//button[@id='continue-shopping']") @CacheLookup private WebElement continueShopping;

//
//@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") @CacheLookup private WebElement addToCart;
//@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") @CacheLookup private WebElement addToCart;
//@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") @CacheLookup private WebElement addToCart;
//@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") @CacheLookup private WebElement addToCart;
//@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") @CacheLookup private WebElement addToCart;
//@FindBy(xpath="//a[@class='shopping_cart_link']") @CacheLookup private WebElement cartIcon;
