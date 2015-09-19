package org.costa;

import java.util.Map.Entry;
import java.util.Set;

public interface PlaceholderMap {

  void addPlaceholderValue(String placeholder, String value);

  String getValue(String placeholder);

  int getLongesPlaceholder();

  int getShortestPlaceholder();

  Set<Entry<String, String>> getEntrySet();
}
