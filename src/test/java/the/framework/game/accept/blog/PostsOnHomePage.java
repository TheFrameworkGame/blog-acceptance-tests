package the.framework.game.accept.blog;

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
public class PostsOnHomePage {

	static final Object[][] data = { { "About the model layer", "Bob Johnson", "The model has a central position in a Play! application." },
			{ "The MVC application", "Jeff", "A Play! application follows the MVC architectural pattern." },
			{ "Just a test of YABE", "Bob Johnson", "a test." }, };

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(data);
	}

	private final WebDriver driver;
	private final String title;
	private final String author;
	private final String tease;

	public PostsOnHomePage(final String title, final String author, final String tease) {
		super();
		this.title = title;
		this.author = author;
		this.tease = tease;

		driver = Seleniums.build();
		Seleniums.localHome(driver);
	}

	@Test
	public void teaseIsVisible() {
		Seleniums.findFromClass(driver, "tease", tease, data.length);
	}

	@Test
	public void authorIsVisible() {
		Seleniums.findFromClass(driver, "post-author", author, data.length);
	}

	@Test
	public void checkTitle() {
		final WebElement categoryLink = driver.findElement(By.linkText(title));
		categoryLink.click();
		// TODO: validate the page
	}

	@After
	public void close() {
		driver.quit();
	}

}
