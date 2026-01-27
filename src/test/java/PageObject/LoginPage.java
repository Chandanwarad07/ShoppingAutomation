package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	
public 	LoginPage (WebDriver driver) {
	super(driver);
}

@FindBy(xpath="//input[@id='password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='user-name']")
WebElement textuserName;


@FindBy(xpath="//input[@id='login-button']")
WebElement btnbutton;

 

public void enterUserName(String usr) {
	textuserName.sendKeys(usr);
	
	
}

public void enterPassword(String psw) {
	txtPassword.sendKeys(psw);
}
public void clickButton() {
	btnbutton.click();
}

}






//@FindBy(xpath="//input[@id='password']") @CacheLookup private WebElement password;
//@FindBy(xpath="//input[@id='user-name']") @CacheLookup private WebElement username;
//@FindBy(xpath="//input[@id='login-button']") @CacheLookup private WebElement login-button;
