package org.costa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinearStrategyTest {

  @Test
  public void TestNullPlaceholderMap() {
    String text = "";
    PlaceholderMap map = null;
    LinearStrategy l = new LinearStrategy();

    String expected = "";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestNullText() {
    String text = null;
    PlaceholderMap map = new PlaceholderMapImpl();
    LinearStrategy l = new LinearStrategy();

    String expected = null;
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestEmptyPlaceholderMap() {
    String text = "random text";
    PlaceholderMap map = new PlaceholderMapImpl();
    LinearStrategy l = new LinearStrategy();

    String expected = "random text";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestEmptyText() {
    String text = "";
    PlaceholderMap map = new PlaceholderMapImpl();
    LinearStrategy l = new LinearStrategy();

    String expected = "";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestShortestPlaceholderLargerThanTextLenght() {
    String text = "a";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    LinearStrategy l = new LinearStrategy();

    String expected = "a";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextWithNoPlaceholders() {
    String text = "random text with no placeholders";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$ab$$", "value");
    LinearStrategy l = new LinearStrategy();

    String expected = "random text with no placeholders";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestLongestPlaceholderLargerThanTextLenght() {
    String text = "short $$a$$ text";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$really long placeholder value$$", "value");
    LinearStrategy l = new LinearStrategy();

    String expected = "short value text";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestPlaceholderValueWithPlaceholderPattern() {
    String text = "short $$a$$ text";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value $$a$$");
    LinearStrategy l = new LinearStrategy();

    String expected = "short value $$a$$ text";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextWithMultipleStartPlaceholderPatterns() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    LinearStrategy l = new LinearStrategy();

    String expected = "sh$$or$$t value t$$e$$x$$t";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextStartingWithShortestPattern() {
    String text = "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "value shlongValt value t$$e$$x$$t";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextStartingWithLongestPattern() {
    String text = "$$pattern$$sh$$or$$t $$a$$ t$$e$$x$$t";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "longValsh$$or$$t value t$$e$$x$$t";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextEndingWithShortestPattern() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t$$a$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "sh$$or$$t value t$$e$$x$$tvalue";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextEndingWithLongestPattern() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t$$pattern$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "sh$$or$$t value t$$e$$x$$tlongVal";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestNextStartingPatternDistShorterThanShortestPlaceholderLenght() {
    String text = "sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$aaaaa$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "sh$$orvaluet $$a$$ t$$e$$x$$tlongVal";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithOddConsecutiveStartingPatterns() {
    String text = "$$$$$aaaaa$$sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "$$$midValuesh$$ormidValuet value t$$e$$x$$tlongVal";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithEvenConsecutiveStartingPatterns() {
    String text = "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "$$midValuesh$$or$$midValue$$t value t$$e$$x$$t$$longVal$$";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithOnlyStartingPatterns() {
    String text = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
    PlaceholderMap map = new PlaceholderMapImpl();
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");
    LinearStrategy l = new LinearStrategy();

    String expected = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
    String actual = l.replace(text, map);

    assertEquals(expected, actual);
  }
}
