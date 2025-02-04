package com.child_service.Service;

import com.child_service.DTO.ChildDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildService{

    ChildDto addChild(ChildDto childDto);

    ChildDto getChildById(Long id);

    List<ChildDto> getAllChildren();

    ChildDto updateChild(Long id, ChildDto childDto);

    void deleteChildById(Long id);
}
