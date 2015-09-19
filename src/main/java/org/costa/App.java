package org.costa;

public class App {

	private PlaceholderReplacementStrategy strategy;
	private PlaceholderMap placeholderMap;

	public void setPlaceholderReplacementStrategy(PlaceholderReplacementStrategy strategy) {
		this.strategy = strategy;
	}

	public String replace(StringBuilder text) {
		return strategy.replace(text, placeholderMap);
	}

	// TODO: think about corner cases and implement JUnit tests for them
	public static void main(String args[]) {
		StringBuilder text = new StringBuilder(
				"$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da"
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
				+ "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag "
				+ "$$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das "
				+ "da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
				+ "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ "
				+ "asdsda ads$$a$$sadas as$$abcdefgh$$das da");
		App p = new App();
		p.placeholderMap = new PlaceholderMapImpl();
		p.placeholderMap.addPlaceholderValue("$$a$$", "first_value");
		p.placeholderMap.addPlaceholderValue("$$ab$$", "second_value");
		p.placeholderMap.addPlaceholderValue("$$xyeza$$", "third_value");
		p.placeholderMap.addPlaceholderValue("$$abcdefgh$$", "fourth_value");
		p.setPlaceholderReplacementStrategy(PlaceholderReplacementStrategies.COSTA_ALGO.getStrategy());
		long start = System.nanoTime();
		String result = p.replace(text);
		long end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(result);
		p.setPlaceholderReplacementStrategy(PlaceholderReplacementStrategies.DEFAULT.getStrategy());
		start = System.nanoTime();
		result = p.replace(text);
		end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(result);
	}
}
