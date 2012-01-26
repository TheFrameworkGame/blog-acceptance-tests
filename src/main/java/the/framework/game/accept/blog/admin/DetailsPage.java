package the.framework.game.accept.blog.admin;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class DetailsPage {

	private final WebDriver driver;

	DetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void set(String attribute, String value) {
		
	}
	
	public String getString(String attribute) {
		return null;
	}
	
	public boolean getBoolean(String attribute) {
		return false;
	}
	
	public Map<String,Boolean> getSelection(String attribute) {
		return null;
	}
	
	public void save() {
		
	}
	
	public void delete() {
		
	}
	

}
