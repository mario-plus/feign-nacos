package com.unilumin.mock.annocations;

import com.unilumin.mock.register.DynamicProxyRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DynamicProxyRegister.class)
public @interface EnableDynamicProxy {

}
