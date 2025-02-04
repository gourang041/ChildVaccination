package com.child_service.Service.impl;

import com.child_service.DTO.ChildDto;
import com.child_service.DTO.ParentDTO;
import com.child_service.Entity.Child;
import com.child_service.FeignClient.ParentFeignClient;
import com.child_service.Mapper.ChildMapper;
import com.child_service.Repository.ChildRepository;
import com.child_service.Service.ChildService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private ParentFeignClient parentFeignClient;
    @Override
    public ChildDto addChild(ChildDto childDto) {

        try {
            //Check if the parent exists
            ParentDTO parentDTO = parentFeignClient.getParentById(childDto.getParentId());

            if(parentDTO == null){
                throw new RuntimeException("Parent with ID " + childDto.getParentId() + " not found.");
            }

//            Child child = childMapper.convertToEntity(childDto);
//            Child savedChild = childRepository.save(child);

            Child child = new Child();
            child.setChildName(childDto.getChildName());
            child.setGender(childDto.getGender());
            child.setDateOfBirth(childDto.getDateOfBirth());
            child.setParentId(childDto.getParentId());

            Child savedChild = childRepository.save(child);

            return childMapper.convertToDTO(savedChild);

        } catch (FeignException.InternalServerError e) {
            throw new RuntimeException("Parent with ID " + childDto.getParentId() + " not found.");
        }
    }
    @Override
    public ChildDto getChildById(Long id) {

        Child child = childRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Child Not Found"));

        return childMapper.convertToDTO(child);
    }

    @Override
    public List<ChildDto> getAllChildren() {

        List<Child> children = childRepository.findAll();

        return children.stream().map(childMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ChildDto updateChild(Long id, ChildDto childDto) {

        try {
            ParentDTO parentDTO = parentFeignClient.getParentById(childDto.getParentId());

            if(parentDTO == null){
                throw new RuntimeException("Parent with ID " + childDto.getParentId() + " not found.");
            }

            Child existingChild = childRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Child Not Found"));

            existingChild.setChildName(childDto.getChildName());
            existingChild.setGender(childDto.getGender());
            existingChild.setDateOfBirth(childDto.getDateOfBirth());
            existingChild.setParentId(childDto.getParentId());

            Child upadtedChild = childRepository.save(existingChild);
            return childMapper.convertToDTO(upadtedChild);

        } catch (FeignException.InternalServerError e) {
            throw new RuntimeException("Parent with ID " + childDto.getParentId() + " not found.");
        }
    }
        @Override
    public void deleteChildById(Long id) {

            if(childRepository.existsById(id)){
                childRepository.deleteById(id);
            }
            else{
                throw new RuntimeException("Parent not found with id: " + id);
            }
    }
}
