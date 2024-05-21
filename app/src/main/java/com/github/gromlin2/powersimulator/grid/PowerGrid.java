package com.github.gromlin2.powersimulator.grid;

import com.github.gromlin2.powersimulator.electricityproducer.ElectricityProducer;

public final class PowerGrid {
  private final ElectricityProducer producer1;
  private final ElectricityProducer producer2;

  public PowerGrid(ElectricityProducer producer1, ElectricityProducer producer2) {
    this.producer1 = producer1;
    this.producer2 = producer2;
  }

  public int produceElectricity() {
    return producer1.produceElectricity() + producer2.produceElectricity();
  }
}
