package the.framework.game.accept.blog.admin;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import the.framework.game.accept.blog.admin.AdminPages;

public class TestAdminPage {

	// TODO: cantAccessAdminWithoutLogin
	// TODO: canLogoutFromAdminPage

	@Test
	public void hasLinksToListPages() {
		final AdminPages admin = new AdminPages();
		List<String> pages = asList("Categories", "Comments", "Posts", "Users");
		for (String pageName : pages) {
			assertTrue(admin.hasListPageFor(pageName));
		}
		admin.quit();
	}

}
