package com.parent_service.Mapper;

import com.parent_service.DTO.ChildDTO;
import com.parent_service.DTO.ParentDTO;
import com.parent_service.Entity.Child;
import com.parent_service.Entity.Parent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParentMapper {

    //Convert ParentDTO to Parent Entity.
    public Parent convertToEntity(ParentDTO parentDTO){
        Parent parent = new Parent();

        parent.setId(parentDTO.getId());
        parent.setFatherName(parentDTO.getFatherName());
        parent.setMotherName(parentDTO.getMotherName());
        parent.setMobile(parentDTO.getMobile());
        parent.setMailId(parentDTO.getMailId());

        return parent;
    }
    //Convert Parent Entity to ParentDTO
    public ParentDTO convertToDTO(Parent parent){

        ParentDTO parentDTO = new ParentDTO();

        parentDTO.setId(parent.getId());
        parentDTO.setFatherName(parent.getFatherName());
        parentDTO.setMotherName(parent.getMotherName());
        parentDTO.setMobile(parent.getMobile());
        parentDTO.setMailId(parent.getMailId());

        if(parent.getChildren() != null){
            List<ChildDTO> childDTOS = parent.getChildren().stream().map(this::toChildDTO).collect(Collectors.toList());

            parentDTO.setChildren(childDTOS);
        }

        return parentDTO;
    }

    private ChildDTO toChildDTO(Child child) {
        ChildDTO childDTO = new ChildDTO();

        childDTO.setId(child.getId());
        childDTO.setChildName(child.getChildName());
        childDTO.setGender(child.getGender());
        childDTO.setDateOfBirth(child.getDateOfBirth());
        childDTO.setParentId(child.getParent().getId());

        return childDTO;
    }
}
