package comments.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import comments.pages.BlogPage;
import comments.pages.SignInPage;

public class CommentStepDefs {

	private static WebDriver webDriver;
	private static SignInPage signInPage;
	private static BlogPage blogPage;
	private String commentTime;
	
	// These would ideally be in some sort of config file with more time. 
	private String verifiedUser = "sam+bbctest@samkavanagh.com";
	private String unverifiedUser = "sam+unverified@samkavanagh.com";
	private String password = "Comments123";
	
	@Before
	public void SetUp() throws Throwable {
		// This would be better abstracted to a 'hooks' file or similar.
		webDriver = new ChromeDriver();
	    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    webDriver.get("http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0");
	}
	
	@After
	public void Teardown() throws Throwable {
		// Better in a hooks file.
		webDriver.quit();
	}
	
	@Given("^I am on a blog page$")
	public void i_am_on_an_article_page() throws Throwable {
		blogPage = new BlogPage(webDriver);
		blogPage.clickSignIn();
	}
	
	@Given("^I login as a user who can comment$")
	public void i_login_as_a_user_who_can_comment() throws Throwable {
		signInPage = new SignInPage(webDriver);
		signInPage.enterUsername(verifiedUser);
		signInPage.enterPasswordAndLogin(password);
	}
	
	@Given("^I login as an unverified user$")
	public void i_login_as_an_unverified_user() throws Throwable {
		signInPage = new SignInPage(webDriver);
		signInPage.enterUsername(unverifiedUser);
		signInPage.enterPasswordAndLogin(password);
	}

	@When("^I write a comment$")
	public void i_write_a_comment() throws Throwable {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        commentTime = LocalDateTime.now().format(format);
		blogPage = blogPage.SaveComment(commentTime);
	}

	@Then("^My comment should be displayed at the top of the list$")
	public void my_comment_should_be_displayed_at_the_top_of_the_list() throws Throwable {
		String actualComment = blogPage.GetTop1Comment();
	    assertThat(actualComment, is(commentTime));
	}
	
	@Then("^I should see a resend email prompt$")
	public void i_should_see_a_resend_email_prompt() throws Throwable {
		assert(blogPage.IsResendEmailPromptVisible());
	}
}
