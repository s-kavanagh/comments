package comments.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends Page {
	
	@FindBy(linkText = "Sign in")
	private WebElement signInButton;
	
	@FindBy(id = "bbc-blogs-comments-iframe")
	private WebElement commentsIFrame;
	
	@FindBy(css = "textarea[name='comment']")
	private WebElement commentTextBox;
	
	@FindBy(css = "input[value='Post comment']")
	private WebElement postCommentButton;
	
	@FindBy(className = "cmt-text")
	private List<WebElement> top15Comments;
	
	@FindBy(linkText = "Resend the email from here")
	private WebElement resendEmailPrompt;
    
    public BlogPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	    webDriver.switchTo().frame(commentsIFrame);
	}

    public SignInPage clickSignIn() throws Exception{
    	webDriver.switchTo().defaultContent();
    	signInButton.click();
    	return new SignInPage(webDriver);
    }
    
    public void SaveComment(String commentTime) throws Exception{
        commentTextBox.sendKeys(commentTime);
        //postCommentButton.click();
    }
    
    public String GetTop1Comment() throws Exception{
    	return top15Comments.get(0).getText();
    }
    
    public List<String> GetAllComments() throws Exception{
    	List<String> list = new ArrayList<>();
    	for (WebElement comment : top15Comments)
    	{
    		list.add(comment.getText());
    	}
    	return list;
    }
    
    public boolean IsResendEmailPromptVisible() throws Exception{
    	return resendEmailPrompt.isDisplayed();
    }
}
