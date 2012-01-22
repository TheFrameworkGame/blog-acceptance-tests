package the.framework.game.accept.blog;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Abstraction over decisions we might want to change later, eg which WebDriver to use.
 * 
 * @author richard
 * 
 */
public class Seleniums {

	private static final String testingURL = "http://localhost:9000";

	public static WebDriver build() {
		return new HtmlUnitDriver();
	}

	public static void localGet(final WebDriver driver, final String suffix) {
		driver.get(testingURL + suffix);
	}

	public static void localHome(final WebDriver driver) {
		driver.get(testingURL);
	}

	public static void findFromClass(final WebDriver driver, final String className, final String contains, final int total) {
		boolean found = false;
		final List<WebElement> elements = driver.findElements(By.className(className));
		assertEquals(total, elements.size());
		for (final WebElement element : elements) {
			if (element.getText().contains(contains)) {
				found = true;
			}
		}

		assertTrue(found);
	}
}
