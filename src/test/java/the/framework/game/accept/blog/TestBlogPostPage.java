package the.framework.game.accept.blog;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

public class TestBlogPostPage {

	// TODO: reorganise this properly, abstract out the data
	@Test
	public void someTests() {
		
		BlogPostPage page = new BlogPostPage("the-mvc-application");
		
		assertEquals("The MVC application",page.getTitle());
		
		assertTrue(page.getBody().contains("A Play! application follows the MVC architectural pattern as applied"));
		
		assertEquals(asList("Play" , "Architecture" , "MVC"),page.getCategories());
		
		assertEquals("Just a test of YABE",page.getPrevious());
		assertEquals("About the model layer",page.getNext());
		
		assertFalse(page.hasNoPrevious());
		assertFalse(page.hasNoNext());
		
		page.quit();
	}
	
}
