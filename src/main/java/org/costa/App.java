package org.costa;

public class App {

  private PlaceholderReplacementStrategy strategy;
  private PlaceholderMap placeholderMap;

  public final void setPlaceholderReplacementStrategy(
      final PlaceholderReplacementStrategy replaceStrategy) {
    this.strategy = replaceStrategy;
  }

  public final String replace(final StringBuilder text) {
    return strategy.replace(text, placeholderMap);
  }

  public static void main(final String [] args) {
    final StringBuilder text = new StringBuilder(
        "$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ "
        + "asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ "
        + "asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas "
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ "
        + "$$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da$$a$$ "
        + "agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ $$abcdefgh$$ asdsda "
        + "ads$$a$$sadas as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa "
        + "$$xyeza$$ $$abcdefgh$$ asdsda ads$$a$$sadas as$$abcdefgh$$das da"
        + "as$$abcdefgh$$das da$$a$$ agf$$a$$ag $$ab$$ asd$$a$sa $$xyeza$$ ");
    App p = new App();
    p.placeholderMap = new PlaceholderMapImpl();
    p.placeholderMap.addPlaceholderValue("$$a$$", "first_value");
    p.placeholderMap.addPlaceholderValue("$$ab$$", "second_value");
    p.placeholderMap.addPlaceholderValue("$$xyeza$$", "third_value");
    p.placeholderMap.addPlaceholderValue("$$abcdefgh$$", "fourth_value");
    p.setPlaceholderReplacementStrategy(
        PlaceholderReplacementStrategies.LINEAR.getStrategy());
    long start = System.nanoTime();
    String result1 = p.replace(text);
    long end = System.nanoTime();
    System.out.println(end - start);
    p.setPlaceholderReplacementStrategy(
        PlaceholderReplacementStrategies.DEFAULT.getStrategy());
    start = System.nanoTime();
    String result = p.replace(text);
    end = System.nanoTime();
    System.out.println(end - start);
    assert (result1.equals(result));
  }
}
