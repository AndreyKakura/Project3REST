package com.kakura.springcourse.Project3REST.repositories;

import com.kakura.springcourse.Project3REST.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByName(String name);
}
