package com.unilumin.mock.annocations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RemoteParams {
    String url() default "";//包含端口的url

    String path() default "";//请求路径
}
