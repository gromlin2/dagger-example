package com.github.gromlin2.powersimulator.electricityproducer.dagger;

import com.github.gromlin2.powersimulator.electricityproducer.CoalPlant;
import com.github.gromlin2.powersimulator.electricityproducer.ElectricityProducer;
import com.github.gromlin2.powersimulator.electricityproducer.SolarCell;
import com.github.gromlin2.powersimulator.weather.CloudCoverageSensor;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Named;

@Module
public interface ElectricityProducerModule {
  String INITIAL_COAL_PLANT_CAPACITY = "INITIAL_COAL_PLANT_CAPACITY";

  @Provides
  @IntoSet
  static ElectricityProducer coalPlant(@Named(INITIAL_COAL_PLANT_CAPACITY) int initialCapacity) {
    return new CoalPlant(initialCapacity);
  }

  @Provides
  @IntoSet
  static ElectricityProducer solarCell(CloudCoverageSensor cloudCoverageSensor) {
    return new SolarCell(300, cloudCoverageSensor);
  }
}
