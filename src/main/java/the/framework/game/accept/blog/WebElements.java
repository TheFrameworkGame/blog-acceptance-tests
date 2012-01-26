package the.framework.game.accept.blog;

import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class WebElements {

	public static final Function<WebElement, String> getText = new Function<WebElement, String>() {
		@Override
		public String apply(WebElement input) {
			return input.getText();
		}
	};
}
