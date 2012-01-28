package the.framework.game.accept.blog.admin;

import static junit.framework.Assert.assertEquals;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminDetailsPage {

	// TODO: add state check in order to make sure driver is on the correct page

	private final WebDriver driver;

	AdminDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getAttribute(String attribute) {
		return driver.findElement(By.id("object_" + attribute));
	}

	public void setString(String attribute, String value) {
		System.out.println("Setting " + attribute + " to " + value);
		WebElement element = getAttribute(attribute);

		switch (element.getTagName()) {
		case "input":
		case "textarea":
			element.clear();
			element.sendKeys(value);
			break;

		case "select":
			Select select = new Select(element);
			if (select.isMultiple())
				select.deselectAll();
			select.selectByVisibleText(value);
			break;

		default:
			throw new IllegalArgumentException("Unknown type: "
					+ element.getTagName());
		}

	}

	public String getString(String attribute) {
		WebElement element = getAttribute(attribute);
		switch (element.getTagName()) {
		case "input":
		case "textarea":
			return element.getAttribute("value");
			
		case "select":
			Select select = new Select(element);
			return select.getFirstSelectedOption().getText();
			
		default:
			throw new IllegalArgumentException("Unknown type: "
					+ element.getTagName());
		}
	}

	public boolean getCheckbox(String attribute) {
		return false;
	}

	public void setCheckbox(String attribute, boolean value) {

	}

	public void set(Map<String, ?> values) {
		for (Entry<String, ?> entry : values.entrySet()) {
			if (entry.getValue() instanceof String) {
				String str = (String) entry.getValue();
				setString(entry.getKey(), str);
			} else if (entry.getValue() instanceof Boolean) {
				Boolean bool = (Boolean) entry.getValue();
				setCheckbox(entry.getKey(), bool);
			} else
				throw new IllegalArgumentException("Unknown type for value: "
						+ entry.getValue());
		}
	}

	public void check(Map<String, ?> values) {
		for (Entry<String, ?> entry : values.entrySet()) {
			if (entry.getValue() instanceof String) {
				assertEquals(entry.getValue(), getString(entry.getKey()));
			} else if (entry.getValue() instanceof Boolean) {
				assertEquals(entry.getValue(), getCheckbox(entry.getKey()));
			} else
				throw new IllegalArgumentException("Unknown type for value: "
						+ entry.getValue());
		}
	}

	public void save() {
		driver.findElement(By.name("_save")).submit();
	}

	public void delete() {
		driver.findElement(By.className("crudDelete")).findElement(By.tagName("input")).submit();
	}

}
