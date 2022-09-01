package com.kakura.springcourse.Project3REST.dto;

import com.kakura.springcourse.Project3REST.models.Sensor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class MeasurementDTO {
    @NotNull
    @DecimalMin(value = "-100", message = "Value should be greater than -100")
    @DecimalMax(value = "100", message = "Value should not be greater than 100")
    private Double value;

    @NotNull(message = "Raining parameter should not be empty")
    private boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDTO sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
