package com.kakura.springcourse.Project3REST.models;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull
    @DecimalMin(value = "-100", message = "Value should be greater than -100")
    @DecimalMax(value = "100", message = "Value should not be greater than 100")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Raining parameter should not be empty")
    private boolean raining;

    @Column(name = "taken_on")
    @NotNull
    private LocalDateTime takenOn;

    @NotNull(message = "Sensor should not be empty")
    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public LocalDateTime getTakenOn() {
        return takenOn;
    }

    public void setTakenOn(LocalDateTime takenOn) {
        this.takenOn = takenOn;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", raining=" + raining +
                ", takenOn=" + takenOn +
                ", sensor=" + sensor +
                '}';
    }
}
