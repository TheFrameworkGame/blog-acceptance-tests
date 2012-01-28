package the.framework.game.accept.blog.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static the.framework.game.accept.blog.ReadableBoolean.NO;
import static the.framework.game.accept.blog.ReadableBoolean.YES;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import the.framework.game.accept.blog.BlogPostPage;
import the.framework.game.accept.blog.ReadableBoolean;
import the.framework.game.accept.blog.Seleniums;

import com.google.common.collect.ImmutableMap;

public class TestPostAdmin {

	static AdminListPage postList;

	@BeforeClass
	public static void gotoPage() {
		postList = new AdminPages().getList("Posts");
	}

	private void hasPost(String postTitle, ReadableBoolean yes) {
		boolean value = yes.toBool();
		assertEquals("Has a post with the same name I'm about to create",
				value, postList.hasPost(postTitle));
	}

	@Test
	public void addAndDeletePost() {
		String postTitle = "new post";
		String slug = "new-post";
		String content = "test post content";

		hasPost(postTitle, NO);

		// Add
		AdminDetailsPage details = postList.addObject();

		Map<String, ?> values = ImmutableMap.<String, Object> builder()
				.put("title", postTitle).put("slug", slug)
				.put("postedAt", "2012-12-12")
				.put("content", content)
				.put("tease", "test post tease")
				.put("author", Seleniums.getUsername())
				// TODO: categories .put("categories", value)
				.build();

		details.set(values);
		details.check(values);
		details.save();

		// Check		
		postList.checkOnListPage();
		hasPost(postTitle, YES);
		
		BlogPostPage page = new BlogPostPage(slug);
		assertTrue(page.getCategories().isEmpty());
		assertEquals(postTitle, page.getTitle());
		assertEquals(content,page.getBody());

		// Delete
		details = postList.getDetailsPage((String) values.get("title"));
		details.delete();
		
		postList.checkOnListPage();
		hasPost(postTitle, NO);
	}

	// TODO: test required/optional fields
	// TODO: test search

	@AfterClass
	public static void close() {
		postList.driver.quit();
	}

}
