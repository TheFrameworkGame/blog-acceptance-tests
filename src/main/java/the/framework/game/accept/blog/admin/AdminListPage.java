package the.framework.game.accept.blog.admin;

import static junit.framework.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminListPage {

	final WebDriver driver;

	AdminListPage(WebDriver driver) {
		this.driver = driver;
	}

	public AdminDetailsPage getDetailsPage(String title) {
		WebElement link = driver.findElement(By.linkText(title));
		link.click();
		return new AdminDetailsPage(driver);
	}

	public boolean hasPost(String title) {
		return !driver.findElements(By.linkText(title)).isEmpty();
	}

	public void goHere() {
		// TODO
	}

	public void checkOnListPage() {
		// TODO
		// assertTrue("redirected to post list after save",
		// postList.driverIsOnListPage());
	}

	public AdminDetailsPage addObject() {
		driver.findElement(By.linkText("Add Post")).click();
		assertTrue("Failed to go to details page for new post", driver
				.getCurrentUrl().contains("/admin/posts/new"));
		return new AdminDetailsPage(driver);
	}

}
