package com.github.gromlin2.powersimulator.weather;

/** A sensor that provides a constant cloud coverage percentage. */
public final class ConstantCloudCoverageSensor implements CloudCoverageSensor {
  private final int cloudCoverPercentage;

  public ConstantCloudCoverageSensor(int cloudCoverPercentage) {
    this.cloudCoverPercentage = cloudCoverPercentage;
  }

  @Override
  public CloudCoverage currentCloudCoverage() {
    return new CloudCoverage(cloudCoverPercentage);
  }
}
