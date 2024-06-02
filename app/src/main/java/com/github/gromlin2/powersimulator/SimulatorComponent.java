package com.github.gromlin2.powersimulator;

import static com.github.gromlin2.powersimulator.electricityproducer.dagger.ElectricityProducerModule.INITIAL_COAL_PLANT_CAPACITY;
import static com.github.gromlin2.powersimulator.weather.dagger.CloudCoverageModule.CLOUD_COVER_PERCENTAGE;

import com.github.gromlin2.powersimulator.electricityproducer.dagger.ElectricityProducerModule;
import com.github.gromlin2.powersimulator.grid.PowerGrid;
import com.github.gromlin2.powersimulator.weather.dagger.CloudCoverageModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Component(modules = {CloudCoverageModule.class, ElectricityProducerModule.class})
public interface SimulatorComponent {

  PowerGrid grid();

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder initialCoalPlantCapacity(@Named(INITIAL_COAL_PLANT_CAPACITY) int initialCoalCapacity);

    @BindsInstance
    Builder cloudCoverPercentage(@Named(CLOUD_COVER_PERCENTAGE) int cloudCoverPercentage);

    SimulatorComponent build();
  }
}
