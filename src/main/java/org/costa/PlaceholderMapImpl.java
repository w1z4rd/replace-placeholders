package org.costa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PlaceholderMapImpl implements PlaceholderMap {

  private int longestPlaceholder = 0;
  private int shortestPlaceholder = Integer.MAX_VALUE;

  private Map<String, String> parameters = new HashMap<String, String>();

  public final String getValue(final String placeholder) {
    return parameters.get(placeholder);
  }

  public final void addPlaceholderValue(final String placeholder,
      final String value) {
    if (placeholder == null) {
      return;
    }
    if (placeholder.length() < shortestPlaceholder) {
      shortestPlaceholder = placeholder.length();
    }
    if (placeholder.length() > longestPlaceholder) {
      longestPlaceholder = placeholder.length();
    }
    parameters.put(placeholder, value);
  }

  public final int getLongesPlaceholder() {
    return longestPlaceholder;
  }

  public final int getShortestPlaceholder() {
    return shortestPlaceholder;
  }

  public final String toString() {
    return "map:" + parameters + "\nlongest: " + longestPlaceholder
        + "\nshortest: " + shortestPlaceholder;
  }

  public final Set<Entry<String, String>> getEntrySet() {
    return parameters.entrySet();
  }

}
