package com.unilumin;

import com.unilumin.mock.annocations.EnableDynamicProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zxz
 * @date 2022年11月30日 17:40
 */
@EnableFeignClients
@SpringBootApplication
@EnableDynamicProxy
public class OpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class);
    }
}
