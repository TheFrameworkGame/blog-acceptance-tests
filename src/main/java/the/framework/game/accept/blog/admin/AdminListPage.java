package the.framework.game.accept.blog.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminListPage {

	private final WebDriver driver;
	
	AdminListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DetailsPage byTitle(String title) {
		WebElement link = driver.findElement(By.linkText(title));
		link.click();
		return new DetailsPage(driver);
	}
	
}
