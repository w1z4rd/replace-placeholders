package org.costa;

public enum PlaceholderReplacementStrategies {
	DEFAULT(new DefaultStrategy()), LINEAR(new LinearStrategy());

	private PlaceholderReplacementStrategy strategy;

	private PlaceholderReplacementStrategies(PlaceholderReplacementStrategy strategy) {
		this.strategy = strategy;
	}

	public PlaceholderReplacementStrategy getStrategy() {
		return strategy;
	}
}
