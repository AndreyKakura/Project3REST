package com.kakura.springcourse.Project3REST.repositories;

import com.kakura.springcourse.Project3REST.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {

}
