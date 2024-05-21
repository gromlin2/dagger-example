package com.github.gromlin2.powersimulator.electricityproducer;

/** An electricity producer that uses coal as source of energy. */
public final class CoalPlant implements ElectricityProducer {
  private int remainingCoal;

  public CoalPlant(int initialAmount) {
    remainingCoal = initialAmount;
    if (remainingCoal < 0) {
      throw new IllegalArgumentException("Coal amount must be non-negative");
    }
  }

  @Override
  public int produceElectricity() {
    if (remainingCoal <= 0) {
      // Can't produce electricity without coal
      return 0;
    }

    remainingCoal = remainingCoal - 1;
    return 800;
  }

  public int getRemainingCoal() {
    return remainingCoal;
  }
}
