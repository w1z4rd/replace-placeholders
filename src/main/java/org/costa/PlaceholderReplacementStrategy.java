package org.costa;

public interface PlaceholderReplacementStrategy {

  String replace(final String text, final PlaceholderMap placeholderMap);
}
