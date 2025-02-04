package com.parent_service.Controller;

import com.parent_service.DTO.ParentDTO;
import com.parent_service.Entity.Parent;
import com.parent_service.Repository.ParentRepository;
import com.parent_service.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    public ParentDTO registerParent(@RequestBody ParentDTO parentDTO) {
        return parentService.registerParent(parentDTO);
    }

    @GetMapping("/{id}")
    public ParentDTO getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentDTO> updateParent(@PathVariable("id") Long id, @RequestBody ParentDTO parentDTO){
//        parentDTO.setId(id);
        ParentDTO updatedParent = parentService.updateParent(id, parentDTO);

        return new ResponseEntity<>(updatedParent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String deleteParentById(@PathVariable Long id){
        parentService.deleteParentById(id);

        return "Parent deleted successfully with id: " + id;
    }
}
