/**
 * Copyright© Andy Aspell-Clark - All rights reserved$
 */

package uk.co.droidinactu.homemonitor;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public final class SensorReading {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime datetime = LocalDateTime.now();
    private SensorType sensorType = SensorType.UNKNOWN;
    private SensorLocation sensorLocation = SensorLocation.UNKNOWN;
    private double value = 0;

    public SensorReading() {
    }

    public SensorReading(
            final LocalDateTime readingDate,
            final SensorLocation sensorLocation, final SensorType sensorType,
            final double value) {
        this.datetime = readingDate;
        this.sensorLocation = sensorLocation;
        this.sensorType = sensorType;
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public SensorType getType() {
        return this.sensorType;
    }

    public void setType(final SensorType type) {
        this.sensorType = type;
    }

    public LocalDateTime getDatetime() {
        return this.datetime;
    }

    public void setDatetime(final LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public SensorLocation getLocation() {
        return this.sensorLocation;
    }

    public void setLocation(final SensorLocation location) {
        this.sensorLocation = location;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Sensor: %s at %s, read at %tY-%tm-%td %tH-%tM-%tS value: %f",
                this.sensorType, this.sensorLocation, this.datetime, this.datetime, this.datetime, this.datetime, this.datetime, this.datetime, this.value);
    }
}
