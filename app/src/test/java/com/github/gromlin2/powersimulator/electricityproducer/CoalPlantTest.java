package com.github.gromlin2.powersimulator.electricityproducer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CoalPlantTest {

  @Test
  void initialCoal() {
    CoalPlant plant = new CoalPlant(3);
    assertThat(plant.getRemainingCoal()).isEqualTo(3);
  }

  @Test
  void produceElectricity() {
    CoalPlant plant = new CoalPlant(3);

    var produced = plant.produceElectricity();

    assertThat(produced).isEqualTo(800);
    assertThat(plant.getRemainingCoal()).isEqualTo(2);
  }

  @Test
  void noProductionWithoutCoal() {
    CoalPlant plant = new CoalPlant(0);

    var produced = plant.produceElectricity();

    assertThat(produced).isEqualTo(0);
    assertThat(plant.getRemainingCoal()).isZero();
  }

  @Test
  void negativeCoalAmount() {
    assertThatThrownBy(() -> new CoalPlant(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Coal amount must be non-negative");
  }
}
