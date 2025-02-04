package com.parent_service.Service.impl;

import com.parent_service.DTO.ParentDTO;
import com.parent_service.Entity.Child;
import com.parent_service.Entity.Parent;
import com.parent_service.Mapper.ParentMapper;
import com.parent_service.Repository.ParentRepository;
import com.parent_service.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ParentMapper parentMapper;

    @Override
    public ParentDTO registerParent(ParentDTO parentDTO) {

        Parent parent = parentMapper.convertToEntity(parentDTO);

        if(parentDTO.getChildren() != null){
            List<Child> children = parentDTO.getChildren().stream().map(childDTO -> {

                Child child = new Child();
                child.setChildName(childDTO.getChildName());
                child.setGender(childDTO.getGender());
                child.setDateOfBirth(childDTO.getDateOfBirth());
                child.setParent(parent);

            return child;
            }).collect(Collectors.toList());

            parent.setChildren(children);
        }
        Parent savedParent = parentRepository.save(parent);

        return parentMapper.convertToDTO(savedParent);
    }

    @Override
    public ParentDTO getParentById(Long id) {

        Parent parent = parentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Parent not Found"));

        return parentMapper.convertToDTO(parent);
    }

    @Override
    public ParentDTO updateParent(Long id, ParentDTO parentRequestDTO) {

        Optional<Parent> optionalParent = parentRepository.findById(id);

        if(optionalParent.isPresent()){

            Parent existingParent = optionalParent.get();

            existingParent.setFatherName(parentRequestDTO.getFatherName());
            existingParent.setMotherName(parentRequestDTO.getMotherName());
            existingParent.setMobile(parentRequestDTO.getMobile());
            existingParent.setMailId(parentRequestDTO.getMailId());

            Parent updatedParent = parentRepository.save(existingParent);

            return parentMapper.convertToDTO(updatedParent);
        }else{
            throw new RuntimeException("Parent not Found");
        }

//        Parent existingParent = parentRepository.findById(parentRequestDTO.getId()).orElseThrow(() ->
//                new RuntimeException("Parent not Found"));
//
//        existingParent.setFatherName(parentRequestDTO.getFatherName());
//        existingParent.setMotherName(parentRequestDTO.getMotherName());
//        existingParent.setMobile(parentRequestDTO.getMobile());
//        existingParent.setMailId(parentRequestDTO.getMailId());
//
//        Parent updatedParent = parentRepository.save(existingParent);

//        return parentMapper.convertToDTO(updatedParent);
    }

    @Override
    public void deleteParentById(Long id) {
        if(parentRepository.existsById(id)){

            parentRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Parent not found with id: " + id);
        }
    }
}
