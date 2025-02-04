package com.vaccine_service.Controller;

import com.vaccine_service.DTO.ChildWithParentDTO;
import com.vaccine_service.DTO.VaccineDTO;
import com.vaccine_service.Entity.Child;
import com.vaccine_service.Entity.Vaccine;
import com.vaccine_service.Service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vaccines")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping
    public ResponseEntity<VaccineDTO> addVaccine(@RequestBody VaccineDTO vaccineDTO){

        VaccineDTO vaccineDto = vaccineService.addVaccine(vaccineDTO);

        return ResponseEntity.ok(vaccineDto);
    }

    @GetMapping("/child/{childId}")
    public ResponseEntity<List<VaccineDTO>> getVaccinesByChild(@PathVariable Long childId){
        List<VaccineDTO> vaccines = vaccineService.getVaccinesByChildId(childId);

        return ResponseEntity.ok(vaccines);
    }

    @DeleteMapping("{id}")
    public String deleteParentById(@PathVariable Long id){
        vaccineService.deleteParentById(id);

        return "Vaccine deleted successfully with id: " + id;
    }

    @GetMapping("/children-parents-by-vaccine/{vaccineName}")
    public ResponseEntity<List<ChildWithParentDTO>> getChildrenAndParentsByVaccineName(@PathVariable String vaccineName){

        List<ChildWithParentDTO> childWithParents = vaccineService.getChildrenWithParentByVaccineName(vaccineName);
        return ResponseEntity.ok(childWithParents);
    }
}
