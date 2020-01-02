/**
 * Copyright© Andy Aspell-Clark - All rights reserved
 */

package uk.co.droidinactu.homemonitor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class SensorController {

    private final SensorReadingRepository repository;

    public SensorController(final SensorReadingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    public List<SensorReading> sensorReadings() {
        return (List<SensorReading>) this.repository.findAll();
    }

    @PostMapping("/sensors")
    public SensorReading newSensorReading(@RequestBody final SensorReading newReading) {
        return this.repository.save(newReading);
    }

    @GetMapping("/sensors/{id}")
    public SensorReading getSensorReading(@RequestParam(value = "id", defaultValue = "1.0") final Long id) {
        return null;
    }

}
