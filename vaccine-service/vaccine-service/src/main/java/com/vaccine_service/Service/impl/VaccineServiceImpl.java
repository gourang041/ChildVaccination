package com.vaccine_service.Service.impl;

import com.vaccine_service.DTO.ChildWithParentDTO;
import com.vaccine_service.DTO.ParentDTO;
import com.vaccine_service.DTO.VaccineDTO;
import com.vaccine_service.Entity.Child;
import com.vaccine_service.Entity.Parent;
import com.vaccine_service.Entity.Vaccine;
import com.vaccine_service.FeignClient.ChildFeignClient;
import com.vaccine_service.Mapper.VaccineMapper;
import com.vaccine_service.Repository.VaccineRepository;
import com.vaccine_service.Service.VaccineService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private ChildFeignClient childFeignClient;

    @Autowired
    private VaccineMapper vaccineMapper;
    @Override
    public VaccineDTO addVaccine(VaccineDTO vaccineDTO) {

        //Fetch child information using Feign Client
        try {
            Child child = childFeignClient.getChildById(vaccineDTO.getChildId());

            if (child == null) {
                throw new RuntimeException("Child not found with ID: " + vaccineDTO.getChildId());
            }

            Vaccine vaccine = new Vaccine();
            vaccine.setVaccineName(vaccineDTO.getVaccineName());
            vaccine.setDateOfAdministration(vaccineDTO.getDateOfAdministration());
            vaccine.setDosage(vaccineDTO.getDosage());

//        Vaccine vaccine = vaccineMapper.toEntity(vaccineDTO);

            vaccine.setChild(child);
            Vaccine savedVaccine = vaccineRepository.save(vaccine);
            return vaccineMapper.toDto(savedVaccine);

        } catch (FeignException.InternalServerError e) {
            throw new RuntimeException("Child with ID " + vaccineDTO.getChildId() + " not found.");
        }
    }

    @Override
    public List<VaccineDTO> getVaccinesByChildId(Long childId) {
        List<Vaccine> vaccines =  vaccineRepository.findByChildId(childId);

        return vaccines.stream().map(vaccineMapper::toDto)
                .collect(Collectors.toList());  //Map each vaccine to VaccineDTO
    }

    @Override
    public void deleteParentById(Long id) {
        if(vaccineRepository.existsById(id)){
            vaccineRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Vaccine not found with id: " + id);
        }
    }

    @Override
    public List<ChildWithParentDTO> getChildrenWithParentByVaccineName(String vaccineName) {
        List<Vaccine> vaccines = vaccineRepository.findByVaccineName(vaccineName);

        //extract child & parent info from the vaccines

        List<ChildWithParentDTO> childrenWithParents = vaccines.stream()
                .map(vaccine -> {
                        Child child = vaccine.getChild();
                        Parent parent = child.getParent();

                        ParentDTO parentDTO = new ParentDTO(parent.getId(), parent.getFatherName(), parent.getMotherName(), parent.getMobile(), parent.getMailId());
                        ChildWithParentDTO childWithParentDTO = new ChildWithParentDTO(child.getId(), child.getChildName(), child.getGender(),
                                child.getDateOfBirth(), parentDTO);

                        return childWithParentDTO;
                })
                .collect(Collectors.toList());


        return childrenWithParents;
    }
}

