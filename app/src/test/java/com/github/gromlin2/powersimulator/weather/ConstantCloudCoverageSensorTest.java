package com.github.gromlin2.powersimulator.weather;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConstantCloudCoverageSensorTest {
  @Test
  void constantPercentage() {
    ConstantCloudCoverageSensor constantCloudCoverageSensor = new ConstantCloudCoverageSensor(50);

    assertThat(constantCloudCoverageSensor.currentCloudCoverage()).isEqualTo(new CloudCoverage(50));
  }
}
