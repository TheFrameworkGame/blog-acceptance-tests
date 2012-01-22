package the.framework.game.accept.blog;

import static junit.framework.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(value = Parameterized.class)
public class TestCategories {

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = { { "Play" }, { "Architecture" }, { "Test" }, { "MVC" }, };
		return Arrays.asList(data);
	}

	final WebDriver driver;

	final String category;

	public TestCategories(final String category) {
		super();
		this.category = category;
		driver = Seleniums.build();
		Seleniums.localHome(driver);
	}

	@Test
	public void CategoryOnFrontPage() {
		final WebElement element = driver.findElement(By.id("categories"));
		final WebElement categoryLink = element.findElement(By.linkText(category));
		categoryLink.click();
		final String url = driver.getCurrentUrl();
		assertTrue(url.contains("/category/" + category));
	}

	@After
	public void close() {
		driver.quit();
	}
}
