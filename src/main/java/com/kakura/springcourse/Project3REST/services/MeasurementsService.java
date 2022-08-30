package com.kakura.springcourse.Project3REST.services;

import com.kakura.springcourse.Project3REST.models.Measurement;
import com.kakura.springcourse.Project3REST.models.Sensor;
import com.kakura.springcourse.Project3REST.repositories.MeasurementsRepository;
import com.kakura.springcourse.Project3REST.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    public Long getRainyDaysCount() {
        return measurementsRepository.findAll().stream().filter(Measurement::isRaining).count();
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setTakenOn(LocalDateTime.now());
        measurement.setSensor(sensorsRepository.findByName(measurement.getSensor().getName()).get());
    }
}
