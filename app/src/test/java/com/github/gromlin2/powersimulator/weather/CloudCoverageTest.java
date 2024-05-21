package com.github.gromlin2.powersimulator.weather;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CloudCoverageTest {
  @Test
  void cloudCoverage() {
    CloudCoverage cloudCoverage = new CloudCoverage(50);

    assertThat(cloudCoverage.percent()).isEqualTo(50);
  }

  @Test
  void cloudCoverageTooHigh() {
    assertThatThrownBy(() -> new CloudCoverage(101))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Cloud coverage must be between 0 and 100.");
  }

  @Test
  void cloudCoverageTooLow() {
    assertThatThrownBy(() -> new CloudCoverage(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Cloud coverage must be between 0 and 100.");
  }
}
