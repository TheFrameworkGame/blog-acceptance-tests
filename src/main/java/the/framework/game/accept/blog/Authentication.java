package the.framework.game.accept.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authentication {

	private final WebDriver driver;

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

	public WebDriver getDriver() {
		return driver;
	}

}
