package org.costa;

public enum PlaceholderReplacementStrategies {
	DEFAULT(new DefaultStrategy()), COSTA_ALGO(new CostasAlgo());

	private PlaceholderReplacementStrategy strategy;

	private PlaceholderReplacementStrategies(PlaceholderReplacementStrategy strategy) {
		this.strategy = strategy;
	}

	public PlaceholderReplacementStrategy getStrategy() {
		return strategy;
	}
}
