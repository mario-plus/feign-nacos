package com.unilumin.mock.register;

import com.unilumin.mock.annocations.RemoteParams;
import com.unilumin.mock.config.RemoteCallConfig;
import com.unilumin.mock.handler.DefaultProxyHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author zxz
 * @date 2022年12月01日 11:18
 */
public class DynamicProxyFactoryBean implements FactoryBean<Object>, InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Class<?> type;
    private String name;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    private String contextId;


    public Object getObject() throws Exception {
        Class<?> objectType = getObjectType();
        Method[] methods = objectType.getMethods();
        HashMap<String, RemoteCallConfig> rcMap = new HashMap<>();
        for (Method method : methods) {
            RemoteParams annotation = method.getDeclaredAnnotation(RemoteParams.class);
            if (annotation != null) {
                rcMap.put(method.getName(), new RemoteCallConfig(annotation.url(), annotation.path()));
            }
        }
        return Proxy.newProxyInstance(Objects.requireNonNull(getObjectType()).getClassLoader(), new Class[]{getObjectType()},
                new DefaultProxyHandler(rcMap));
    }

    public Class<?> getObjectType() {
        return getType();
    }

    public void afterPropertiesSet() throws Exception {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public boolean isSingleton() {
        return true;
    }
}
