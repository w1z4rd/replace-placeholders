package org.costa;

import java.util.Map.Entry;
import java.util.Set;

public interface PlaceholderMap {

  boolean isEmpty();

  int getLongesPlaceholder();

  int getShortestPlaceholder();

  String getValue(String placeholder);

  Set<Entry<String, String>> getEntries();

  void addPlaceholderValue(String placeholder, String value);
}
