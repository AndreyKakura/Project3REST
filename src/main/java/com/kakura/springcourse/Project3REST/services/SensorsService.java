package com.kakura.springcourse.Project3REST.services;

import com.kakura.springcourse.Project3REST.models.Sensor;
import com.kakura.springcourse.Project3REST.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }


    @Transactional
    public void save(Sensor sensor) {
        sensorsRepository.save(sensor);
    }


}