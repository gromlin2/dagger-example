package com.github.gromlin2.powersimulator;

import com.github.gromlin2.powersimulator.electricityproducer.CoalPlant;
import com.github.gromlin2.powersimulator.electricityproducer.SolarCell;
import com.github.gromlin2.powersimulator.grid.PowerGrid;
import com.github.gromlin2.powersimulator.weather.ConstantCloudCoverageSensor;

public final class Main {

  public static void main(String[] args) {
    final var cloudCoverageSensor = new ConstantCloudCoverageSensor(25);
    final var powerGrid = new PowerGrid(new CoalPlant(5), new SolarCell(300, cloudCoverageSensor));
    final var producedElectricity = powerGrid.produceElectricity();

    System.out.println("Total electricity produced: " + producedElectricity + " watts");
  }
}
