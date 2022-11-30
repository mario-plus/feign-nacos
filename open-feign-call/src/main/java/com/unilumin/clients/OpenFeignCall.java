package com.unilumin.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zxz
 * @date 2022年11月30日 17:45
 */
@FeignClient(url = "127.0.0.1:6001",value = "serviceId")
public interface OpenFeignCall {
    @GetMapping("/doWork")
    String workAtCompany();

    @PostMapping("meeting")
    String meeting();
}
