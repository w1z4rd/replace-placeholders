package org.costa;

public class LinearStrategy implements PlaceholderReplacementStrategy {
  private static final int TWO = 2;
  private static final int FOUR = 4;

  public final String replace(final String text, final PlaceholderMap map) {
    if (text == null || text.isEmpty()) {
      return text;
    }
    if (map == null || map.isEmpty()) {
      return text;
    }
    int h = text.indexOf('$');
    if (h == -1) {
      return text;
    }
    StringBuilder clone = new StringBuilder(text);
    int i = h + 1;
    while (h <= clone.length() - map.getShortestPlaceholder()) {
      if (checkPattern(clone, h, i)) {
        while (clone.charAt(i + 1) == '$'
            && i < clone.length() - map.getShortestPlaceholder()) {
          h++;
          i++;
        }
        int x = i + 1;
        int y = x + 1;
        boolean found = false;
        for (int j = getIndexOfClosestExpectedEndingPattern(map, h), k = j + 1;
                k < clone.length(); j++, k++) {
          if (checkPattern(clone, j, k)) {
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
          boolean closer = false;
          for (int t = 0; t < getLengthOfShortestNonEndingPatternSequence(map);
                  t++) {
             if (checkPattern(clone, x, y)) {
                 h = x;
                 i = y;
                 closer = true;
                 break;
             } else {
                 x++;
                 y++;
             }
          }
          if (!closer) {
            h++;
            i++;
          }
        }
      } else {
        h++;
        i++;
      }
    }
    return clone.toString();
  }

  private int getLengthOfShortestNonEndingPatternSequence(
          final PlaceholderMap map) {
      return map.getShortestPlaceholder() - FOUR;
  }

  private int getIndexOfClosestExpectedEndingPattern(final PlaceholderMap map,
          final int startingPatternIndex) {
      return startingPatternIndex + map.getShortestPlaceholder() - TWO;
  }

  private boolean checkPattern(final StringBuilder sb, final int i,
          final int j) {
      return sb.charAt(i) == '$' && sb.charAt(j) == '$';
  }
}
