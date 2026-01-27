package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
	
	public InventoryPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpack;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    public void clickAddToCart() {
        addBackpack.click();
    }

    public void clickCart() {
        cartIcon.click();
    }

}
