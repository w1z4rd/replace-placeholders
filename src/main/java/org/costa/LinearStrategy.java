package org.costa;

public class LinearStrategy implements PlaceholderReplacementStrategy {

  public final String replace(final String text, final PlaceholderMap map) {
    if (text == null || text.isEmpty()) {
      return text;
    }
    if (map == null || map.isEmpty()) {
      return text;
    }
    StringBuilder clone = new StringBuilder(text);
    int h = 0;
    int i = h + 1;
    while (h <= clone.length() - map.getShortestPlaceholder()) {
      if (clone.charAt(h) == '$' && clone.charAt(i) == '$') {
        boolean found = false;
        for (int j = h + map.getShortestPlaceholder() - 2, k = j + 1; k < clone
            .length(); j++, k++) {
          if (clone.charAt(j) == '$' && clone.charAt(k) == '$') {
            String placeholder = clone.substring(h, k + 1);
            String value = map.getValue(placeholder);
            if (value != null) {
              clone.replace(h, k + 1, value);
              found = true;
              h += value.length();
              i = h + 1;
            } else {
              h = j - 1;
              i = k - 1;
            }
            break;
          }
        }
        if (!found) {
          h++;
          i++;
        }
      } else {
        h++;
        i++;
      }
    }
    return clone.toString();
  }
}
