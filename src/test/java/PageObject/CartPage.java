package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "inventory_item_name")
    WebElement productName;

    public boolean isProductDisplayed() {
        return productName.isDisplayed();
    }

}
