package org.costa;

public class CostasAlgo implements PlaceholderReplacementStrategy {

	@Override
	public String replace(final StringBuilder text, final PlaceholderMap map) {
		StringBuilder clone = new StringBuilder(text);
		for (int h = 0, i = h + 1; h < clone.length() - map.getShortestPlaceholder() - 1;) {
			if (clone.charAt(h) == '$' && clone.charAt(i) == '$') {
				boolean found = false;
				for (int j = h + map.getShortestPlaceholder() - 2, k = j + 1; k < clone.length(); j++, k++) {
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
