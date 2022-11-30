package com.unilumin.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zxz
 * @date 2022年11月30日 17:43
 */

@FeignClient(value = "nacos-service-provider")
public interface NacosServiceClient {
    @GetMapping("/doWork")
    String workAtHome();

    @PostMapping("meeting")
    String meeting();
}
