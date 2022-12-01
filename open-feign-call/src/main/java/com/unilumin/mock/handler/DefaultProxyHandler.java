package com.unilumin.mock.handler;

import com.alibaba.nacos.client.naming.net.HttpClient;
import com.unilumin.mock.config.RemoteCallConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

/**
 * @author zxz
 * @date 2022年12月01日 11:17
 */
public class DefaultProxyHandler implements InvocationHandler {

    private Map<String/*methodName*/, RemoteCallConfig/*remote call params*/> rcMap;

    public DefaultProxyHandler(Map<String, RemoteCallConfig> rcMap) {
        this.rcMap = rcMap;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RemoteCallConfig remoteCallConfig = rcMap.get(method.getName());
        if (remoteCallConfig == null) {
            return null;
        } else {
            HttpClient.HttpResult httpResult = HttpClient.httpGet(remoteCallConfig.getUrl() + remoteCallConfig.getPath(), Collections.emptyList(), Collections.emptyMap(), "UTF-8");
            return httpResult.content;
        }
    }

}
