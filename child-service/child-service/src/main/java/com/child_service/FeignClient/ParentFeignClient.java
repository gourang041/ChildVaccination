package com.child_service.FeignClient;

import com.child_service.DTO.ParentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "parent-service", url = "http://localhost:8081/api/parents")
@FeignClient(name = "parent-service")
public interface ParentFeignClient {

    @GetMapping("/api/parents/{id}")
    ParentDTO getParentById(@PathVariable("id") Long id);
}
