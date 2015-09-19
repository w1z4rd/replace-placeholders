package org.costa;

public enum PlaceholderReplacementStrategies {
  DEFAULT(new DefaultStrategy()), LINEAR(new LinearStrategy());

  private PlaceholderReplacementStrategy strategy;

  private PlaceholderReplacementStrategies(
      final PlaceholderReplacementStrategy replaceStrategy) {
    this.strategy = replaceStrategy;
  }

  public PlaceholderReplacementStrategy getStrategy() {
    return strategy;
  }
}
