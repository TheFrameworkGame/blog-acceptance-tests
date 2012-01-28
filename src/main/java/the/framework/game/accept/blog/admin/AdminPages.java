package the.framework.game.accept.blog.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import the.framework.game.accept.blog.Authentication;
import the.framework.game.accept.blog.Seleniums;

public class AdminPages {

	private final WebDriver driver;
	
	public void quit() {
		driver.quit();
	}

	private final Authentication auth;
	
	public AdminPages() {
		auth = new Authentication();
		auth.login();
		driver = auth.getDriver();
		Seleniums.localGet(driver, "/admin/");
	}
	
	public boolean hasListPageFor(String category) {
		return ! driver.findElements(By.linkText(category)).isEmpty();
	}
	
	public AdminListPage getList(String category) {
		WebElement link = driver.findElement(By.linkText(category));
		link.click();
		return new AdminListPage(driver);
	}

	
}
