package the.framework.game.accept.blog;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class TestAuthentication {

	Authentication auth = new Authentication();

	@Test
	public void userCanLogin() {
		auth.login();
		WebDriver driver = auth.getDriver();
		assertTrue("Not on login page",
				!"login".equalsIgnoreCase(driver.getTitle()));
		assertTrue("User redirected to admin page after login", driver.getCurrentUrl().contains("/admin/"));
	}
	
	// TODO: test that login/logout buttons are appropriately displayed normally
	// TODO: test that admin button only appears when relevant
	
	@Test
	public void userCanlogout() {
		auth.login();

		auth.logout();
		
		WebDriver driver = auth.getDriver();
		
		Seleniums.localGet(driver, "/");
		
		try {
			driver.findElement(By.partialLinkText("logout"));
			fail("logout button found after logout");
		} catch (NoSuchElementException e) {
			driver.findElement(By.partialLinkText("login"));
		}
	}

	@After
	public void quit() {
		auth.getDriver().quit();
	}

}
