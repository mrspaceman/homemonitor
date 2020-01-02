/**
 * Copyright© Andy Aspell-Clark - All rights reserved
 */

package uk.co.droidinactu.homemonitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public final class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final SensorReadingRepository repository) {
        final LocalDateTime ldt = LocalDateTime.now();
        return (args) -> {
            // save a few SensorReadings
            repository.save(new SensorReading(ldt.plusMinutes(0), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 8.00));
            repository.save(new SensorReading(ldt.plusMinutes(5), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 8.04));
            repository.save(new SensorReading(ldt.plusMinutes(10), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 8.40));
            repository.save(new SensorReading(ldt.plusMinutes(15), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 9.05));
            repository.save(new SensorReading(ldt.plusMinutes(20), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 10.00));
            repository.save(new SensorReading(ldt.plusMinutes(25), SensorLocation.GARAGE, SensorType.DHT22_TEMP, 10.80));

            // fetch all SensorReadings
            Application.LOG.info("SensorReadings found with findAll():");
            Application.LOG.info("-------------------------------");
            repository.findAll().forEach(sensorReading -> {
                Application.LOG.info(sensorReading.toString());
            });
            Application.LOG.info("");

            // fetch an individual SensorReading by ID
            final SensorReading sensorRead = repository.findById(1L);
            Application.LOG.info("SensorReading found with findById(1L):");
            Application.LOG.info("--------------------------------");
            Application.LOG.info(sensorRead.toString());
            Application.LOG.info("");

            // fetch SensorReadings by last location
            Application.LOG.info("SensorReading found with findBySensorLocation(SensorLocation.GARAGE):");
            Application.LOG.info("--------------------------------------------");
            repository.findBySensorLocation(SensorLocation.GARAGE).forEach(sensorReading -> {
                Application.LOG.info(sensorReading.toString());
            });
            Application.LOG.info("");
        };
    }

}
