package com.github.gromlin2.powersimulator.grid;

import com.github.gromlin2.powersimulator.electricityproducer.ElectricityProducer;
import java.util.Set;

public final class PowerGrid {
  private final Set<ElectricityProducer> producers;

  public PowerGrid(Set<ElectricityProducer> producers) {
    this.producers = producers;
  }

  public int produceElectricity() {
    return producers.stream().mapToInt(ElectricityProducer::produceElectricity).sum();
  }
}
