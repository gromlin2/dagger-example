package com.github.gromlin2.powersimulator.electricityproducer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.gromlin2.powersimulator.weather.CloudCoverage;
import com.github.gromlin2.powersimulator.weather.CloudCoverageSensor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolarCellTest {

  @ParameterizedTest
  @CsvSource({
    "300, 0, 300",
    "300, 10, 270",
    "300, 50, 150",
    "300, 90, 30",
    "300, 100, 0",
    "500, 0, 500",
    "500, 10, 450",
    "500, 50, 250",
    "500, 90, 50",
    "500, 100, 0",
  })
  void produceElectricity(int wattPeak, int cloudCoveragePercent, int expected) {
    var coverageSensor = mock(CloudCoverageSensor.class);
    when(coverageSensor.currentCloudCoverage()).thenReturn(new CloudCoverage(cloudCoveragePercent));

    SolarCell solarCell = new SolarCell(wattPeak, coverageSensor);

    var produced = solarCell.produceElectricity();

    assertThat(produced).isEqualTo(expected);
  }

  @Test
  void negativeWattPeak() {
    assertThatThrownBy(() -> new SolarCell(-1, mock(CloudCoverageSensor.class)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Watt peak must be non-negative");
  }
}
