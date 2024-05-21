package com.github.gromlin2.powersimulator.electricityproducer;

import com.github.gromlin2.powersimulator.weather.CloudCoverageSensor;

/** An electricity producer that uses the sun as source of energy. */
public final class SolarCell implements ElectricityProducer {
  private final int wattPeak;
  private final CloudCoverageSensor cloudCoverage;

  public SolarCell(int wattPeak, CloudCoverageSensor cloudCoverage) {
    this.wattPeak = wattPeak;
    this.cloudCoverage = cloudCoverage;

    if (wattPeak < 0) {
      throw new IllegalArgumentException("Watt peak must be non-negative");
    }
  }

  @Override
  public int produceElectricity() {
    int currentCoveragePercent = cloudCoverage.currentCloudCoverage().percent();

    return ((100 - currentCoveragePercent) * wattPeak) / 100;
  }
}
