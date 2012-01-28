package the.framework.game.accept.blog.admin;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TestAuthentication {

	@Test
	public void userCanLogin() {
		try (Authentication auth = new Authentication()) {
			auth.login();
			assertTrue("Not on login page",
					!"login".equalsIgnoreCase(auth.driver.getTitle()));
			assertTrue("User redirected to admin page after login", auth.driver
					.getCurrentUrl().contains("/admin/"));
			
			assertTrue(auth.isAdminVisibleOnHomePage());
			assertTrue(auth.isLogoutVisibleOnHomePage());
			assertFalse(auth.isLoginVisibleOnHomePage());
		}
	}

	@Test
	public void userCanlogout() {
		try (Authentication auth = new Authentication()) {			
			auth.login();			
			auth.logout();
			
			assertFalse(auth.isLogoutVisibleOnHomePage());
			assertTrue(auth.isLoginVisibleOnHomePage());
		}
	}

}
