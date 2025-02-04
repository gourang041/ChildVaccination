package com.parent_service.Service;

import com.parent_service.DTO.ParentDTO;

public interface ParentService {

    ParentDTO registerParent(ParentDTO parentRequestDTO);
    ParentDTO getParentById(Long id);

    ParentDTO updateParent(Long id, ParentDTO parentRequestDTO);

    void deleteParentById(Long id);
}
