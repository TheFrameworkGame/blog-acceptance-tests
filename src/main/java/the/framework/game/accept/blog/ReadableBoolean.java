package the.framework.game.accept.blog;

public enum ReadableBoolean {

	YES,
	NO;

	public boolean toBool() {
		return this == YES;
	}
}
