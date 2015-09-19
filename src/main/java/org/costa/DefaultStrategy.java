package org.costa;

import java.util.Map;

public class DefaultStrategy implements PlaceholderReplacementStrategy {

	public String replace(final StringBuilder text, final PlaceholderMap parameters) {
		StringBuilder clone = new StringBuilder(text);
		for (Map.Entry<String, String> entry : parameters.getEntrySet()) {
			String placeholder = entry.getKey();
			String value = entry.getValue();
			int i = -1;
			while ((i = clone.indexOf(placeholder)) >= 0) {
				String substr = clone.substring(i, i + placeholder.length());
				if (substr.equals(placeholder)) {
					clone.replace(i, i + placeholder.length(), value);
					i = value.length() + 1;
				}
			}
		}
		return clone.toString();
	}

}
