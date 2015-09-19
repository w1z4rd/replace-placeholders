package org.costa;

public interface PlaceholderReplacementStrategy {

	String replace(final StringBuilder text, final PlaceholderMap placeholderMap);
}
