package com.github.gromlin2.powersimulator.electricityproducer;

/** Implementations all represent different ways of producing electricity. */
public interface ElectricityProducer {

  /**
   * Produces electricity.
   *
   * @return The amount of electricity produced.
   */
  int produceElectricity();
}
