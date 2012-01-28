package the.framework.game.accept.blog.admin;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import the.framework.game.accept.blog.admin.AdminPages;

public class TestAdminPage {

	// TODO: canLogoutFromAdminPage

	@Test
	public void hasLinksToListPages() {
		try (AdminPages admin = new AdminPages()) {			
			assertTrue(admin.isAtAdminHome());
			List<String> pages = asList("Categories", "Comments", "Posts", "Users");
			for (String pageName : pages) {
				assertTrue(admin.hasListPageFor(pageName));
			}
		}
	}
	
	@Test
	public void adminRequiresLogin() {
		try (AdminPages admin = new AdminPages(false)) {
			assertTrue(admin.isAtLogin());
		}
	}

}
