package com.github.gromlin2.powersimulator.weather;

/**
 * A measure of the cloud coverage of the sky.
 *
 * @param percent The current cloud coverage percentage as an integer between 0 and 100.
 */
public record CloudCoverage(int percent) {

  public CloudCoverage {
    if (percent < 0 || percent > 100) {
      throw new IllegalArgumentException("Cloud coverage must be between 0 and 100.");
    }
  }
}
