package org.costa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PlaceholderMapImpl implements PlaceholderMap {

	int longestPlaceholder = 0;
	int shortestPlaceholder = Integer.MAX_VALUE;

	Map<String, String> parameters = new HashMap<String, String>();

	public String getValue(String placeholder) {
		return parameters.get(placeholder);
	}

	public void addPlaceholderValue(String placeholder, String value) {
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

	public int getLongesPlaceholder() {
		return longestPlaceholder;
	}

	public int getShortestPlaceholder() {
		return shortestPlaceholder;
	}

	public String toString() {
		return "map:" + parameters + "\nlongest: " + longestPlaceholder + "\nshortest: " + shortestPlaceholder;
	}

	public Set<Entry<String, String>> getEntrySet() {
		return parameters.entrySet();
	}

}
