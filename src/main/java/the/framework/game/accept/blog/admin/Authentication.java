package the.framework.game.accept.blog.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import the.framework.game.accept.blog.Seleniums;

public class Authentication implements AutoCloseable {

	final WebDriver driver;

	public Authentication() {
		super();
		driver = Seleniums.build();
	}

	public void login() {
		login(Seleniums.getUsername(), Seleniums.getPassword());
	}

	public void login(String username, String password) {
		Seleniums.localGet(driver, "/secure/login");

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("signin")).click();
		if (driver.getCurrentUrl().contains("/login")) {
			throw new IllegalStateException(
					"login attempt failed: still on login page");
		}
	}

	public void logout() {
		Seleniums.localGet(driver, "/secure/logout");
	}

	public void close() {
		driver.quit();
	}
	
	private boolean isVisibleOnHomePage(String text) {
		Seleniums.localGet(driver, "/");
		try {
			driver.findElement(By.partialLinkText(text));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isLoginVisibleOnHomePage() {
		return isVisibleOnHomePage("login");
	}
	
	public boolean isLogoutVisibleOnHomePage() {
		return isVisibleOnHomePage("logout");
	}
	
	public boolean isAdminVisibleOnHomePage() {
		return isVisibleOnHomePage("admin");		
	}

}
