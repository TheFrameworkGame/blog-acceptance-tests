package the.framework.game.accept.blog.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import the.framework.game.accept.blog.Seleniums;

public class AdminPages implements AutoCloseable {

	private final WebDriver driver;

	private final Authentication auth;

	public AdminPages() {
		this(true);
	}

	public AdminPages(boolean login) {
		auth = new Authentication();
		if (login)
			auth.login();
		driver = auth.driver;
		Seleniums.localGet(driver, "/admin/");
	}

	public boolean hasListPageFor(String category) {
		return !driver.findElements(By.linkText(category)).isEmpty();
	}

	public AdminListPage getList(String category) {
		WebElement link = driver.findElement(By.linkText(category));
		link.click();
		return new AdminListPage(driver);
	}

	public boolean isAtLogin() {
		return driver.getCurrentUrl().contains("/secure/login");
	}

	public boolean isAtAdminHome() {
		return driver.getCurrentUrl().contains("/admin");
	}

	@Override
	public void close() {
		driver.quit();
	}

}
