package com.github.gromlin2.powersimulator.weather;

/** Retrieve information about the cloud coverage of the sky. */
public interface CloudCoverageSensor {

  /**
   * The current cloud coverage percentage.
   *
   * @return The current cloud coverage percentage as an integer between 0 and 100.
   */
  CloudCoverage currentCloudCoverage();
}
