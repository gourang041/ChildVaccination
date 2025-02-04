package com.child_service.Mapper;

import com.child_service.DTO.ChildDto;
import com.child_service.Entity.Child;
import org.springframework.stereotype.Component;

@Component
public class ChildMapper {

    //Convert ChildDTO to Child Entity.

    public Child convertToEntity(ChildDto childDto){

        Child child = new Child();

        child.setId(childDto.getId());
        child.setChildName(childDto.getChildName());
        child.setGender(childDto.getGender());
        child.setDateOfBirth(childDto.getDateOfBirth());
        child.setParentId(childDto.getParentId());

        return child;
    }

    //Convert Child Entity to ChildDTO
    public ChildDto convertToDTO(Child child) {

        ChildDto childDto = new ChildDto();

        childDto.setId(child.getId());
        childDto.setChildName(child.getChildName());
        childDto.setGender(child.getGender());
        childDto.setDateOfBirth(child.getDateOfBirth());
        childDto.setParentId(child.getParentId());

        return childDto;
    }
}
