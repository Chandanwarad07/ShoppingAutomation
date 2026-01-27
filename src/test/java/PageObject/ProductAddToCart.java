package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductAddToCart extends BasePage {

	
	public ProductAddToCart(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement btnAddBackpack;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement addToCart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartIcon;
	
	@FindBy(xpath="//button[@id='continue-shopping']")
	WebElement btnContionShopping;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartBadge;
	
	public void clickCart() {
		btnAddBackpack.click();
	}
	
	public void clicklight() {
		addToCart.click();
	}
	
	public void clickcartIcon() {
		cartIcon.click();
	}
	
	public void ContionShopping() {
		btnContionShopping.click();
	}
	
	public String getCartCount() {
	    return cartBadge.getText();
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
