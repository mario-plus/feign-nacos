package com.unilumin.init;

import com.unilumin.clients.NacosServiceClient;
import com.unilumin.clients.OpenFeignCall;
import com.unilumin.mock.api.DynamicService;
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
    NacosServiceClient nacosServiceClient;//代理对象

    @Autowired
    OpenFeignCall openFeignCall;//代理对象

    @Autowired
    DynamicService dynamicService;

    @PostConstruct
    void call() {
        //WORK
        System.out.println(nacosServiceClient.workAtHome());

        System.out.println(openFeignCall.workAtCompany());

        //meeting
        System.out.println(nacosServiceClient.meeting());

        System.out.println(openFeignCall.meeting());

        //模拟openFeign原理，生成的动态代理类，通过httpClient远程调用
        System.out.println(dynamicService.remoteCall("Dynamic"));
    }
}
