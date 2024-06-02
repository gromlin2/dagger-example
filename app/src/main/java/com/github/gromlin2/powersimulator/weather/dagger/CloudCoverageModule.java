package com.github.gromlin2.powersimulator.weather.dagger;

import com.github.gromlin2.powersimulator.weather.CloudCoverageSensor;
import com.github.gromlin2.powersimulator.weather.ConstantCloudCoverageSensor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public interface CloudCoverageModule {
  String CLOUD_COVER_PERCENTAGE = "CLOUD_COVER_PERCENTAGE";

  @Provides
  @Singleton
  static CloudCoverageSensor cloudCoverageSensor(
      @Named(CLOUD_COVER_PERCENTAGE) int cloudCoverPercentage) {
    return new ConstantCloudCoverageSensor(cloudCoverPercentage);
  }
}
