package comments.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

	protected WebDriver webDriver;

	
	protected Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}