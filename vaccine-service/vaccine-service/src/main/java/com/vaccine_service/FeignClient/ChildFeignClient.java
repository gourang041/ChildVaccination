package com.vaccine_service.FeignClient;
import com.vaccine_service.Entity.Child;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "child-service")
public interface ChildFeignClient {

    @GetMapping("api/children/{id}")
    Child getChildById(@PathVariable("id") Long id);
}
