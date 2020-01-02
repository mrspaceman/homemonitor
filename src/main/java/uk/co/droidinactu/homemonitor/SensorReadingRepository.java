/**
 * Copyright© Andy Aspell-Clark - All rights reserved$
 */

package uk.co.droidinactu.homemonitor;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorReadingRepository extends CrudRepository<SensorReading, Long> {

    List<SensorReading> findBySensorLocation(SensorLocation location);

    List<SensorReading> findBySensorType(SensorType type);

    SensorReading findById(long id);
}
