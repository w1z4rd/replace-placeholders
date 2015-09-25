package org.costa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class DefaultStrategyTest {

  private PlaceholderReplacementStrategy strategy = new DefaultStrategy();
  private PlaceholderMap map;

  @Before
  public void before() {
      map = new PlaceholderMapImpl();
  }

  @After
  public void after() {
      map = null;
  }

  @Test
  public void TestNullPlaceholderMap() {
    String text = "";
    PlaceholderMap map = null;

    String expected = "";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestNullText() {
    String text = null;

    String expected = null;
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestEmptyPlaceholderMap() {
    String text = "random text";

    String expected = "random text";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestEmptyText() {
    String text = "";

    String expected = "";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestShortestPlaceholderLargerThanTextLenght() {
    String text = "a";
    map.addPlaceholderValue("$$a$$", "value");

    String expected = "a";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextWithNoPlaceholders() {
    String text = "random text with no placeholders";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$ab$$", "value");

    String expected = "random text with no placeholders";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestLongestPlaceholderLargerThanTextLenght() {
    String text = "short $$a$$ text";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$really long placeholder value$$", "value");

    String expected = "short value text";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestPlaceholderValueWithPlaceholderPattern() {
    String text = "short $$a$$ text";
    map.addPlaceholderValue("$$a$$", "value $$a$$");

    String expected = "short value $$a$$ text";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextWithMultipleStartPlaceholderPatterns() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t";
    map.addPlaceholderValue("$$a$$", "value");

    String expected = "sh$$or$$t value t$$e$$x$$t";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextStartingWithShortestPattern() {
    String text = "$$a$$ sh$$pattern$$t $$a$$ t$$e$$x$$t";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "value shlongValt value t$$e$$x$$t";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextStartingWithLongestPattern() {
    String text = "$$pattern$$sh$$or$$t $$a$$ t$$e$$x$$t";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "longValsh$$or$$t value t$$e$$x$$t";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextEndingWithShortestPattern() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t$$a$$";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "sh$$or$$t value t$$e$$x$$tvalue";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestTextEndingWithLongestPattern() {
    String text = "sh$$or$$t $$a$$ t$$e$$x$$t$$pattern$$";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "sh$$or$$t value t$$e$$x$$tlongVal";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestNextStartingPatternDistShorterThanShortestPlaceholderLenght() {
    String text = "sh$$or$$aaaaa$$t $$a$$ t$$e$$x$$t$$pattern$$";
    map.addPlaceholderValue("$$aaaaa$$", "value");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "sh$$orvaluet $$a$$ t$$e$$x$$tlongVal";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithOddConsecutiveStartingPatterns() {
    String text = "$$$$$aaaaa$$sh$$or$$$aaaaa$$t $$a$$ t$$e$$x$$t$$$pattern$$";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "$$$midValuesh$$or$midValuet value t$$e$$x$$t$longVal";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithEvenConsecutiveStartingPatterns() {
    String text = "$$$$aaaaa$$sh$$or$$$$aaaaa$$$$t $$a$$ t$$e$$x$$t$$$$pattern$$$$";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "$$midValuesh$$or$$midValue$$t value t$$e$$x$$t$$longVal$$";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }

  @Test
  public void TestWithOnlyStartingPatterns() {
    String text = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
    map.addPlaceholderValue("$$a$$", "value");
    map.addPlaceholderValue("$$aaaaa$$", "midValue");
    map.addPlaceholderValue("$$pattern$$", "longVal");

    String expected = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";
    String actual = strategy.replace(text, map);

    assertEquals(expected, actual);
  }
}
