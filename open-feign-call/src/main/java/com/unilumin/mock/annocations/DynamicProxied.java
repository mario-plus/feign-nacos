package com.unilumin.mock.annocations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicProxied {

    String value() default "";

}
