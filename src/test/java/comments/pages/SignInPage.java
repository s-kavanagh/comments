package comments.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Page {
	
	@FindBy(id = "user-identifier-input")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password-input")
	private WebElement passwordTextBox;
    
    public SignInPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

    public void enterUsername(String username) throws Exception{
    	usernameTextBox.sendKeys(username);
    }
    
    public BlogPage enterPasswordAndLogin(String password) throws Exception{
        passwordTextBox.sendKeys(password);
        passwordTextBox.sendKeys(Keys.RETURN);
    	return new BlogPage(webDriver);
    }
}

