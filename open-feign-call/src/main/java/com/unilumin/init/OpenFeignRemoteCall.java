package com.unilumin.init;

import com.unilumin.clients.NacosServiceClient;
import com.unilumin.clients.OpenFeignCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zxz
 * @date 2022年11月30日 17:54
 */
@Component
public class OpenFeignRemoteCall {
    @Autowired
    NacosServiceClient nacosServiceClient;

    @Autowired
    OpenFeignCall openFeignCall;

    @PostConstruct
    void call() {
        //WORK
        System.out.println(nacosServiceClient.workAtHome());

        System.out.println(openFeignCall.workAtCompany());

        //meeting
        System.out.println(nacosServiceClient.meeting());

        System.out.println(openFeignCall.meeting());

    }
}
