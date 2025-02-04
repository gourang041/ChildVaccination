package com.vaccine_service.Service;

import com.vaccine_service.DTO.ChildWithParentDTO;
import com.vaccine_service.DTO.VaccineDTO;
import com.vaccine_service.Entity.Child;
import com.vaccine_service.Entity.Vaccine;

import java.util.List;

public interface VaccineService {

    VaccineDTO addVaccine(VaccineDTO vaccineDTO);
    List<VaccineDTO> getVaccinesByChildId(Long childId);

    void deleteParentById(Long id);

    List<ChildWithParentDTO> getChildrenWithParentByVaccineName(String vaccineName);
}
