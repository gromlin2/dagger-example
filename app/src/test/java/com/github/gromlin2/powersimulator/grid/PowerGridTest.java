package com.github.gromlin2.powersimulator.grid;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.gromlin2.powersimulator.electricityproducer.ElectricityProducer;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PowerGridTest {
  private PowerGrid powerGrid;

  @Test
  void produceElectricity() {
    ElectricityProducer producer1 = () -> 2;
    ElectricityProducer producer2 = () -> 3;
    powerGrid = new PowerGrid(Set.of(producer1, producer2));

    assertThat(powerGrid.produceElectricity()).isEqualTo(5);
  }

  @Test
  void produceElectricityWithZeroProducers() {
    ElectricityProducer producer1 = () -> 0;
    ElectricityProducer producer2 = () -> 0;
    powerGrid = new PowerGrid(Set.of(producer1, producer2));

    assertThat(powerGrid.produceElectricity()).isZero();
  }
}
