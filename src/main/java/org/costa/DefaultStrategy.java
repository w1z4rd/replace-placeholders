package org.costa;

import java.util.Map;

public class DefaultStrategy implements PlaceholderReplacementStrategy {

  public final String replace(final String text,
      final PlaceholderMap map) {
    if (text == null || text.isEmpty()) {
      return text;
    }
    if (map == null || map.isEmpty()) {
      return text;
    }
    StringBuilder clone = new StringBuilder(text);
    for (Map.Entry<String, String> entry : map.getEntries()) {
      String placeholder = entry.getKey();
      String value = entry.getValue();
      int valueLength = 0;
      int i = 0;
      while ((i = clone.indexOf(placeholder, i + valueLength)) >= 0) {
          clone.replace(i, i + placeholder.length(), value);
          valueLength = value.length();
      }
    }
    return clone.toString();
  }

}
