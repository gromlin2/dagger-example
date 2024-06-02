package com.github.gromlin2.powersimulator;

import com.github.gromlin2.powersimulator.grid.PowerGrid;

public final class Main {

  public static void main(String[] args) {
    final SimulatorComponent simulator =
        DaggerSimulatorComponent.builder()
            .cloudCoverPercentage(25)
            .initialCoalPlantCapacity(5)
            .build();
    final PowerGrid powerGrid = simulator.grid();

    final var producedElectricity = powerGrid.produceElectricity();

    System.out.println("Total electricity produced: " + producedElectricity + " watts");
  }
}
