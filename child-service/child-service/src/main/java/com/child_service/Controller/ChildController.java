package com.child_service.Controller;

import com.child_service.DTO.ChildDto;
import com.child_service.Entity.Child;
import com.child_service.Repository.ChildRepository;
import com.child_service.Service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    @Autowired
    private ChildService childService;

    @PostMapping
    public ResponseEntity<ChildDto> addChild(@RequestBody ChildDto childDto){

        ChildDto newChild = childService.addChild(childDto);

        return ResponseEntity.ok(newChild);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ChildDto> getChildrenById(@PathVariable Long id){
        ChildDto child = childService.getChildById(id);

        return ResponseEntity.ok(child);
    }

    @GetMapping
    public ResponseEntity<List<ChildDto>> getAllChildren(){
        List<ChildDto> children = childService.getAllChildren();

        return ResponseEntity.ok(children);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChildDto> updateChild(@PathVariable("id") Long id, @RequestBody ChildDto childDto){
        childDto.setId(id);
        ChildDto updatedChild = childService.updateChild(id, childDto);

        return ResponseEntity.ok(updatedChild);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChildById(@PathVariable Long id){
        childService.deleteChildById(id);

        return new ResponseEntity<>("Record is successfully deleted!", HttpStatus.OK);
    }
}

