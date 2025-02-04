package com.vaccine_service.Mapper;

import com.vaccine_service.DTO.VaccineDTO;
import com.vaccine_service.Entity.Child;
import com.vaccine_service.Entity.Vaccine;
import org.springframework.stereotype.Component;

@Component
public class VaccineMapper {

    public Vaccine toEntity(VaccineDTO vaccineDTO){
        if(vaccineDTO == null){
            return null;
        }

        Vaccine vaccine = new Vaccine();
        vaccine.setVaccineName(vaccineDTO.getVaccineName());
        vaccine.setDateOfAdministration(vaccineDTO.getDateOfAdministration());
        vaccine.setDosage(vaccineDTO.getDosage());

        return vaccine;
    }

    public VaccineDTO toDto(Vaccine vaccine){
        if(vaccine == null){
            return null;
        }

        VaccineDTO vaccineDTO = new VaccineDTO();

        vaccineDTO.setId(vaccine.getId());
        vaccineDTO.setVaccineName(vaccine.getVaccineName());
        vaccineDTO.setDateOfAdministration(vaccine.getDateOfAdministration());
        vaccineDTO.setDosage(vaccine.getDosage());
        vaccineDTO.setChildId(vaccine.getChild().getId());

        return vaccineDTO;
    }
}
