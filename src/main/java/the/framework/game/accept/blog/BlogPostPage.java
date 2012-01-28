package the.framework.game.accept.blog;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPostPage {

	private final String slug;
	
	private final WebDriver driver;

	public void quit() {
		driver.quit();
	}

	public BlogPostPage(String slug) {
		super();
		this.slug = slug;
		driver = Seleniums.build();
		Seleniums.localGet(driver,"/post/"+slug);
	}

	public String getPrevious() {
		return getAInIdText("previous").substring(2);
	}
	
	public String getNext() {
		String s = getAInIdText("next");
		return s.substring(0,s.length() - 2);
	}
	
	private String getAInIdText(String id) {
		return driver.findElement(By.id(id)).findElement(By.tagName("a")).getText();
	}

	public boolean hasNoPrevious() {
		try {
			getPrevious();
			return false;
		} catch (NullPointerException e) {
			return true;
		}
	}

	public boolean hasNoNext() {
		try {
			getNext();
			return false;
		} catch (NullPointerException e) {
			return true;
		}
	}

	public List<String> getCategories() {
		WebElement authorDiv = driver.findElement(By.className("post-author"));
		return newArrayList(transform(authorDiv.findElements(By.tagName("a")), WebElements.getText));
	}

	public String getTitle() {
		WebElement element = driver.findElement(By.tagName("h2"));
		return element.getText();
	}

	public String getBody() {
		WebElement element = driver.findElement(By.className("post-body"));
		return element.getText();
	}

}
