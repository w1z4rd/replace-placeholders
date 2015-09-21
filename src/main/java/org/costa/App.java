package org.costa;

public class App {

  private PlaceholderReplacementStrategy strategy;
  private PlaceholderMap placeholderMap;

  public final void setPlaceholderReplacementStrategy(
      final PlaceholderReplacementStrategy replaceStrategy) {
    this.strategy = replaceStrategy;
  }

  public final String replace(final String text) {
    return strategy.replace(text, placeholderMap);
  }

  public static void main(final String [] args) {
    final String text = "random textarandom text with no placeholdersshort "
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o"
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o"
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o"
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o"
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o"
        + "$$a$$ text short $$a$$ text sh$$or$$t $$a$$ t$$e$$x$$t"
        + "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t$$pattern$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t sh$$or$$t $$a$$ t$$e$$x$$t$$a$$sh$$or$$t $$a$$ "
        + "t$$e$$x$$t$$pattern$$ sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$"
        + "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$"
        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$aa$$sh$$oaa$$sh$$oaa$$sh$$oaa$$sh$$o";
    App p = new App();
    p.placeholderMap = new PlaceholderMapImpl();
    p.placeholderMap.addPlaceholderValue("$$a$$", "first_value");
    p.placeholderMap.addPlaceholderValue("$$aa$$", "aa_value");
    p.placeholderMap.addPlaceholderValue("$$ab$$", "second_value");
    p.placeholderMap.addPlaceholderValue("$$or$$", "or_value");
    p.placeholderMap.addPlaceholderValue("$$xyeza$$", "third_value");
    p.placeholderMap.addPlaceholderValue("$$abcdefgh$$", "fourth_value");
    p.placeholderMap.addPlaceholderValue("$$pattern$$", "fifth_value");
    p.placeholderMap.addPlaceholderValue("$$aaaaa$$", "sixth_value");
    p.setPlaceholderReplacementStrategy(
        PlaceholderReplacementStrategies.DEFAULT.getStrategy());
    long start = System.nanoTime();
    String result1 = p.replace(text);
    long end = System.nanoTime();
    System.out.println(end - start);
    p.setPlaceholderReplacementStrategy(
        PlaceholderReplacementStrategies.LINEAR.getStrategy());
    start = System.nanoTime();
    String result = p.replace(text);
    end = System.nanoTime();
    System.out.println(end - start);
    assert (result1.equals(result));
  }
}

