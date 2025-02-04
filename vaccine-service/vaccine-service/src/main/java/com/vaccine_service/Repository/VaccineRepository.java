package com.vaccine_service.Repository;

import com.vaccine_service.Entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByChildId(Long childId);
    List<Vaccine> findByVaccineName(String vaccineName);
}
